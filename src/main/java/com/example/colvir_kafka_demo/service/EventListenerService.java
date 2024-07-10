package com.example.colvir_kafka_demo.service;

import com.example.colvir_kafka_demo.event.CityEvent;
import com.example.colvir_kafka_demo.kafka.KafkaProducer;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

@Component
public class EventListenerService {

    private final KafkaProducer kafkaProducer;

    public EventListenerService(KafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void handleCityEvent(CityEvent cityEvent) {
        kafkaProducer.sendMsgToCityTopic(cityEvent);
    }
}
