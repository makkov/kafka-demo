package com.example.colvir_kafka_demo.kafka;

import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Component;

@Component
public class KafkaProducer {

    private static final String CITY_OUT_BINDING_NAME = "city-out-0";

    private final StreamBridge streamBridge;

    public KafkaProducer(StreamBridge streamBridge) {
        this.streamBridge = streamBridge;
    }

    public void sendMsgToCityTopic(String city) {
        streamBridge.send(CITY_OUT_BINDING_NAME, city);
    }
}
