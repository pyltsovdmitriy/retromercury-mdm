package com.retromercury.mdm.kafka.config;

import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

@Configuration
public class KafkaConfig {

    @Value("${spring.kafka.bootstrap-servers}")
    private String bootstrapServers;
    @Value("${spring.kafka.consumer.group-id}")
    private String groupId;

    @Bean
    public ConsumerFactory<String, String> consumerFactory() {
        return new DefaultKafkaConsumerFactory<>(Map.of(
                ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers,
                ConsumerConfig.GROUP_ID_CONFIG, groupId,
                ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class,
                ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class
        ));
    }

    @Bean
    public ProducerFactory<String, String> producerFactory() {
        return new DefaultKafkaProducerFactory<>(Map.of(
                ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers,
                ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class,
                ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class
        ));
    }

    @Bean
    public KafkaTemplate<String, String> kafkaTemplate() {
        return new KafkaTemplate<>(producerFactory());
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, String> kafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, String> factory =
                new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory());
        factory.setConcurrency(3);
        return factory;
    }

//    @Bean
//    public ConcurrentKafkaListenerContainerFactory<String, String> kafkaListenerContainerFactory(
//            ConcurrentKafkaListenerContainerFactoryConfigurer configurer,
//            ConsumerFactory<Object, Object> kafkaConsumerFactory,
//            KafkaAwareTransactionManager<?, ?> kafkaTransactionManager) {
//        ConcurrentKafkaListenerContainerFactory<Object, Object> factory =
//                new ConcurrentKafkaListenerContainerFactory<>();
//        factory.setMessageConverter(kafkaMessageConverter);
//        // message will be sent to the end of this topic or to other (dlt) topic
//        var backOff = new FixedBackOff(properties.getFixedBackOffInterval(), properties.getFixedBackOffMaxAttempts());
//        factory.setCommonErrorHandler(new DefaultErrorHandler(
//                recoverer, backOff));
//        AfterRollbackProcessor afterRollbackProcessor =
//                new DefaultAfterRollbackProcessor<String, byte[]>(backOff);
//        factory.setAfterRollbackProcessor(afterRollbackProcessor);
//        factory.setMissingTopicsFatal(properties.getMissingTopicsFatal());
//        factory.getContainerProperties().setTransactionManager(kafkaTransactionManager);
//        factory.getContainerProperties().setMicrometerTags(Map.of("service", applicationName));
//        factory.setConcurrency(properties.getListenerConcurrency());
//        configurer.configure(factory, kafkaConsumerFactory);
//        return factory;
//    }

}
