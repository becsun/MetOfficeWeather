package training.metofficeweather;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class DV{
    public Date dataDate;
    public String type;
    @JsonProperty("Location")
    public LocationForWeather location;
}
