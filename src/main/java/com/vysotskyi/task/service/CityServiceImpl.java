package com.vysotskyi.task.service;

import com.vysotskyi.task.model.City;
import com.vysotskyi.task.model.forecast.Forecast;
import com.vysotskyi.task.repository.CityRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CityServiceImpl implements CityService {

    private final CityRepository repository;
    private final WeatherService weatherService;

    public CityServiceImpl(CityRepository repository, WeatherService weatherService) {
        this.repository = repository;
        this.weatherService = weatherService;
    }

    @Override
    public void createCity() {
        final Forecast forecast = weatherService.getForecast();
        final City city = new City();
        city.setName(forecast.getCityName());
        city.setTemperature(forecast.getMain().getTemperature());
        city.setUpdateTime(forecast.getTime());
        repository.save(city);
    }

    @Override
    public void deleteCityById(int id) {
        repository.deleteById(id);
    }

    @Transactional
    @Override
    public void updateWeatherById(int id) {
        final City city = repository.getOne(id);
        final Forecast forecast = weatherService.getForecast();
        city.setTemperature(forecast.getMain().getTemperature());
        city.setUpdateTime(forecast.getTime());
        repository.save(city);
    }

    @Override
    public List<City> readCity() {
        return repository.findAll();
    }
}
