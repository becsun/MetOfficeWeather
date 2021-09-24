package training.metofficeweather;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Rep{
    @JsonProperty("D")
    public String d;
    @JsonProperty("F")
    public String f;
    @JsonProperty("G")
    public String g;
    @JsonProperty("H")
    public String h;
    @JsonProperty("Pp")
    public String pp;
    @JsonProperty("S")
    public String s;
    @JsonProperty("T")
    public String t;
    @JsonProperty("V")
    public String v;
    @JsonProperty("W")
    public String w;
    @JsonProperty("U")
    public String u;
    @JsonProperty("$")
    public String weatherDescription;
}
