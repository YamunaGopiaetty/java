package com.order_service.dto;

import com.order_service.entity.Order;

import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class OrderItemRequest {
	

	private Integer productId;
	private Integer quantity;
	private double price;
	
}
