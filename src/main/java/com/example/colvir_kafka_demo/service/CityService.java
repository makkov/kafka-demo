package com.example.colvir_kafka_demo.service;

import com.example.colvir_kafka_demo.kafka.KafkaProducer;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CityService {

    private final KafkaProducer kafkaProducer;
    private final OutMsgEventService outMsgEventService;

    public CityService(KafkaProducer kafkaProducer, OutMsgEventService outMsgEventService) {
        this.kafkaProducer = kafkaProducer;
        this.outMsgEventService = outMsgEventService;
    }

    public void publishCity(String city) {
        LocalDateTime currentDateTime = LocalDateTime.now();
        outMsgEventService.saveOutCityMsgEvent(city, currentDateTime);
        kafkaProducer.sendMsgToCityTopic(city);
    }
}
