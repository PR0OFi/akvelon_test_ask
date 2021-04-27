package com.vysotskyi.task.model;



import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "cities")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "city_id")
    private Integer cityId;

    @Column(name = "city_name")
    private String nameCity;

    @Column(name = "city_temperature")
    private Double temperatureCity;

    @Column(name = "update_time")
    private LocalDateTime updateTime;


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
