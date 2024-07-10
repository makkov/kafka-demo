package com.example.colvir_kafka_demo.event;

import org.springframework.context.ApplicationEvent;

public class CityEvent extends ApplicationEvent {

    private final Integer eventId;
    private final String city;

    public CityEvent(Object source, Integer eventId, String city) {
        super(source);
        this.eventId = eventId;
        this.city = city;
    }

    public Integer getEventId() {
        return eventId;
    }

    public String getCity() {
        return city;
    }
}
