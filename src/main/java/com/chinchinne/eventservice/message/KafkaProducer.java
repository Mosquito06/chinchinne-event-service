package com.chinchinne.eventservice.message;

import com.chinchinne.eventservice.vo.RequestEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer
{
    KafkaTemplate<String, String> kafkaTemplate;

    @Value("${spring.kafka.custom.topic}")
    String topic;

    @Autowired
    public KafkaProducer(KafkaTemplate<String, String> kafkaTemplate)
    {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void send(RequestEvent requestEvent)
    {
        System.out.println(kafkaTemplate);

        kafkaTemplate.send(topic, requestEvent.toString());
    }
}
