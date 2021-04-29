package com.vysotskyi.task.controller;

import com.vysotskyi.task.model.City;
import com.vysotskyi.task.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {
    private final CityService service;

    @Autowired
    public Controller(CityService service) {
        this.service = service;
    }

    @GetMapping(value = "/city/{name}")
    public void addCity(@PathVariable String name) {
        service.createCity(name);
    }

    @GetMapping(value = "/update/{id}")
    public void updateWeather(@PathVariable Integer id) {
        service.updateWeatherById(id);
    }

    @GetMapping(value = "/delete/{id}")
    public void deleteById(@PathVariable Integer id) {
        service.deleteCityById(id);
    }

    @GetMapping(value = "/read/cities")
    public List<City> getAll() {
        return service.readCity();
    }
}
