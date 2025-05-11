package com.home.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomizedExceptionHandling extends ResponseEntityExceptionHandler{
	
	 @ExceptionHandler(UserNotFoundException.class)
	    public ResponseEntity<Object> handleExceptions( UserNotFoundException exception, WebRequest webRequest) {
	        ExceptionResponse response = new ExceptionResponse();
	        response.setDateTime(LocalDateTime.now());
	        response.setMessage("User is Not valid.Please Enter valid user.");
	        ResponseEntity<Object> entity = new ResponseEntity<>(response,HttpStatus.UNAUTHORIZED);
	        return entity;
	    }

}
