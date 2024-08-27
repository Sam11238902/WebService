package com.webservice.webservice.resources.execptions;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.webservice.webservice.service.exceptions.DataBaseException;
import com.webservice.webservice.service.exceptions.ResourceNotFoundException;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<StandartError> ResourceNotFound(ResourceNotFoundException e, HttpServletRequest request){
	
	String error = "Resource Not Found ";
	HttpStatus status = HttpStatus.NOT_FOUND;
	StandartError err = new StandartError(Instant.now(),status.value(), error, e.getMessage(),request.getRequestURI());
	
	
	return ResponseEntity.status(status).body(err);
		
	}
	
	
	@ExceptionHandler(DataBaseException.class)
	public ResponseEntity<StandartError> ResourceNotFound(DataBaseException e, HttpServletRequest request){
	
	String error = "Bad Request Violate DB ";
	HttpStatus status = HttpStatus.BAD_REQUEST;
	StandartError err = new StandartError(Instant.now(),status.value(), error, e.getMessage(),request.getRequestURI());
	
	
	return ResponseEntity.status(status).body(err);
		
	}

	
}
