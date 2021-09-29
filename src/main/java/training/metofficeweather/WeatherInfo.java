package training.metofficeweather;

import training.metofficeweather.data.weatherInformatioin.WeatherReport;

public class WeatherInfo {
    private final WeatherReport weatherInformation;
    private final String cityName;


    public WeatherInfo(WeatherReport weatherInformation, String cityName) {
        this.cityName = cityName;
        this.weatherInformation = weatherInformation;
    }

    public WeatherReport getWeatherInformation() {
        return weatherInformation;
    }

    public String getCityName() {
        return cityName;
    }

}
