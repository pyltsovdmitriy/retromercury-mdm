package com.retromercury.mdm.kafka.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.retromercury.mdm.kafka.producer.KafkaProducer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class KafkaService {

    @Value("${retromercury.mdm.kafka.topic}")
    private String topic;
    private final KafkaProducer kafkaProducer;

    public void sendMessage() {
        int i = 0;
        while (true) {
            kafkaProducer.produce(topic, i + "", "Message " + i++);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
