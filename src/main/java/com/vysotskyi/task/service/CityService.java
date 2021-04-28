package com.vysotskyi.task.service;

import com.vysotskyi.task.model.City;

import java.util.List;

public interface CityService {
    void createCity(City city);
    void deleteCity();
    void updateWeather();
    List<City> readCity();
}
