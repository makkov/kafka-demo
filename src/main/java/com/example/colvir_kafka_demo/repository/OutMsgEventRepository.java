package com.example.colvir_kafka_demo.repository;

import com.example.colvir_kafka_demo.entity.OutMsgEvent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OutMsgEventRepository extends JpaRepository<OutMsgEvent, Integer> {
}
