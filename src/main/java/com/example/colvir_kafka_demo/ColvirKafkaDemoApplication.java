package com.example.colvir_kafka_demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class ColvirKafkaDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ColvirKafkaDemoApplication.class, args);
	}

}
