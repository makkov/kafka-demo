package com.example.colvir_kafka_demo.repository;

import com.example.colvir_kafka_demo.entity.OutMsgEvent;
import com.example.colvir_kafka_demo.entity.OutMsgStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OutMsgEventRepository extends JpaRepository<OutMsgEvent, Integer> {

    List<OutMsgEvent> findAllByStatus(OutMsgStatus status);
}
