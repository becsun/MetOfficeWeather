package training.metofficeweather.data.weatherInformatioin;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherReport {
    @JsonProperty("D")
    public String windDirection;
    @JsonProperty("F")
    public String feelsLikeTemp;
    @JsonProperty("G")
    public String windGust;
    @JsonProperty("H")
    public String relativeHumidity;
    @JsonProperty("Pp")
    public String precipitationProbability;
    @JsonProperty("S")
    public String windSpeed;
    @JsonProperty("T")
    public String temperature;
    @JsonProperty("V")
    public String visibility;
    @JsonProperty("W")
    public String weather;
    @JsonProperty("U")
    public String ultraviolet;
    @JsonProperty("$")
    public String minutesAfterMidnight;

    public String getWindDirection() {
        return windDirection;
    }

    public String getFeelsLikeTemp() {
        return feelsLikeTemp;
    }

    public String getWindGust() {
        return windGust;
    }

    public String getRelativeHumidity() {
        return relativeHumidity;
    }

    public String getPrecipitationProbability() {
        return precipitationProbability;
    }

    public String getWindSpeed() {
        return windSpeed;
    }

    public String getTemperature() {
        return temperature;
    }

    public String getVisibility() {
        return visibility;
    }

    public String getWeather() {
        return weather;
    }

    public String getUltraviolet() {
        return ultraviolet;
    }

    public String getMinutesAfterMidnight() {
        return minutesAfterMidnight;
    }

    public String getWeatherType(WeatherReport weatherInformation) {
        String weatherType = null;
        switch (weatherInformation.getWeather()) {
            case "0":
                weatherType = "Clear night";
                break;
            case "1":
                weatherType = "Sunny day";
                break;
            case "2":
                weatherType = "Partly cloudy (night)";
                break;
            case "3":
                weatherType = "Partly cloudy (day)";
                break;
            case "4":
                weatherType = "Not used";
                break;
            case "5":
                weatherType = "Mist";
                break;
            case "6":
                weatherType = "Fog";
                break;
            case "7":
                weatherType = "Cloudy";
                break;
            case "8":
                weatherType = "Overcast";
                break;
            case "9":
                weatherType = "Light rain shower (night)";
                break;
            case "10":
                weatherType = "Light rain shower (day)";
                break;
            case "11":
                weatherType = "Drizzle";
                break;
            case "12":
                weatherType = "Light rain";
                break;
            case "13":
                weatherType = "Heavy rain shower (night)";
                break;
            case "14":
                weatherType = "Heavy rain shower (day)";
                break;
            case "15":
                weatherType = "Heavy rain";
                break;
            case "16":
                weatherType = "Sleet Shower (night)";
                break;
            case "17":
                weatherType = "Sleet Shower (day)";
                break;
            case "18":
                weatherType = "Sleet";
                break;
            case "19":
                weatherType = "Hail shower (night)";
                break;
            case "20":
                weatherType = "Hail shower (day)";
                break;
            case "21":
                weatherType = "Hail";
                break;
            case "22":
                weatherType = "Light now shower(night)";
                break;
            case "23":
                weatherType = "Light snow shower(day)";
                break;
            case "24":
                weatherType = "Light snow";
                break;
            case "25":
                weatherType = "Heavy snow shower (night)";
                break;
            case "26":
                weatherType = "Heavy snow shower (day)";
                break;
            case "27":
                weatherType = "Heavy snow";
                break;
            case "28":
                weatherType = "Thunder shower(night)";
                break;
            case "29":
                weatherType = "Thunder shower day";
                break;
            case "30":
                weatherType = "Thunder";
                break;
            default:
                weatherType = "Not available";
        }
        return weatherType;
    }

    @Override
    public String toString() {
        return "Rep{" +
                "d='" + windDirection + '\'' +
                ", f='" + feelsLikeTemp + '\'' +
                ", g='" + windGust + '\'' +
                ", h='" + relativeHumidity + '\'' +
                ", pp='" + precipitationProbability + '\'' +
                ", s='" + windSpeed + '\'' +
                ", t='" + temperature + '\'' +
                ", v='" + visibility + '\'' +
                ", w='" + weather + '\'' +
                ", u='" + ultraviolet + '\'' +
                ", minutesAfterMidnight='" + minutesAfterMidnight + '\'' +
                '}';
    }
}
