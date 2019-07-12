package com.chujianyun.web;

import com.chujianyun.exception.BusinessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MyExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity handle(Exception e) {
        if (e instanceof BusinessException) {
            return new ResponseEntity<>("[业务异常]" + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("[系统异常]" + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
