package com.payment_service.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.payment_service.client.OrderClient;
import com.payment_service.dto.PaymentRequest;
import com.payment_service.dto.PaymentResponse;
import com.payment_service.entity.Payment;
import com.payment_service.mapper.PaymentMapper;
import com.payment_service.repository.PaymentRepository;

@Service
public class PaymentServiceImpl implements PaymentService{
	
	@Autowired
	private PaymentRepository paymentRepository;
	@Autowired
	private OrderClient orderClient;
	
	@Override
	public PaymentResponse MakePayment(PaymentRequest paymentRequest) {
		// TODO Auto-generated method stub
		Payment payment = PaymentMapper.toEntity(paymentRequest);
		payment= paymentRepository.save(payment);
		if(paymentRequest.getAmount() >0) {
			payment.setStatus("SUCCESS");
			orderClient.UpdateOrderStatus(paymentRequest.getOrderId(), "PAID");
		}else {
			payment.setStatus("failed");
			orderClient.UpdateOrderStatus(paymentRequest.getOrderId(), "PAYMENT_FAILED");
		}
		payment = paymentRepository.save(payment);
		
		return PaymentMapper.toDto(payment);
	}

	@Override
	public List<PaymentResponse> getPaymentByOrder(Long orderId) {
		// TODO Auto-generated method stub
		return paymentRepository.findByOrderId(orderId)
				.stream().map(PaymentMapper::toDto).collect(Collectors.toList());
	}

}
