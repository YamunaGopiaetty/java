package com.user_service.exception;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter

@AllArgsConstructor
@NoArgsConstructor
public class ApiError {
	
	private HttpStatus status;
	private String message;
	
}
