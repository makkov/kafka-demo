package com.example.colvir_kafka_demo.service;

import com.example.colvir_kafka_demo.kafka.KafkaProducer;
import org.springframework.stereotype.Service;

@Service
public class CityService {

    private final KafkaProducer kafkaProducer;

    public CityService(KafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    public void publishCity(String city) {
        kafkaProducer.sendMsgToCityTopic(city);
    }
}
