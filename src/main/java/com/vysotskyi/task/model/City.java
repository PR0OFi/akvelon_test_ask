package com.vysotskyi.task.model;



import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "cities")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "city_id")
    @NotNull
    private Integer cityId;

    @Column(name = "city_name")
    private String nameCity;

    @Column(name = "city_temperature")
    private Double temperatureCity;

    @Column(name = "update_time")
    private LocalDateTime updateTime;

    public City() {
    }

    public City(@JsonProperty("id") Integer cityId, @JsonProperty("city_name") String nameCity,@JsonProperty("city_temperature") Double temperatureCity,@JsonProperty("update_time") LocalDateTime updateTime) {
        this.cityId = cityId;
        this.nameCity = nameCity;
        this.temperatureCity = temperatureCity;
        this.updateTime = updateTime;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public void setNameCity(String nameCity) {
        this.nameCity = nameCity;
    }

    public void setTemperatureCity(Double temperatureCity) {
        this.temperatureCity = temperatureCity;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getCityId() {
        return cityId;
    }

    public String getNameCity() {
        return nameCity;
    }

    public Double getTemperatureCity() {
        return temperatureCity;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }
}
