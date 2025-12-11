package com.payment_service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalException {
	
	@ExceptionHandler(OrderServiceException.class)
	public ResponseEntity<ErrorResponse> handleOrderServiceException(OrderServiceException ex, WebRequest request){
		ErrorResponse errorRespnse = new ErrorResponse(
			ex.getMessage(),request.getDescription(false)	
			);
	
		return new  ResponseEntity<>(errorRespnse,HttpStatus.BAD_REQUEST);
		
}
	
	
	@ExceptionHandler(PaymentNotFoundException.class)
	public ResponseEntity<ErrorResponse> handlePaymentNotFoundException(PaymentNotFoundException ex, WebRequest request){
		ErrorResponse errorRespnse = new ErrorResponse(
			ex.getMessage(),request.getDescription(false)	
			);
	
		return new  ResponseEntity<>(errorRespnse,HttpStatus.NOT_FOUND);
	}
	

}
