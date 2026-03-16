package com.dsc.app.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ExceptionResponse> handleValidationErrors(MethodArgumentNotValidException ex) {

	    String message = ex.getBindingResult().getFieldError().getDefaultMessage();

	    ExceptionResponse response =
	            new ExceptionResponse(
	                    HttpStatus.BAD_REQUEST.value(),
	                    message
	            );

	    return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	}
    // Handles custom RequiredFieldException
//	@ExceptionHandler(RequiredFieldException.class)
//	public ResponseEntity<ExceptionResponse> handleRequiredField(RequiredFieldException ex) {
//
//	    ExceptionResponse response =
//	            new ExceptionResponse(
//	                    HttpStatus.BAD_REQUEST.value(),
//	                    ex.getMessage()  // <-- NO prefix added here
//	            );
//
//	    return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
//	}
	
	@ExceptionHandler(RequiredFieldException.class)
	public ResponseEntity<ExceptionResponse> handleRequiredFieldException(RequiredFieldException ex) {
	    ExceptionResponse response =
	            new ExceptionResponse(
	                    HttpStatus.BAD_REQUEST.value(),
	                    ex.getMessage()  // message already includes "Required Field Error: ..."
	            );
	    return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	}
}