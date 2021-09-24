package training.metofficeweather.data.weatherInformatioin;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherParameters {
    public String name;
    public String units;
    @JsonProperty("$")
    public String weatherDescription;

    @Override
    public String toString() {
        return "Param{" +
                "name='" + name + '\'' +
                ", units='" + units + '\'' +
                ", weatherDescription='" + weatherDescription + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public String getUnits() {
        return units;
    }

    public String getWeatherDescription() {
        return weatherDescription;
    }
}
