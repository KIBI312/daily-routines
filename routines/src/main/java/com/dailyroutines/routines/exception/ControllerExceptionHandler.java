// package com.dailyroutines.routines.exception;

// import java.util.Date;

// import org.springframework.http.HttpStatus;
// import org.springframework.web.bind.annotation.ExceptionHandler;
// import org.springframework.web.bind.annotation.ResponseStatus;
// import org.springframework.web.bind.annotation.RestControllerAdvice;
// import org.springframework.web.context.request.WebRequest;
// import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

// @RestControllerAdvice
// public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {
    
    
//     @ExceptionHandler(Exception.class)
//     @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
//     public ErrorMessage globalExceptionHandler(Exception exc, WebRequest request) {
//         ErrorMessage message = new ErrorMessage(
//             HttpStatus.INTERNAL_SERVER_ERROR.value(),
//             new Date(),
//             exc.getMessage(),
//             request.getDescription(false));
//     return message;
//     }
// }