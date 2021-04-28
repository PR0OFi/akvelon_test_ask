package com.vysotskyi.task.service;

import com.vysotskyi.task.model.City;

import java.util.List;

public interface CityService {
    void createCity();
    void deleteCityById(int id);
    void updateWeatherById(int id);
    List<City> readCity();
}
