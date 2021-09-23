package training.metofficeweather;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.glassfish.jersey.jackson.JacksonFeature;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.Comparator;


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
        retrieve.getLocation().streamLocationInformation().sorted(Comparator.comparing(LocationInformation::getName)).forEach(locationsList::add);
        locationsList.forEach(e -> System.out.println(e.getName()));
    }
}	
