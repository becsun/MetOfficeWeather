package training.metofficeweather;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.glassfish.jersey.jackson.JacksonFeature;
import training.metofficeweather.data.loctionInformation.Location;
import training.metofficeweather.data.loctionInformation.LocationInformation;
import training.metofficeweather.data.loctionInformation.Locations;
import training.metofficeweather.data.weatherInformatioin.WeatherReport;
import training.metofficeweather.data.weatherInformatioin.Root;

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
        Locations retrieveLocations = client.target(siteUrl)
                .request(MediaType.APPLICATION_JSON)
                .get(Locations.class);

        theLogger.info("Got {}", retrieveLocations);

        ArrayList<LocationInformation> listOfCities = retrieveLocations.getListOfCities();
        listOfCities.forEach(e -> System.out.println(e.getName()));
        HashMap<String, String> cities = retrieveLocations.getHashMapOfLocationKeys();

        System.out.println("Which location are you interested in?");
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();

        String siteUrlForChosenCity = "http://datapoint.metoffice.gov.uk/public/data/val/wxfcs/all/json/" + cities.get(userInput) + "?res=3hourly&key=" + apiKey;

        Root retrieveWeather = client.target(siteUrlForChosenCity)
                .request(MediaType.APPLICATION_JSON)
                .get(Root.class);

        retrieveWeather.weatherReport(userInput, retrieveWeather);
    }

}	
