package training.metofficeweather.data.metOfficeApi;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.glassfish.jersey.jackson.JacksonFeature;
import training.metofficeweather.PropertiesReader;
import training.metofficeweather.data.loctionInformation.Locations;
import training.metofficeweather.data.weatherInformatioin.Root;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;

public class MetOfficeApi {

    private static String apiKey = PropertiesReader.getProperty("API_KEY");
    static final Logger theLogger = LogManager.getLogger("Weather");

    public static Locations locationsApiCall(){
        final String siteUrl = "http://datapoint.metoffice.gov.uk/public/data/val/wxfcs/all/json/sitelist?key=" + apiKey;

        theLogger.info("Application Started");
        Client client = ClientBuilder.newBuilder().register(JacksonFeature.class).build();
        Locations retrieveLocations = client.target(siteUrl)
                .request(MediaType.APPLICATION_JSON)
                .get(Locations.class);

        theLogger.info("Got {}", retrieveLocations);

        return retrieveLocations;
    }

    public static Root weatherApiCall(String city){

        final String siteUrlForChosenCity = "http://datapoint.metoffice.gov.uk/public/data/val/wxfcs/all/json/" + city + "?res=3hourly&key=" + apiKey;

        theLogger.info("Application Started");

        Client client = ClientBuilder.newBuilder().register(JacksonFeature.class).build();
        Root retrieveWeather = client.target(siteUrlForChosenCity)
                .request(MediaType.APPLICATION_JSON)
                .get(Root.class);

        theLogger.info("Got {}", retrieveWeather);

        return retrieveWeather;
    }

}

