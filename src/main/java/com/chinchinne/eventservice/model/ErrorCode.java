package com.chinchinne.eventservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode
{
    INVALID_REQUEST(1020, "잘못된 요청입니다.");

    private final int code;
    private final String detail;
}
