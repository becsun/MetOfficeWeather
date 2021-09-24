package training.metofficeweather;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
@JsonIgnoreProperties(ignoreUnknown = true)
public class SiteRep{
    @JsonProperty("Wx")
    public Wx wx;
    @JsonProperty("DV")
    public DV dV;

    public Wx getWx() {
        return wx;
    }

    public DV getdV() {
        return dV;
    }

    @Override
    public String toString() {
        return "SiteRep{" +
                "wx=" + wx +
                ", dV=" + dV +
                '}';
    }
}