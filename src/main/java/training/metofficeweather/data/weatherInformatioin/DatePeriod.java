package training.metofficeweather.data.weatherInformatioin;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;


;import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)

public class DatePeriod {
    public String type;
    public String value;
    @JsonProperty("Rep")
    public ArrayList<WeatherReport> weatherReport;

    public String getType() {
        return type;
    }

    public String getValue() {
        return value;
    }

    public ArrayList<WeatherReport> getWeatherReport() {
        return weatherReport;
    }

    @Override
    public String toString() {
        return "Period{" +
                "type='" + type + '\'' +
                ", value='" + value + '\'' +
                ", rep=" + weatherReport +
                '}';
    }
}