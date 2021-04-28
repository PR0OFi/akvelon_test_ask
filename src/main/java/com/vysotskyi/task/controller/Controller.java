package com.vysotskyi.task.controller;

import com.vysotskyi.task.model.City;
import com.vysotskyi.task.service.CityService;
import com.vysotskyi.task.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {
    private final CityService serviceC;
    private final WeatherService weatherService;


   @Autowired
    public Controller(CityService serviceC, WeatherService weatherService) {
        this.serviceC = serviceC;
        this.weatherService = weatherService;
    }


    @GetMapping(value = "/update")
    public void updateWeather() {
        serviceC.updateWeather();
    }

    @PostMapping(value = "/add", produces = "application/json")
    public void addCity(@RequestBody City city){
        serviceC.createCity(city);
    }

    @GetMapping(value = "/getCities")
    public List<City> getAll(){
        return serviceC.readCity();
    }

    @GetMapping(value = "/getWeather")
    public void get(){
        weatherService.getForecast();
    }
}
