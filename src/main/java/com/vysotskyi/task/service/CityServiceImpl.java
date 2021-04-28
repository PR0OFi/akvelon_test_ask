package com.vysotskyi.task.service;

import com.vysotskyi.task.model.City;
import com.vysotskyi.task.repository.CityRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class CityServiceImpl implements CityService {

    private final CityRepository repository;

    public CityServiceImpl(CityRepository repository) {
        this.repository = repository;
    }

    @Override
    public void createCity(@RequestBody City city) {
        repository.save(city);
    }

    @Override
    public void deleteCity() {

    }

    @Override
    public void updateWeather() {
        repository.findAll();
    }

    @Override
    public List<City> readCity() {
        return repository.findAll();
    }
}
