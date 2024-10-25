package com.retromercury.mdm.kafka.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class KafkaConsumer {

    @KafkaListener(topics = {"task-topic"}, groupId = "task-group")
    public void consume(String message) {
      log.info(":-* !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!Consumer: {}", message);
    }
}
