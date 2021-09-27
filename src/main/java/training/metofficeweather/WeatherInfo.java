package training.metofficeweather;

import training.metofficeweather.data.weatherInformatioin.WeatherReport;

public class WeatherInfo {
    private final WeatherReport weatherInformation;

    public WeatherInfo(WeatherReport weatherInformation) {
        this.weatherInformation = weatherInformation;
    }

    public WeatherReport getWeatherInformation() {
        return weatherInformation;
    }

}
