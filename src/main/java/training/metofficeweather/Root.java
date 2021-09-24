package training.metofficeweather;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
@JsonIgnoreProperties(ignoreUnknown = true)
public class Root{
    @JsonProperty("SiteRep")
    public SiteRep siteRep;

    public SiteRep getSiteRep() {
        return siteRep;
    }

    @Override
    public String toString() {
        return "Root{" +
                "siteRep=" + siteRep +
                '}';
    }
}
