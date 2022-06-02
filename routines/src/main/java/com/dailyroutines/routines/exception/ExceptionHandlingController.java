package com.dailyroutines.routines.exception;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ExceptionHandlingController extends ResponseEntityExceptionHandler {

    
    Logger logger = LoggerFactory.getLogger(ExceptionHandlingController.class);
  
    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        String error = ex.getCause().getMessage();
        Pattern p = Pattern.compile("problem: (.*?)\n");
        Matcher matcher = p.matcher(error);
        String test = "test";
        while(matcher.find()) {
            test = matcher.group(1);
        }
        return buildResponseEntity(new ApiError(HttpStatus.BAD_REQUEST,test, ex.getCause()));
    }
 
    private ResponseEntity<Object> buildResponseEntity(ApiError apiError) {
        return new ResponseEntity<>(apiError, apiError.getStatus());
    }
 
}

