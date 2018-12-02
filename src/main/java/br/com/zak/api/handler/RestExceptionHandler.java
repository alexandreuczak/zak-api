package br.com.zak.api.handler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.zak.api.error.ResourceNotFoundDetail;
import br.com.zak.api.error.ResourceNotFoundException;

@ControllerAdvice
public class RestExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> handlerResourceNotFound(ResourceNotFoundException exception){
		ResourceNotFoundDetail detail = ResourceNotFoundDetail.builder()
				.title("Resource not found")
				.timestamp(new Date().getTime())
				.status(HttpStatus.NOT_FOUND.value())
				.detail(exception.getMessage())
				.error(exception.getClass().getName())
				.build();
		return new ResponseEntity<>(detail, HttpStatus.NOT_FOUND);
	}
	
}
