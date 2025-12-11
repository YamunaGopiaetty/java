package com.payment_service.service;

import java.util.List;

import com.payment_service.dto.PaymentRequest;
import com.payment_service.dto.PaymentResponse;

public interface PaymentService {
	
	PaymentResponse MakePayment(PaymentRequest paymentRequest);
	
	List<PaymentResponse> getPaymentByOrder(Long orderId);

}
