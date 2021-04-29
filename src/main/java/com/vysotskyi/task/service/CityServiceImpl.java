package com.vysotskyi.task.service;

import com.vysotskyi.task.model.City;
import com.vysotskyi.task.model.forecast.Forecast;
import com.vysotskyi.task.repository.CityRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CityServiceImpl implements CityService {

    private final CityRepository repository;
    private final WeatherService weatherService;
    private final Logger logger = LoggerFactory.getLogger(CityServiceImpl.class);

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
        logger.info("Creating entity with params name={}, t={}, time={}", city.getName(), city.getTemperature(), city.getUpdateTime());
        repository.save(city);
    }

    @Transactional
    @Override
    public void deleteCityById(int id) {
        final City city = repository.getOne(id);
        logger.info("Delete city {}", city.getName());
        repository.deleteById(id);
    }

    @Transactional
    @Override
    public void updateWeatherById(int id) {
        final City city = repository.getOne(id);
        final Forecast forecast = weatherService.getForecast(city.getName());
        city.setTemperature(forecast.getMain().getTemperature());
        city.setUpdateTime(forecast.getTime());
        logger.info("Update forecast for city={}", city.getName());
        repository.save(city);
    }

    @Override
    public List<City> readCity() {
        logger.info("Getting all cities from DB");
        return repository.findAll();
    }

    @Transactional
    @Scheduled(fixedDelayString = "${delay.update.rate}")
    @Override
    public void autoUpdateWeather() {
        logger.info("Starting update forecast for all cities");
        final List<City> all = repository.findAll();
        for (City city : all) {
            final Forecast forecast = weatherService.getForecast(city.getName());
            city.setTemperature(forecast.getMain().getTemperature());
            city.setUpdateTime(forecast.getTime());
            logger.debug("Update forecast for {}, t={}, time={}", city.getName(), city.getTemperature(), city.getUpdateTime());
            repository.save(city);
        }
    }
}
