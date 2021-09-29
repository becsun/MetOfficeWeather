package training.metofficeweather;

import training.metofficeweather.data.weatherInformatioin.DatePeriod;
import training.metofficeweather.data.weatherInformatioin.WeatherReport;

import java.util.ArrayList;

public class WeatherInfo {
    private final ArrayList<DatePeriod> weatherInformationForFiveDays;
    private final String cityName;

    public WeatherInfo(ArrayList<DatePeriod> weatherInformationForFiveDays, String cityName) {
        this.cityName = cityName;
        this.weatherInformationForFiveDays = weatherInformationForFiveDays;
    }

    public ArrayList<DatePeriod> getWeatherInformationForFiveDays() {
        return weatherInformationForFiveDays;
    }

    public String getCityName() {
        return cityName;
    }

}
