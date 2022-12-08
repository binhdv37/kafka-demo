package com.example.kafkademo.controller;

import com.example.kafkademo.constant.MyKafkaTopic;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class SystemKafkaListener {

    @KafkaListener(topics = MyKafkaTopic.DEMO)
    void listenDemo(@Payload String message) {
        try {
            log.info("Receive demo message: {}", message);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("Handle demo message fail: {}", message);
        }
    }
}
