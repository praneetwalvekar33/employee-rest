package com.praneet.springboot.employeerest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.praneet.springboot.employeerest.ErroHandling.EmployeeErrorResponse;
import com.praneet.springboot.employeerest.ErroHandling.EmployeeNotFoundException;

@ControllerAdvice
public class EmployeeControllerAdvise {
	
	@ExceptionHandler
	public ResponseEntity<EmployeeErrorResponse> employeeExceptionHandler(EmployeeNotFoundException exception){
		EmployeeErrorResponse errorResponse=new EmployeeErrorResponse();
		
		errorResponse.setStatus(HttpStatus.NOT_FOUND.value());
		errorResponse.setMessage(exception.getMessage());
		errorResponse.setTimeStamp(System.currentTimeMillis());
		
		return new ResponseEntity<>(errorResponse,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<EmployeeErrorResponse> employeeExceptionHandler(Exception exception){
		EmployeeErrorResponse errorResponse=new EmployeeErrorResponse();
		
		errorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
		errorResponse.setMessage(exception.getMessage());
		errorResponse.setTimeStamp(System.currentTimeMillis());
		
		return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
	}
	
	
}
