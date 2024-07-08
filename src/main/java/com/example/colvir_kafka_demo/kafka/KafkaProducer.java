package com.example.colvir_kafka_demo.kafka;

import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class KafkaProducer {

    private static final String FIRST_OUT_BINDING_NAME = "first-out-0";

    private final StreamBridge streamBridge;

    public KafkaProducer(StreamBridge streamBridge) {
        this.streamBridge = streamBridge;
    }

    @Scheduled(fixedDelay = 15000)
    public void sendMsg() {
        streamBridge.send(FIRST_OUT_BINDING_NAME, String.format("Application date time: %s", LocalDateTime.now()));
    }
}
