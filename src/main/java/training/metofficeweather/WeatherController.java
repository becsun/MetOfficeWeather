package training.metofficeweather;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import training.metofficeweather.data.loctionInformation.LocationInformation;
import training.metofficeweather.data.loctionInformation.Locations;
import training.metofficeweather.data.metOfficeApi.MetOfficeApi;
import training.metofficeweather.data.weatherInformatioin.WeatherReport;

import java.util.ArrayList;
import java.util.HashMap;

@Controller
public class WeatherController {
    Locations retrieveLocations = MetOfficeApi.locationsApiCall();

    ArrayList<LocationInformation> listOfCities = retrieveLocations.getListOfCities();
    HashMap<String, String> cities = retrieveLocations.getHashMapOfLocationKeys();


    @RequestMapping("/weather")
    ModelAndView home() {
        return new ModelAndView("index");
    }

    @RequestMapping("/weatherInfo")
    ModelAndView weatherInfo(@RequestParam("locationId") String locationId) {
        WeatherReport weatherInformation = retrieveWeather.getWeatherInformationForChosenCity(retrieveWeather);
        return new ModelAndView("info", "weatherInfo", weatherInformation) ;
    }
}
