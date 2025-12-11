package com.productservice.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
import lombok.Getter;

@Getter
public class ApiError {
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime timestamp;
	private int status;
	private String error;
	private String message;
	private String path;
	public ApiError(HttpStatus status, String message, String path) {
		super();
		this.timestamp = LocalDateTime.now();
		this.status = status.value();
		this.error = status.getReasonPhrase();
		this.message = message;
		this.path = path;
	}
	
	
	

}
