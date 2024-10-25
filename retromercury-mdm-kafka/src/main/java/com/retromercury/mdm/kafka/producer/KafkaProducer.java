package com.retromercury.mdm.kafka.producer;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public class KafkaProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public void produce(String topic, String message)  {
        log.info("Producing message {} to topic {}", message, topic);
        kafkaTemplate.send(topic, message);
        log.info("Produced");
        kafkaTemplate.flush();
    }

}
