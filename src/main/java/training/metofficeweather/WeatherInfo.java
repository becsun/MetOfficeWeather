package training.metofficeweather;

public class WeatherInfo {
    private final String locationId;
    private final String city;

    public WeatherInfo(String locationId, String city) {
        this.locationId = locationId;
        this.city = city;
    }


    public String getLocationId() {
        return locationId;
    }

    public String getCity() {
        return city;
    }
}
