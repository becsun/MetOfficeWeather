package training.metofficeweather;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import training.metofficeweather.data.loctionInformation.LocationInformation;
import training.metofficeweather.data.loctionInformation.Locations;
import training.metofficeweather.data.metOfficeApi.MetOfficeApi;
import training.metofficeweather.data.weatherInformatioin.Root;
import training.metofficeweather.data.weatherInformatioin.WeatherReport;

import javax.ws.rs.Consumes;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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

    @PostMapping(path = "/weatherInfo")
    public ModelAndView submitCityForm(@ModelAttribute("weatherInfo") CityForm cityForm, Model model) {
        model.addAttribute("cityName", cityForm.getCityName());
        String cityNameFromAttribute = model.getAttribute("cityName").toString();
        Root retrieveWeather = MetOfficeApi.weatherApiCall(cities.get(cityNameFromAttribute));
        WeatherReport weatherInformation = getWeatherInformationForChosenCity(retrieveWeather);
        return new ModelAndView("info", "weatherInfo", new WeatherInfo(weatherInformation, cityNameFromAttribute));
    }
}
