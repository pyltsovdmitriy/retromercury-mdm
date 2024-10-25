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

    public void produce(String topic, String key, String message)  {
        log.info("Producing message {} to topic {}", message, topic);
        final var future = kafkaTemplate.send(topic, key, message);

        future.whenComplete((sendResult, exception) -> {
            if (exception != null) {
                future.completeExceptionally(exception);
            } else {
                future.complete(sendResult);
            }
            log.info("Task status send to Kafka topic : "+ message);
        });

        log.info("Produced");
        kafkaTemplate.flush();
    }

}
