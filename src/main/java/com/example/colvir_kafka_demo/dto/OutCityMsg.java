package com.example.colvir_kafka_demo.dto;

public class OutCityMsg {

    private String city;

    public OutCityMsg() {
    }

    public OutCityMsg(String city) {
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
