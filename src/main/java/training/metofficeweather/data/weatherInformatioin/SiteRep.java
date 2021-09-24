package training.metofficeweather.data.weatherInformatioin;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SiteRep{
    @JsonProperty("Wx")
    public WeatherInfo weatherInfo;
    @JsonProperty("DV")
    public LocationData locationData;

    public WeatherInfo getWeatherInfo() {
        return weatherInfo;
    }

    public LocationData getLocationData() {
        return locationData;
    }

    @Override
    public String toString() {
        return "SiteRep{" +
                "wx=" + weatherInfo +
                ", dV=" + locationData +
                '}';
    }
}