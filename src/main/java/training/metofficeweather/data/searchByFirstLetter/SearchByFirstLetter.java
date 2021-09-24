package training.metofficeweather.data.searchByFirstLetter;

import training.metofficeweather.data.loctionInformation.LocationInformation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SearchByFirstLetter {

    public static ArrayList<LocationInformation> getCitiesWithFirstLetter(HashMap<String, String> listOfCities, String firstLetter) {
        ArrayList<LocationInformation> listOfCitiesWithFirstLetter = null;

        String regex = firstLetter.toLowerCase() + "*+";
        Pattern pattern = Pattern.compile(regex);

        listOfCities.forEach((city, id) -> {
            Matcher matcher = pattern.matcher(city);
            System.out.println(matcher.group());
            if (matcher.find()) {

                   
            } else {
                System.out.println("Sorry, there are no cities that start with " + firstLetter);
            }
        });

        return null;
    }
}
