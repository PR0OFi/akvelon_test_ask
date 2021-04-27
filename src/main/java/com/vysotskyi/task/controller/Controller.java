package com.vysotskyi.task.controller;

import com.vysotskyi.task.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    private final CityService service;

    @Autowired
    public Controller(CityService service) {
        this.service = service;
    }

    @GetMapping(value = "/update")
    public void updateWeather() {
        service.updateWeather();
    }
}
