package com.app.briskit.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.app.briskit.service.exception.UserAlreadyExistsException;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalExceptionController {
	
    @ExceptionHandler(UserAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ResponseEntity<ErrorResponse> handleUserAlreadyExistsException(HttpServletRequest request, UserAlreadyExistsException e) {
    	ErrorResponse response =  new ErrorResponse(HttpStatus.BAD_REQUEST.toString(), e.getMessage());
    	return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
