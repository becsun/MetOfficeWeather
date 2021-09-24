package training.metofficeweather.data.weatherInformatioin;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherInfo {
    @JsonProperty("Param")
    public ArrayList<WeatherParameters> param;

    public ArrayList<WeatherParameters> getParam() {
        return param;
    }

    @Override
    public String toString() {
        return "Wx{" +
                "param=" + param +
                '}';
    }
}