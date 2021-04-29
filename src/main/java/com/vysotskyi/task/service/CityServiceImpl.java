package com.vysotskyi.task.service;

import com.vysotskyi.task.model.City;
import com.vysotskyi.task.model.forecast.Forecast;
import com.vysotskyi.task.repository.CityRepository;
import org.springframework.scheduling.annotation.Scheduled;
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
    public void createCity(String name) {
        final City city = new City(name);
        final Forecast forecast = weatherService.getForecast(city.getName());
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
        final Forecast forecast = weatherService.getForecast(city.getName());
        city.setTemperature(forecast.getMain().getTemperature());
        city.setUpdateTime(forecast.getTime());
        repository.save(city);
    }

    @Override
    public List<City> readCity() {
        return repository.findAll();
    }

    @Transactional
    @Scheduled(fixedDelayString = "${delay.update.rate}")
    @Override
    public void autoUpdateWeather() {
        final List<City> all = repository.findAll();
        for (City city : all) {
            final Forecast forecast = weatherService.getForecast(city.getName());
            city.setTemperature(forecast.getMain().getTemperature());
            city.setUpdateTime(forecast.getTime());
            repository.save(city);
        }
    }
}
