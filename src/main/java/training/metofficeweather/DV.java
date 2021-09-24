package training.metofficeweather;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DV{
    public Date dataDate;
    public String type;
    @JsonProperty("Location")
    public LocationForWeather location;

    public Date getDataDate() {
        return dataDate;
    }

    public String getType() {
        return type;
    }

    public LocationForWeather getLocationForWeather() {
        return location;
    }

    @Override
    public String toString() {
        return "DV{" +
                "dataDate=" + dataDate +
                ", type='" + type + '\'' +
                ", location=" + location +
                '}';
    }
}
