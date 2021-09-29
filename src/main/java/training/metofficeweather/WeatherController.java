package training.metofficeweather;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import training.metofficeweather.data.loctionInformation.LocationInformation;
import training.metofficeweather.data.loctionInformation.Locations;
import training.metofficeweather.data.metOfficeApi.MetOfficeApi;
import training.metofficeweather.data.weatherInformatioin.DatePeriod;
import training.metofficeweather.data.weatherInformatioin.Root;
import training.metofficeweather.data.weatherInformatioin.WeatherReport;

import java.util.ArrayList;
import java.util.HashMap;

import static training.metofficeweather.data.weatherInformatioin.Root.getNextFiveDaysWeatherForChosenCity;
import static training.metofficeweather.data.weatherInformatioin.Root.getWeatherInformationForChosenCity;

@Controller
public class WeatherController {
    Locations retrieveLocations = MetOfficeApi.locationsApiCall();

    ArrayList<LocationInformation> listOfCities = retrieveLocations.getListOfCities();
    HashMap<String, String> cities = retrieveLocations.getHashMapOfLocationKeys();

    @RequestMapping("/")
    public String home(Model model) {
        model.addAttribute("listOfCities", listOfCities);
        return "index";
    }

    @RequestMapping("/weatherInfo")
    public ModelAndView submitCityForm(@RequestParam("cityName") CityForm cityForm) {
        String cityNameFromAttribute = cityForm.getCityName();
        Root retrieveWeather = MetOfficeApi.weatherApiCall(cities.get(cityNameFromAttribute));
        ArrayList<DatePeriod> weatherInformationForFiveDays = getNextFiveDaysWeatherForChosenCity(retrieveWeather);
        return new ModelAndView("info", "weatherInfo", new WeatherInfo(weatherInformationForFiveDays, cityNameFromAttribute));
    }
}
