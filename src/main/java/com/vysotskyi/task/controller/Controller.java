package com.vysotskyi.task.controller;

import com.vysotskyi.task.model.City;
import com.vysotskyi.task.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller {
    private final CityService service;

   @Autowired
    public Controller(CityService service) {
        this.service = service;
    }


    @GetMapping(value = "/add")
    public void addCity(){
        service.createCity();
    }

    @PostMapping(value = "/update", produces = "application/json")
    public void updateWeather(@RequestBody Integer id) {
        service.updateWeatherById(id);
    }

    @PostMapping(value = "/deletebyid", produces = "application/json")
    public void deleteById(@RequestBody Integer id){
            service.deleteCityById(id);
    }

    @GetMapping(value = "/getCities")
    public List<City> getAll(){
        return service.readCity();
    }

}
