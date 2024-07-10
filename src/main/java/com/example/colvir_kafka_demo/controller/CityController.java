package com.example.colvir_kafka_demo.controller;

import com.example.colvir_kafka_demo.service.CityService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CityController {

    private final CityService cityService;

    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping
    public void publishCity(@RequestParam String city) {
        cityService.publishCity(city);
    }
}
