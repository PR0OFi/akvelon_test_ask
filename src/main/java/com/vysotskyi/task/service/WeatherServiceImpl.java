package com.vysotskyi.task.service;

import com.vysotskyi.task.constants.Data;
import com.vysotskyi.task.model.forecast.Forecast;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherServiceImpl implements WeatherService {

    private final RestTemplate restTemplate;

    public WeatherServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Forecast getForecast() {
        return restTemplate.getForObject(Data.weather_query, Forecast.class);
    }

}
