package training.metofficeweather;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Wx{
    @JsonProperty("Param")
    public List<Param> param;
}