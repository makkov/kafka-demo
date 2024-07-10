package com.example.colvir_kafka_demo.kafka;

import com.example.colvir_kafka_demo.dto.OutCityMsg;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
public class KafkaProducer {

    private static final String CITY_OUT_BINDING_NAME = "city-out-0";
    private final ObjectMapper objectMapper = new ObjectMapper();

    private final StreamBridge streamBridge;

    public KafkaProducer(StreamBridge streamBridge) {
        this.streamBridge = streamBridge;
    }

    public void sendMsgToCityTopic(String city) {
        Message<String> msg = null;
        try {
            msg = MessageBuilder
                    .withPayload(objectMapper.writeValueAsString(new OutCityMsg(city)))
                    .build();
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        streamBridge.send(CITY_OUT_BINDING_NAME, msg);
    }
}
