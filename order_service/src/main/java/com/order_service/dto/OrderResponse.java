package com.order_service.dto;

import java.util.List;

import lombok.Data;
import lombok.Setter;

@Data
@Setter
public class OrderResponse {
	
	private Integer orderId;
	private String status;
	private double totalAmount;
	private List<OrderItemResponse> items;
	
	
	

}
