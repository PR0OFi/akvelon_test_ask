package com.vysotskyi.task.service;

import com.vysotskyi.task.model.forecast.Forecast;

public interface WeatherService {
    Forecast getForecast(String cityName);
}
