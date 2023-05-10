package com.chinchinne.eventservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;


@AllArgsConstructor
public enum EventCode implements CodeValue
{
     MEM0("M", "메모")
    ,BUDGET("B", "예산")
    ,CATEGORY("C", "카테고리");

    private String code;

    private String value;

    @Override
    public String getCode()
    {
        return this.code;
    }

    @Override
    public String getValue()
    {
        return this.value;
    }
}
