package training.metofficeweather;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
@JsonIgnoreProperties(ignoreUnknown = true)
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

    public String getD() {
        return d;
    }

    public String getF() {
        return f;
    }

    public String getG() {
        return g;
    }

    public String getH() {
        return h;
    }

    public String getPp() {
        return pp;
    }

    public String getS() {
        return s;
    }

    public String getT() {
        return t;
    }

    public String getV() {
        return v;
    }

    public String getW() {
        return w;
    }

    public String getU() {
        return u;
    }

    public String getWeatherDescription() {
        return weatherDescription;
    }

    @Override
    public String toString() {
        return "Rep{" +
                "d='" + d + '\'' +
                ", f='" + f + '\'' +
                ", g='" + g + '\'' +
                ", h='" + h + '\'' +
                ", pp='" + pp + '\'' +
                ", s='" + s + '\'' +
                ", t='" + t + '\'' +
                ", v='" + v + '\'' +
                ", w='" + w + '\'' +
                ", u='" + u + '\'' +
                ", weatherDescription='" + weatherDescription + '\'' +
                '}';
    }
}
