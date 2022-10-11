package com.ananda.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ErrorDetails> handleAllExceptions(Exception ex, WebRequest request) throws Exception

	{
		ErrorDetails errDetails = new ErrorDetails(ex.getMessage(), request.getDescription(false));

		return new ResponseEntity<ErrorDetails>(errDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(BookNotFoundException.class)
	public final ResponseEntity<ErrorDetails> bookNotFoundException(Exception ex, WebRequest request) throws Exception

	{
		ErrorDetails errDetails = new ErrorDetails(ex.getMessage(), request.getDescription(false));

		return new ResponseEntity<ErrorDetails>(errDetails, HttpStatus.NOT_FOUND);
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		ErrorDetails errDetails = new ErrorDetails(
				"total errors" + ex.getErrorCount() + "First error: " + ex.getFieldError().getDefaultMessage(),
				request.getDescription(false));

		return new ResponseEntity<Object>(errDetails, HttpStatus.BAD_REQUEST);

	}

}
