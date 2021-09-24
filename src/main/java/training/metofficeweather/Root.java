package training.metofficeweather;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Root{
    @JsonProperty("SiteRep")
    public SiteRep siteRep;
}
