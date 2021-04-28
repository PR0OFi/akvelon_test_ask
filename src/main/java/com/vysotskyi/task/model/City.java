package com.vysotskyi.task.model;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "cities", schema = "public")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "city_id")
    private Integer cityId;

    @Column(name = "city_name")
    private String nameCity;

    @Column(name = "city_temperature")
    private Double temperatureCity;

    @Column(name = "update_time")
    private Date updateTime;

    public City() {
    }

    public void setName(String nameCity) {
        this.nameCity = nameCity;
    }

    public void setTemperature(Double temperatureCity) {
        this.temperatureCity = temperatureCity;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getCityId() {
        return cityId;
    }

    public String getName() {
        return nameCity;
    }

    public Double getTemperature() {
        return temperatureCity;
    }

    public Date getUpdateTime() {
        return updateTime;
    }
}
