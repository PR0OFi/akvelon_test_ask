package com.vysotskyi.task.service;

import com.vysotskyi.task.repository.CityRepository;
import org.springframework.stereotype.Service;

@Service
public class CityServiceImpl implements CityService {

    private final CityRepository repository;

    public CityServiceImpl(CityRepository repository) {
        this.repository = repository;
    }

    @Override
    public void createCity() {

    }

    @Override
    public void deleteCity() {

    }

    @Override
    public void updateWeather() {
        repository.findAll();
    }

    @Override
    public void readCity() {

    }
}
