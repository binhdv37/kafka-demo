package com.example.kafkademo.controller;

import com.example.kafkademo.mode.dto.KafkaMessageDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/kafka-sender")
public class KafkaSenderController {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @PostMapping
    public String sendMessage(@RequestBody KafkaMessageDto dto) {
        kafkaTemplate.send(dto.getTopic(), dto.getMessage());
        return "SUCCESS";
    }
}
