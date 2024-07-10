package com.example.colvir_kafka_demo.service;

import com.example.colvir_kafka_demo.dto.OutCityMsg;
import com.example.colvir_kafka_demo.entity.OutMsgEvent;
import com.example.colvir_kafka_demo.event.CityEvent;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Component("refresher")
public class Refresher {

    private ObjectMapper objectMapper = new ObjectMapper();
    private final OutMsgEventService outMsgEventService;
    private final ApplicationEventPublisher applicationEventPublisher;

    public Refresher(OutMsgEventService outMsgEventService, ApplicationEventPublisher applicationEventPublisher) {
        this.outMsgEventService = outMsgEventService;
        this.applicationEventPublisher = applicationEventPublisher;
    }

    @EventListener(ApplicationReadyEvent.class)
    @Transactional
    public void listenerContext() {
        List<OutMsgEvent> eventsForResend = outMsgEventService.getNewEvents();
        List<CityEvent> cityEvents = eventsForResend.stream()
                .map(ev -> {
                    try {
                        String city = new ObjectMapper().readValue(ev.getData(), OutCityMsg.class).getCity();
                        return new CityEvent(this, ev.getId(), city);
                    } catch (JsonProcessingException e) {
                        throw new RuntimeException(e);
                    }
                }).collect(Collectors.toUnmodifiableList());

        for (CityEvent cityEvent : cityEvents) {
            applicationEventPublisher.publishEvent(cityEvent);
        }
    }
}
