package training.metofficeweather.data.searchByFirstLetter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SearchByFirstChar {

    public static ArrayList<String> getCitiesWithFirstLetter(HashMap<String, String> listOfCities, String firstLetter) {
        ArrayList<String> listOfCitiesWithFirstLetter = new ArrayList<>();

        String regex = "^" + firstLetter + ".+";
        Pattern pattern = Pattern.compile(regex);

        listOfCities.forEach((city, id) -> {
            Matcher matcher = pattern.matcher(city);

            if (matcher.find()) {
                listOfCitiesWithFirstLetter.add(matcher.group());
            }
        });

        if (listOfCitiesWithFirstLetter.isEmpty()) {
            System.out.println("Sorry, there are no cities that start with " + firstLetter);
        }

        return listOfCitiesWithFirstLetter;
    }
}
