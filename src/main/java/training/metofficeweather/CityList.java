package training.metofficeweather;

import training.metofficeweather.data.loctionInformation.LocationInformation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.stream.Stream;

public class CityList {
    private static ArrayList<String> cityNames;

    public CityList(ArrayList<String> cityNames) {
        this.cityNames = cityNames;
    }

    public static ArrayList<String> getCityNames() {
        return cityNames;
    }
}
