package training.metofficeweather.data.weatherInformatioin;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)

public class DatePeriod {
    public String type;
    @JsonProperty("value")
    public String date;
    @JsonProperty("Rep")
    public ArrayList<WeatherReport> weatherReport;

    public String getType() {
        return type;
    }

    public String getDate() {
        return date;
    }

    public String getProperDate() {
        return date.substring(0,10);
    }

    public DayOfWeek getDayOfWeek() {
        return DayOfWeek.from(LocalDate.parse(getProperDate()));
    }

    public ArrayList<WeatherReport> getWeatherReport() {
        return weatherReport;
    }

    @Override
    public String toString() {
        return "Period{" +
                "type='" + type + '\'' +
                ", value='" + date + '\'' +
                ", rep=" + weatherReport +
                '}';
    }
}