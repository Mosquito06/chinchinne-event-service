package com.chinchinne.eventservice.handler;

import com.chinchinne.eventservice.exception.CustomException;
import com.chinchinne.eventservice.model.ErrorCode;
import com.chinchinne.eventservice.model.ErrorResponse;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler
{
    @ExceptionHandler({ CustomException.class })
    protected ResponseEntity<ErrorResponse> handleCustomException(CustomException ex)
    {
        int status = HttpStatus.INTERNAL_SERVER_ERROR.value();

        ErrorResponse res = ErrorResponse.builder()
                                        .status(ex.getErrorCode().getCode())
                                        .error(ex.getErrorCode().name())
                                        .code(ex.getErrorCode().getCode())
                                        .message(ex.getErrorCode().getDetail())
                                        .build();

        return ResponseEntity.status(status).body(res);
    }

    @ExceptionHandler({ InvalidFormatException.class })
    protected ResponseEntity<ErrorResponse> handleMethodArgumentNotValidException()
    {
        ErrorResponse res = ErrorResponse.builder()
                                        .status(ErrorCode.INVALID_REQUEST.getCode())
                                        .error(ErrorCode.INVALID_REQUEST.name())
                                        .code(ErrorCode.INVALID_REQUEST.getCode())
                                        .message(ErrorCode.INVALID_REQUEST.getDetail())
                                        .build();

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(res);
    }
}
