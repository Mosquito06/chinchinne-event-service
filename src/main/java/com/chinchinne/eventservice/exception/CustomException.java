package com.chinchinne.eventservice.exception;

import com.chinchinne.eventservice.model.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CustomException extends RuntimeException
{
    private final ErrorCode errorCode;
}
