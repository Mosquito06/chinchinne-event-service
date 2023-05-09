package com.chinchinne.eventservice.controller;

import com.chinchinne.eventservice.message.KafkaProducer;
import com.chinchinne.eventservice.vo.RequestEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class EventController
{
    KafkaProducer kafkaProducer;

    @Autowired
    public EventController(KafkaProducer kafkaProducer)
    {
        this.kafkaProducer = kafkaProducer;
    }

    @PostMapping("/{userId}/event")
    public void sendBudget(@PathVariable String userId, @RequestBody(required = true) RequestEvent requestEvent)
    {
        requestEvent.setUserId(userId);

        kafkaProducer.send(requestEvent);
    }
}