package training.metofficeweather.data.weatherInformatioin;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;

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
    public Integer temperature;
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

    public Integer getTemperature() {
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


        public String getHourAfterMidnight () {
            Integer hour = Integer.parseInt(minutesAfterMidnight) / 60;
            return hour.toString() + ":00";
        }

        public BigDecimal getDegree () {
            HashMap<String, BigDecimal> directionHash = new HashMap<>();
            directionHash.put("W", new BigDecimal(0));
            directionHash.put("WSW", new BigDecimal(22.5));
            directionHash.put("SW", new BigDecimal(45));
            directionHash.put("SSW", new BigDecimal(67.5));
            directionHash.put("S", new BigDecimal(90));
            directionHash.put("SSE", new BigDecimal(112.5));
            directionHash.put("SE", new BigDecimal(135));
            directionHash.put("ESE", new BigDecimal(157.5));
            directionHash.put("E", new BigDecimal(180));
            directionHash.put("ENE", new BigDecimal(202.5));
            directionHash.put("NE", new BigDecimal(225));
            directionHash.put("NNE", new BigDecimal(247.5));
            directionHash.put("N", new BigDecimal(270));
            directionHash.put("NNW", new BigDecimal(292.5));
            directionHash.put("NW", new BigDecimal(315));
            directionHash.put("WNW", new BigDecimal(337.5));

            return directionHash.get(getWindDirection());
        }

        public ArrayList<String> getWeatherType () {
            String weatherType = null;
            String imgUrl = null;
            switch (getWeather()) {
                case "0":
                    weatherType = "Clear night";
                    imgUrl = "https://c.tenor.com/oTcZSUT5fD4AAAAj/night-good-night.gif";
                    break;
                case "1":
                    weatherType = "Sunny day";
                    imgUrl = "https://c.tenor.com/ZGRxs0nSXccAAAAj/sunny-day-sunny.gif";
                    break;
                case "2":
                    weatherType = "Partly cloudy (night)";
                    imgUrl = "https://c.tenor.com/z1ByD1fzGpkAAAAj/sun-cloudy.gif";
                    break;
                case "3":
                    weatherType = "Partly cloudy (day)";
                    imgUrl = "https://c.tenor.com/z1ByD1fzGpkAAAAj/sun-cloudy.gif";
                    break;
                case "4":
                    weatherType = "Not used";
                    imgUrl = "https://c.tenor.com/xhUK6GDt884AAAAd/seasons-tree.gif";
                    break;
                case "5":
                    weatherType = "Mist";
                    imgUrl = "https://c.tenor.com/5ImWLS5QAJgAAAAd/foggy-fog.gif";
                    break;
                case "6":
                    weatherType = "Fog";
                    imgUrl = "https://c.tenor.com/5ImWLS5QAJgAAAAd/foggy-fog.gif";
                    break;
                case "7":
                    weatherType = "Cloudy";
                    imgUrl = "https://c.tenor.com/z1ByD1fzGpkAAAAj/sun-cloudy.gif";
                    break;
                case "8":
                    weatherType = "Overcast";
                    imgUrl = "https://c.tenor.com/z1ByD1fzGpkAAAAj/sun-cloudy.gif";
                    break;
                case "9":
                    weatherType = "Light rain shower (night)";
                    imgUrl = "https://c.tenor.com/z3204ApJqw0AAAAj/rain-cloud.gif";
                    break;
                case "10":
                    weatherType = "Light rain shower (day)";
                    imgUrl = "https://c.tenor.com/z3204ApJqw0AAAAj/rain-cloud.gif";
                    break;
                case "11":
                    weatherType = "Drizzle";
                    imgUrl = "https://c.tenor.com/z3204ApJqw0AAAAj/rain-cloud.gif";
                    break;
                case "12":
                    weatherType = "Light rain";
                    imgUrl = "https://c.tenor.com/z3204ApJqw0AAAAj/rain-cloud.gif";
                    break;
                case "13":
                    weatherType = "Heavy rain shower (night)";
                    imgUrl = "https://c.tenor.com/I6dc5dc0jucAAAAj/positive-hujan.gif";
                    break;
                case "14":
                    weatherType = "Heavy rain shower (day)";
                    imgUrl = "https://c.tenor.com/I6dc5dc0jucAAAAj/positive-hujan.gif";
                    break;
                case "15":
                    weatherType = "Heavy rain";
                    imgUrl = "https://c.tenor.com/I6dc5dc0jucAAAAj/positive-hujan.gif";
                    break;
                case "16":
                    weatherType = "Sleet Shower (night)";
                    imgUrl = "https://c.tenor.com/z3204ApJqw0AAAAj/rain-cloud.gif";
                    break;
                case "17":
                    weatherType = "Sleet Shower (day)";
                    imgUrl = "https://c.tenor.com/z3204ApJqw0AAAAj/rain-cloud.gif";
                    break;
                case "18":
                    weatherType = "Sleet";
                    imgUrl = "https://c.tenor.com/z3204ApJqw0AAAAj/rain-cloud.gif";
                    break;
                case "19":
                    weatherType = "Hail shower (night)";
                    imgUrl = "https://c.tenor.com/I6dc5dc0jucAAAAj/positive-hujan.gif";
                    break;
                case "20":
                    weatherType = "Hail shower (day)";
                    imgUrl = "https://c.tenor.com/I6dc5dc0jucAAAAj/positive-hujan.gif";
                    break;
                case "21":
                    weatherType = "Hail";
                    imgUrl = "https://c.tenor.com/I6dc5dc0jucAAAAj/positive-hujan.gif";
                    break;
                case "22":
                    weatherType = "Light snow shower(night)";
                    imgUrl = "https://c.tenor.com/LLbq1xyBWXcAAAAj/cat-snow.gif";
                    break;
                case "23":
                    weatherType = "Light snow shower(day)";
                    imgUrl = "https://c.tenor.com/LLbq1xyBWXcAAAAj/cat-snow.gif";
                    break;
                case "24":
                    weatherType = "Light snow";
                    imgUrl = "https://c.tenor.com/LLbq1xyBWXcAAAAj/cat-snow.gif";
                    break;
                case "25":
                    weatherType = "Heavy snow shower (night)";
                    imgUrl = "https://c.tenor.com/sGEIOMo5LxoAAAAj/%E5%AF%92%E3%81%84-%E3%81%86%E3%81%95%E3%81%8E%E3%82%85%E3%83%BC%E3%82%93.gif";
                    break;
                case "26":
                    weatherType = "Heavy snow shower (day)";
                    imgUrl = "https://c.tenor.com/sGEIOMo5LxoAAAAj/%E5%AF%92%E3%81%84-%E3%81%86%E3%81%95%E3%81%8E%E3%82%85%E3%83%BC%E3%82%93.gif";
                    break;
                case "27":
                    weatherType = "Heavy snow";
                    imgUrl = "https://c.tenor.com/sGEIOMo5LxoAAAAj/%E5%AF%92%E3%81%84-%E3%81%86%E3%81%95%E3%81%8E%E3%82%85%E3%83%BC%E3%82%93.gif";
                    break;
                case "28":
                    weatherType = "Thunder shower(night)";
                    imgUrl = "https://c.tenor.com/I6dc5dc0jucAAAAj/positive-hujan.gif";
                    break;
                case "29":
                    weatherType = "Thunder shower day";
                    imgUrl = "https://c.tenor.com/I6dc5dc0jucAAAAj/positive-hujan.gif";
                    break;
                case "30":
                    weatherType = "Thunder";
                    imgUrl = "https://c.tenor.com/I6dc5dc0jucAAAAj/positive-hujan.gif";
                    break;
                default:
                    weatherType = "Not available";
                    imgUrl = "https://c.tenor.com/xhUK6GDt884AAAAd/seasons-tree.gif";
            }
            ArrayList<String> returnArray = new ArrayList<>();
            returnArray.add(weatherType);
            returnArray.add(imgUrl);
            return returnArray;
        }

        @Override
        public String toString () {
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

