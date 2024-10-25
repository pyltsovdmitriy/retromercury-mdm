package com.retromercury.mdm.kafka.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class KafkaConsumer {

    @KafkaListener(topics = "${retromercury.mdm.kafka.topic}", groupId = "${retromercury.mdm.kafka.consumer.group}")
    public void consume(String message) {
      log.info(":-* !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!Consumer: {}", message);
    }
}
