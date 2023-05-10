package com.chinchinne.eventservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@Getter
@AllArgsConstructor
public class Record
{
    private String userId;
    private EventCode type;
    private Object value;
    private Date sendDate;
}
