package training.metofficeweather;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.glassfish.jersey.jackson.JacksonFeature;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;


public class Main {
    private static String apiKey = PropertiesReader.getProperty("API_KEY");

    static final String siteUrl = "http://datapoint.metoffice.gov.uk/public/data/val/wxfcs/all/json/sitelist?key=" + apiKey;

    static final Logger theLogger = LogManager.getLogger("Weather");

    public static void main(String args[]) {

        theLogger.info("Application Started");

        Client client = ClientBuilder.newBuilder().register(JacksonFeature.class).build();
        Locations retrieve = client.target(siteUrl)
                .request(MediaType.APPLICATION_JSON)
                .get(Locations.class);

        theLogger.info("Got {}", retrieve);

        ArrayList<LocationInformation> locationsList = new ArrayList<>();
        HashMap<String, String> locationKeys = new HashMap<>();
        Location listOfLocations = retrieve.getLocation();
        listOfLocations.streamLocationInformation().forEach(e -> locationKeys.put(e.getName(), e.getId()));
        listOfLocations.streamLocationInformation().sorted(Comparator.comparing(LocationInformation::getName)).forEach(locationsList::add);
        locationsList.forEach(e -> System.out.println(e.getName()));

        System.out.println("Which location are you interested in?");
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();

        String siteUrlForChosenCity = "http://datapoint.metoffice.gov.uk/public/data/val/wxfcs/all/json/" + locationKeys.get(userInput) + "?res=3hourly&key=" + apiKey;


        Root retrieveWeather = client.target(siteUrlForChosenCity)
                .request(MediaType.APPLICATION_JSON)
                .get(Root.class);

        Rep weatherInformation = retrieveWeather.getSiteRep().getdV().getLocationForWeather().getPeriod().get(0).getRep().get(0);
        String weatherTypeNumber = weatherInformation.getWeather();
        String temperature = weatherInformation.getTemperature();

        System.out.println("The weather in " + userInput + " is " + getWeatherType(weatherTypeNumber) + " and the temperature is " + temperature + "\u00B0C");
    }

    public static String getWeatherType(String weatherTypeNumber) {
        String weatherType = null;
        switch (weatherTypeNumber) {
            case "0":
                weatherType = "Clear night";
                break;
            case "1":
                weatherType = "Sunny day";
                break;
            case "2":
                weatherType = "Partly cloudy (night)";
                break;
            case "3":
                weatherType = "Partly cloudy (day)";
                break;
            case "4":
                weatherType = "Not used";
                break;
            case "5":
                weatherType = "Mist";
                break;
            case "6":
                weatherType = "Fog";
                break;
            case "7":
                weatherType = "Cloudy";
                break;
            case "8":
                weatherType = "Overcast";
                break;
            case "9":
                weatherType = "Light rain shower (night)";
                break;
            case "10":
                weatherType = "Light rain shower (day)";
                break;
            case "11":
                weatherType = "Drizzle";
                break;
            case "12":
                weatherType = "Light rain";
                break;
            case "13":
                weatherType = "Heavy rain shower (night)";
                break;
            case "14":
                weatherType = "Heavy rain shower (day)";
                break;
            case "15":
                weatherType = "Heavy rain";
                break;
            case "16":
                weatherType = "Sleet Shower (night)";
                break;
            case "17":
                weatherType = "Sleet Shower (day)";
                break;
            case "18":
                weatherType = "Sleet";
                break;
            case "19":
                weatherType = "Hail shower (night)";
                break;
            case "20":
                weatherType = "Hail shower (day)";
                break;
            case "21":
                weatherType = "Hail";
                break;
            case "22":
                weatherType = "Light now shower(night)";
                break;
            case "23":
                weatherType = "Light snow shower(day)";
                break;
            case "24":
                weatherType = "Light snow";
                break;
            case "25":
                weatherType = "Heavy snow shower (night)";
                break;
            case "26":
                weatherType = "Heavy snow shower (day)";
                break;
            case "27":
                weatherType = "Heavy snow";
                break;
            case "28":
                weatherType = "Thunder shower(night)";
                break;
            case "29":
                weatherType = "Thunder shower day";
                break;
            case "30":
                weatherType = "Thunder";
                break;
            default:
                weatherType = "Not available";
        }
        return weatherType;
    }
}	
