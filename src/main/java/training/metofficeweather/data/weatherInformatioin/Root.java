package training.metofficeweather.data.weatherInformatioin;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Root{
    @JsonProperty("SiteRep")
    public SiteRep siteRep;

    public SiteRep getSiteRep() {
        return siteRep;
    }

    public static WeatherReport getWeatherInformationForChosenCity(Root retrieveWeather) {
        return retrieveWeather.getSiteRep().getLocationData().getLocationForWeather().getPeriod().get(0).getWeatherReport().get(0);
    }

    public static ArrayList<DatePeriod> getNextFiveDaysWeatherForChosenCity(Root retrieveWeather) {
        return retrieveWeather.getSiteRep().getLocationData().getLocationForWeather().getPeriod();
    }

    public static LocationForWeather getLocationForChosenCity(Root retrieveWeather) {
        return retrieveWeather.getSiteRep().getLocationData().getLocationForWeather();
    }

    public void weatherReport(String userInput, Root retrieveWeather) {
        WeatherReport weatherInformation = getWeatherInformationForChosenCity(retrieveWeather);

        String weatherType = weatherInformation.getWeatherType().get(0);
        Integer temperature = weatherInformation.getTemperature();


        System.out.println("The weather forecast in " + userInput + " is " + weatherType + " and the temperature will be " + temperature + "\u00B0C");

    }

    @Override
    public String toString() {
        return "Root{" +
                "siteRep=" + siteRep +
                '}';
    }
}
