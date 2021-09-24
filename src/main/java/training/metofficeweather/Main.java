package training.metofficeweather;

import training.metofficeweather.data.loctionInformation.LocationInformation;
import training.metofficeweather.data.metOfficeApi.MetOfficeApi;
import training.metofficeweather.data.weatherInformatioin.Root;



import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;


public class Main {
    public static void main(String args[]) {

        MetOfficeApi.

        ArrayList<LocationInformation> listOfCities = retrieveLocations.getListOfCities();
        listOfCities.forEach(e -> System.out.println(e.getName()));
        HashMap<String, String> cities = retrieveLocations.getHashMapOfLocationKeys();

        System.out.println("Which location are you interested in?");
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();



        Root retrieveWeather = client.target(siteUrlForChosenCity)
                .request(MediaType.APPLICATION_JSON)
                .get(Root.class);

        retrieveWeather.weatherReport(userInput, retrieveWeather);


    }

}
