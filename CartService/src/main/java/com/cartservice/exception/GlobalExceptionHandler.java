package com.cartservice.exception;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;




@ControllerAdvice
public class GlobalExceptionHandler {
	
	 @ExceptionHandler(IllegalArgumentException.class)
	    public ResponseEntity<ErrorBody> handleBadRequest(IllegalArgumentException ex) {
	        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorBody(ex.getMessage()));
	    }

	    @ExceptionHandler(MethodArgumentNotValidException.class)
	    public ResponseEntity<ErrorBody> handleValidation(MethodArgumentNotValidException ex) {
	        String errors = ex.getBindingResult().getFieldErrors()
	                .stream().map(e -> e.getField() + ": " + e.getDefaultMessage())
	                .collect(Collectors.joining(", "));
	        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorBody(errors));
	    }

	    @ExceptionHandler(Exception.class)
	    public ResponseEntity<ErrorBody> handleAll(Exception ex) {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ErrorBody(ex.getMessage()));
	    }

	    record ErrorBody(String message) {}


}
