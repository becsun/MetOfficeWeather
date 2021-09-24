package training.metofficeweather;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Param{
    public String name;
    public String units;
    @JsonProperty("$")
    public String weatherDescription;
}
