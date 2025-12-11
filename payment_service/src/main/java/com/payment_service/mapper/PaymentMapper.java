package com.payment_service.mapper;

import java.time.LocalDateTime;

import org.springframework.beans.BeanUtils;

import com.payment_service.dto.PaymentRequest;
import com.payment_service.dto.PaymentResponse;
import com.payment_service.entity.Payment;

public interface PaymentMapper {
	
	public static Payment toEntity(PaymentRequest paymentRequest) {
		Payment payment = new Payment();
		BeanUtils.copyProperties(paymentRequest, payment);
		payment.setStatus("PENDING");
	    payment.setPaymentDate(LocalDateTime.now());
		return payment;
	}
	
	public static PaymentResponse toDto(Payment payment) {
		PaymentResponse paymentResponse= new PaymentResponse();
		BeanUtils.copyProperties(payment, paymentResponse);
		paymentResponse.setMessage("Payment " + payment.getStatus());
		return paymentResponse;
	}

}
