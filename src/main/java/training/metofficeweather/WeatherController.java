package training.metofficeweather;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import training.metofficeweather.data.loctionInformation.LocationInformation;
import training.metofficeweather.data.loctionInformation.Locations;
import training.metofficeweather.data.metOfficeApi.MetOfficeApi;
import training.metofficeweather.data.weatherInformatioin.Root;
import training.metofficeweather.data.weatherInformatioin.WeatherReport;

import javax.ws.rs.Consumes;
import java.util.ArrayList;
import java.util.HashMap;

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

    @RequestMapping(value= "/weatherInfo", method= RequestMethod.POST, consumes="application/x-www-form-urlencoded")

    ModelAndView weatherInfo(@RequestParam("cityName") String cityName) {
        Root retrieveWeather = MetOfficeApi.weatherApiCall(cities.get(cityName));
        WeatherReport weatherInformation = getWeatherInformationForChosenCity(retrieveWeather);
        return new ModelAndView("info", "weatherInfo", new WeatherInfo(weatherInformation, cityName));
    }
}
