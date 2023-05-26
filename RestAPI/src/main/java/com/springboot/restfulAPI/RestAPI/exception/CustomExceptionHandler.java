package com.springboot.restfulAPI.RestAPI.exception;

import com.springboot.restfulAPI.RestAPI.ErrorDetails;
import com.springboot.restfulAPI.RestAPI.user.UserNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ErrorDetails> handleAllException(Exception ex, WebRequest request) throws Exception{
        ErrorDetails error = new ErrorDetails(LocalDateTime.now(),ex.getMessage(),request.getDescription(false));
       return new ResponseEntity<ErrorDetails>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public final ResponseEntity<ErrorDetails> handleUserNotFoundException(Exception ex, WebRequest request) throws Exception{
        ErrorDetails error = new ErrorDetails(LocalDateTime.now(),ex.getMessage(),request.getDescription(false));
        return new ResponseEntity<ErrorDetails>(error, HttpStatus.NOT_FOUND);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        //ErrorDetails error = new ErrorDetails(LocalDateTime.now(),ex.getMessage(),request.getDescription(false));
        String errorMessage = String.format("Total Errors: %d. %s",ex.getErrorCount(),ex.getFieldError().getDefaultMessage());
        ErrorDetails error = new ErrorDetails(LocalDateTime.now(),errorMessage,request.getDescription(false));
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
