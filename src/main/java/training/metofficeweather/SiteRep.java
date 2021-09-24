package training.metofficeweather;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SiteRep{
    @JsonProperty("Wx")
    public Wx wx;
    @JsonProperty("DV")
    public DV dV;
}