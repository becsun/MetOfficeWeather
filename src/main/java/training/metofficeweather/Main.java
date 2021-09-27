package training.metofficeweather;

import training.metofficeweather.data.loctionInformation.LocationInformation;
import training.metofficeweather.data.loctionInformation.Locations;
import training.metofficeweather.data.metOfficeApi.MetOfficeApi;
import training.metofficeweather.data.searchByFirstLetter.SearchByFirstChar;
import training.metofficeweather.data.weatherInformatioin.Root;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String args[]) {

        Locations retrieveLocations = MetOfficeApi.locationsApiCall();

        ArrayList<LocationInformation> listOfCities = retrieveLocations.getListOfCities();
        HashMap<String, String> cities = retrieveLocations.getHashMapOfLocationKeys();

        // ask user to choose:
        // 1. search by area
        // 2. search by first letter
        System.out.println("How would you like to search? Type the number please. \n 1. Search by area \n 2. Search by first characters \n 3. See every city \n 4. To quit");
        Scanner scanner = new Scanner(System.in);
        int userInputForSearchOption = scanner.nextInt();

        // TODO get these out in a new method/class
        boolean userQuit = false;

        while (!userQuit) {
            if (userInputForSearchOption == 1) {
                System.out.println("Searching by area");
                userQuit = true;
            } else if (userInputForSearchOption == 2) {
                System.out.println("Please type the first characters");
                Scanner cityNameScannerByFirstChar = new Scanner(System.in);
                String userInputForSearchCharacter = cityNameScannerByFirstChar.nextLine();
                //TODO need a try catch to catch incorrect characters or an if statement
                SearchByFirstChar.getCitiesWithFirstLetter(cities, userInputForSearchCharacter).forEach(System.out::println);
                userQuit = true;
            } else if (userInputForSearchOption == 3) {
                listOfCities.forEach(e -> System.out.println(e.getName()));
                userQuit = true;
            } else if (userInputForSearchOption == 4) {
                System.out.println("Thank you for using our program! See you later!");
                userQuit = true;
            } else {
                System.out.println("Sorry, that's not a valid option. Please try again.");
            }
        }

        System.out.println("Which city would you like to see?");
        Scanner cityNameScanner = new Scanner(System.in);
        String userInputForWeatherSearch = cityNameScanner.nextLine();

        if (!userInputForWeatherSearch.isEmpty()) {
            Root retrieveWeather = MetOfficeApi.weatherApiCall(cities.get(userInputForWeatherSearch));
            retrieveWeather.weatherReport(userInputForWeatherSearch, retrieveWeather);
        }

    }

}
