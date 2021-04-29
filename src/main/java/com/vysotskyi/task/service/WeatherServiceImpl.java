package com.vysotskyi.task.service;

import com.vysotskyi.task.model.forecast.Forecast;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherServiceImpl implements WeatherService {

    private final RestTemplate restTemplate;
    private final String url = "https://api.openweathermap.org/data/2.5/weather?q={city}&appid=abcff1202f3d6473f41a0910ef5d9f8f&units=metric";

    public WeatherServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Forecast getForecast(String cityName) {
        return restTemplate.getForObject(url, Forecast.class, cityName);
    }

}
