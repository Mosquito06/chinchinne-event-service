package com.chinchinne.eventservice.controller;

import com.chinchinne.eventservice.exception.CustomException;
import com.chinchinne.eventservice.message.KafkaProducer;
import com.chinchinne.eventservice.model.ErrorCode;
import com.chinchinne.eventservice.vo.RequestEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class EventController
{
    private KafkaProducer kafkaProducer;

    @Autowired
    public EventController(KafkaProducer kafkaProducer)
    {
        this.kafkaProducer = kafkaProducer;
    }

    @PostMapping("/{userId}/event")
    public void sendBudget(@PathVariable String userId, @RequestBody(required = true) RequestEvent requestEvent)
    {
        requestEvent.setUserId(userId);

        if( ObjectUtils.isEmpty( requestEvent.getEventCode() ) )
        {
            throw new CustomException( ErrorCode.INVALID_REQUEST );
        }

        kafkaProducer.send(requestEvent);
    }
}