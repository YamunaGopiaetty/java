package com.payment_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.payment_service.dto.PaymentRequest;
import com.payment_service.dto.PaymentResponse;

import com.payment_service.service.PaymentService;

@RestController
@RequestMapping("/api/payment")
public class PaymentController {
	
	@Autowired
	private PaymentService paymentService;
	
	@PostMapping
	public ResponseEntity<PaymentResponse> makePayment(@RequestBody PaymentRequest paymentRequest) {
		PaymentResponse payment = paymentService.MakePayment(paymentRequest);
		return ResponseEntity.ok(payment);
	}
	
	@GetMapping("/order/{orderid}")
	public ResponseEntity<List<PaymentResponse>> getPayment(@PathVariable Long orderId){
		List<PaymentResponse> getPayment = paymentService.getPaymentByOrder(orderId);
		return ResponseEntity.ok(getPayment);
	}
	
	

}
