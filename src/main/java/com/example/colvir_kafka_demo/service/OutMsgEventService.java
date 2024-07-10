package com.example.colvir_kafka_demo.service;

import com.example.colvir_kafka_demo.dto.OutCityMsg;
import com.example.colvir_kafka_demo.entity.OutMsgEvent;
import com.example.colvir_kafka_demo.entity.OutMsgStatus;
import com.example.colvir_kafka_demo.entity.OutMsgType;
import com.example.colvir_kafka_demo.repository.OutMsgEventRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class OutMsgEventService {

    private final ObjectMapper objectMapper = new ObjectMapper();
    private final OutMsgEventRepository outMsgEventRepository;

    public OutMsgEventService(OutMsgEventRepository outMsgEventRepository) {
        this.outMsgEventRepository = outMsgEventRepository;
    }

    public Integer saveOutCityMsgEvent(String city, LocalDateTime currentDateTime) {
        try {
            OutMsgEvent event = outMsgEventRepository.save(new OutMsgEvent(
                    currentDateTime,
                    OutMsgType.CITY,
                    OutMsgStatus.NEW,
                    objectMapper.writeValueAsString(new OutCityMsg(city))
            ));
            return event.getId();
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}