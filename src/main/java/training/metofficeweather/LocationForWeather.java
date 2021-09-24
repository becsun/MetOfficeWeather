package training.metofficeweather;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;
@JsonIgnoreProperties(ignoreUnknown = true)

public class LocationForWeather {
        public String i;
        public String lat;
        public String lon;
        public String name;
        public String country;
        public String continent;
        public String elevation;
        @JsonProperty("Period")
        public ArrayList<Period> period;

        @Override
        public String toString() {
                return "LocationForWeather{" +
                        "i='" + i + '\'' +
                        ", lat='" + lat + '\'' +
                        ", lon='" + lon + '\'' +
                        ", name='" + name + '\'' +
                        ", country='" + country + '\'' +
                        ", continent='" + continent + '\'' +
                        ", elevation='" + elevation + '\'' +
                        ", period=" + period +
                        '}';
        }

        public String getI() {
                return i;
        }

        public String getLat() {
                return lat;
        }

        public String getLon() {
                return lon;
        }

        public String getName() {
                return name;
        }

        public String getCountry() {
                return country;
        }

        public String getContinent() {
                return continent;
        }

        public String getElevation() {
                return elevation;
        }

        public ArrayList<Period> getPeriod() {
                return period;
        }
}
