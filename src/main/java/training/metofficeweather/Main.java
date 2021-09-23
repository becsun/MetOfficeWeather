package training.metofficeweather;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;


public class Main {
    private static String apiKey = "<yourAPIkey>";
    static final String siteUrl = "http://datapoint.metoffice.gov.uk/public/data/val/wxfcs/all/json/sitelist?key=" + apiKey;

    static final Logger theLogger = LogManager.getLogger("Weather");

    public static void main(String args[]) {
        theLogger.info("Application Started");

        Client client = ClientBuilder.newClient();
        String name = client.target(siteUrl)
                .request(MediaType.TEXT_PLAIN)
                .get(String.class);

        System.out.println(name);
        theLogger.info("Got {}", name);
    }
}	
