package training.metofficeweather;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;


public class LocationForWeather {
        public String i;
        public String lat;
        public String lon;
        public String name;
        public String country;
        public String continent;
        public String elevation;
        @JsonProperty("Period")
        public List<Period> period;
    }
