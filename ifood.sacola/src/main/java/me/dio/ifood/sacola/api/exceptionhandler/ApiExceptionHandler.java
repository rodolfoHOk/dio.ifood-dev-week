package me.dio.ifood.sacola.api.exceptionhandler;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import me.dio.ifood.sacola.domain.exception.BadRequestException;
import me.dio.ifood.sacola.domain.exception.BusinessException;
import me.dio.ifood.sacola.domain.exception.EntityInUseException;
import me.dio.ifood.sacola.domain.exception.ResourceNotFoundException;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> handleResourceNotFound(ResourceNotFoundException ex, WebRequest request) {
		HttpStatus status = HttpStatus.NOT_FOUND;
		var problem = new ProblemResponse(ex.getMessage(), status.value());
		
		return handleExceptionInternal(ex, problem, new HttpHeaders(), status, request);
	}
	
	@ExceptionHandler(EntityInUseException.class)
	public ResponseEntity<?> handleEntityInUse(EntityInUseException ex, WebRequest request) {
		HttpStatus status = HttpStatus.CONFLICT;
		var problem = new ProblemResponse(ex.getMessage(), status.value());
		
		return handleExceptionInternal(ex, problem, new HttpHeaders(), status, request);
	}
	
	@ExceptionHandler(BadRequestException.class)
	public ResponseEntity<?> handleEntityInUse(BadRequestException ex, WebRequest request) {
		HttpStatus status = HttpStatus.BAD_REQUEST;
		var problem = new ProblemResponse(ex.getMessage(), status.value());
		
		return handleExceptionInternal(ex, problem, new HttpHeaders(), status, request);
	}
	
	@ExceptionHandler(BusinessException.class)
	public ResponseEntity<?> handleEntityInUse(BusinessException ex, WebRequest request) {
		HttpStatus status = HttpStatus.BAD_REQUEST;
		var problem = new ProblemResponse(ex.getMessage(), status.value());
		
		return handleExceptionInternal(ex, problem, new HttpHeaders(), status, request);
	}

}
