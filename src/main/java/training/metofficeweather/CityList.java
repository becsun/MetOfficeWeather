package training.metofficeweather;

import training.metofficeweather.data.loctionInformation.LocationInformation;

import java.util.ArrayList;

public class CityList {
    private ArrayList<LocationInformation> listOfCities;

    public CityList(ArrayList<LocationInformation> listOfCities) {
        this.listOfCities = listOfCities;
    }

    public ArrayList<LocationInformation> getListOfCities() {
        return listOfCities;
    }
}
