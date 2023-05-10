package com.chinchinne.eventservice.message;

import com.chinchinne.eventservice.model.Record;
import com.chinchinne.eventservice.vo.RequestEvent;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

import static java.sql.Timestamp.valueOf;

@Service
public class KafkaProducer
{
    private KafkaTemplate<String, String> kafkaTemplate;
    private ObjectMapper objectMapper;

    @Value("${spring.kafka.custom.topic}")
    private String topic;

    @Autowired
    public KafkaProducer(KafkaTemplate<String, String> kafkaTemplate, ObjectMapper objectMapper)
    {
        this.kafkaTemplate = kafkaTemplate;
        this.objectMapper = objectMapper;
    }

    public void send(RequestEvent requestEvent)
    {
        Object value = null;

        switch( requestEvent.getEventCode() )
        {
            case BUDGET:
                value = requestEvent.getBudget();
                break;
            case MEM0:
                value = requestEvent.getMemo();
                break;
            case CATEGORY:
                value = requestEvent.getCategory();
                break;
        }

        Record record = new Record(requestEvent.getUserId(), requestEvent.getEventCode(), value, valueOf(LocalDateTime.now()));

        try
        {
            kafkaTemplate.send(topic, objectMapper.writeValueAsString(record));
        }
        catch ( JsonProcessingException e )
        {
            throw new RuntimeException(e);
        }
    }
}