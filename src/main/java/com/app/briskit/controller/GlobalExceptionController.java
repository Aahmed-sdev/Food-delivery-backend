package com.app.briskit.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.app.briskit.exception.InvalidUserInputException;
import com.app.briskit.exception.TokenGenerationException;
import com.app.briskit.exception.UserAlreadyExistsException;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalExceptionController {
	
    @ExceptionHandler(UserAlreadyExistsException.class)
    @ResponseBody
    public ResponseEntity<ErrorResponse> handleUserAlreadyExistsException(HttpServletRequest request, UserAlreadyExistsException e) {
    	ErrorResponse response =  new ErrorResponse(HttpStatus.BAD_REQUEST.toString(), e.getMessage());
    	return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
    
    @ExceptionHandler(InvalidUserInputException.class)
    @ResponseBody
    public ResponseEntity<ErrorResponse> handleInvalidUserInputException(HttpServletRequest request, InvalidUserInputException e) {
    	ErrorResponse response =  new ErrorResponse(HttpStatus.BAD_REQUEST.toString(), e.getMessage());
    	return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
    
    @ExceptionHandler(TokenGenerationException.class)
    @ResponseBody
    public ResponseEntity<ErrorResponse> handleTokenGenerationException(HttpServletRequest request, TokenGenerationException e){
    	ErrorResponse response = new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.toString(), "Unexpected Error occured while processing request");
    	return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
