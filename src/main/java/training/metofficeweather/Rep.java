package training.metofficeweather;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
@JsonIgnoreProperties(ignoreUnknown = true)
public class Rep{
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
