package training.metofficeweather.data.loctionInformation;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.stream.Stream;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Locations {

    @JsonProperty(value="Locations")
    private Location locations;

    public Location getLocation() {
        return locations;
    }

    Stream<LocationInformation> getStreamLocationInformation() {
        return locations.streamLocationInformation();
    }

    public ArrayList<LocationInformation> getListOfCities() {
        ArrayList<LocationInformation> locationsList = new ArrayList<>();
        getStreamLocationInformation().sorted(Comparator.comparing(LocationInformation::getName)).forEach(locationsList::add);
        return locationsList;
    }

    public HashMap<String, String> getHashMapOfLocationKeys() {
        HashMap<String, String> locationKeys = new HashMap<>();
        getStreamLocationInformation().forEach(e -> locationKeys.put(e.getName(), e.getId()));
        return locationKeys;
    }

    @Override
    public String toString() {
        return "Locations{" +
                "location=" + locations +
                '}';
    }

}
