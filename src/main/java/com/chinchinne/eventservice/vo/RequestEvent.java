package com.chinchinne.eventservice.vo;

import com.chinchinne.eventservice.model.EventCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.math.BigInteger;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class RequestEvent
{
    private String userId;

    private EventCode eventCode;

    private BigInteger budget;

    private String memo;

    private String category;
}
