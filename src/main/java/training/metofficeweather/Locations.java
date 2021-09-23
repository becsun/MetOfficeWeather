package training.metofficeweather;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Locations {

    @JsonProperty(value="Locations")


    private Location locations;


    public Location getLocation() {
        return locations;
    }


    public void setLocation(Location location) {
        this.locations = location;

    }
    @Override
    public String toString() {
        return "Locations{" +
                "location=" + locations +
                '}';
    }

}
