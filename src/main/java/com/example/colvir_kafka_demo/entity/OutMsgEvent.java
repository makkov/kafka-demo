package com.example.colvir_kafka_demo.entity;

import io.hypersistence.utils.hibernate.type.json.JsonBinaryType;
import jakarta.persistence.*;
import org.hibernate.annotations.Type;

import java.time.LocalDateTime;

@Entity
public class OutMsgEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "sequence", allocationSize = 1)
    private Integer id;

    private LocalDateTime dateTime;

    @Enumerated(EnumType.STRING)
    private OutMsgType type;

    @Enumerated(EnumType.STRING)
    private OutMsgStatus status;

    @Type(JsonBinaryType.class)
    @Column(name = "data", columnDefinition = "jsonb")
    private String data;

    public OutMsgEvent() {
    }

    public OutMsgEvent(LocalDateTime dateTime, OutMsgType type, OutMsgStatus status, String data) {
        this.dateTime = dateTime;
        this.type = type;
        this.status = status;
        this.data = data;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public OutMsgType getType() {
        return type;
    }

    public void setType(OutMsgType type) {
        this.type = type;
    }

    public OutMsgStatus getStatus() {
        return status;
    }

    public void setStatus(OutMsgStatus status) {
        this.status = status;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
