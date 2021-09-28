package training.metofficeweather;

public class CityForm {
    private String cityName;

    public CityForm(String cityName) {
        this.cityName = cityName;
    }

    public String getCityName() {
        return cityName;
    }

    @Override
    public String toString() {
        return cityName;
    }
}
