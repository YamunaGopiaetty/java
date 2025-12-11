package com.payment_service.exception;

import java.time.LocalDateTime;



import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class ErrorResponse {
	
	private LocalDateTime timestamp;
	private String message;
	private String details;
	
	public ErrorResponse(String message , String details) {
		this.timestamp=LocalDateTime.now();
		this.message=message;
		this.details=details;
	}

}
