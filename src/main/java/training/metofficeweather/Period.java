package training.metofficeweather;

import com.fasterxml.jackson.annotation.JsonProperty;


;import java.util.List;

public class Period{
    public String type;
    public String value;
    @JsonProperty("Rep")
    public List<Rep> rep;
}