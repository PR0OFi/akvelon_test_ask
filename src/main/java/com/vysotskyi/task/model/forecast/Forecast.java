package com.vysotskyi.task.model.forecast;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class Forecast {
    @JsonProperty("dt")
    private Date time;

    @JsonProperty("main")
    private Weather main;

    @JsonProperty("name")
    private String cityName;

    public void setTime(Date time) {
        final long seconds = time.getTime();
        final Date date = new Date(seconds * 1000);
        this.time = date;
    }

    public Date getTime() {
        return time;
    }

    public Weather getMain() {
        return main;
    }

    public String getCityName() {
        return cityName;
    }

    public void setMain(Weather main) {
        this.main = main;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
}
