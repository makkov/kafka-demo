package com.example.colvir_kafka_demo.service;

import com.example.colvir_kafka_demo.event.CityEvent;
import com.example.colvir_kafka_demo.kafka.KafkaProducer;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class CityService {

    private final KafkaProducer kafkaProducer;
    private final OutMsgEventService outMsgEventService;
    private final ApplicationEventPublisher applicationEventPublisher;

    public CityService(KafkaProducer kafkaProducer, OutMsgEventService outMsgEventService, ApplicationEventPublisher applicationEventPublisher) {
        this.kafkaProducer = kafkaProducer;
        this.outMsgEventService = outMsgEventService;
        this.applicationEventPublisher = applicationEventPublisher;
    }

    @Transactional
    public void publishCity(String city) {
        LocalDateTime currentDateTime = LocalDateTime.now();
        Integer eventCityEventId = outMsgEventService.saveOutCityMsgEvent(city, currentDateTime);

        CityEvent cityEvent = new CityEvent(this, eventCityEventId, city);
        applicationEventPublisher.publishEvent(cityEvent);
    }
}
