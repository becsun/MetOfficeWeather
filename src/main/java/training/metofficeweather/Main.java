package training.metofficeweather;

import training.metofficeweather.data.loctionInformation.LocationInformation;
import training.metofficeweather.data.loctionInformation.Locations;
import training.metofficeweather.data.metOfficeApi.MetOfficeApi;
import training.metofficeweather.data.searchByFirstLetter.SearchByFirstLetter;
import training.metofficeweather.data.weatherInformatioin.Root;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String args[]) {

        Locations retrieveLocations = MetOfficeApi.locationsApiCall();

        ArrayList<LocationInformation> listOfCities = retrieveLocations.getListOfCities();
        listOfCities.forEach(e -> System.out.println(e.getName()));
        HashMap<String, String> cities = retrieveLocations.getHashMapOfLocationKeys();

        // ask user to choose:
        // 1. search by area
        // 2. search by first letter
        System.out.println("Which location are you interested in?");
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();

        SearchByFirstLetter.getCitiesWithFirstLetter(cities, "A");

        Root retrieveWeather = MetOfficeApi.weatherApiCall(cities.get(userInput));

        retrieveWeather.weatherReport(userInput, retrieveWeather);

    }

}
