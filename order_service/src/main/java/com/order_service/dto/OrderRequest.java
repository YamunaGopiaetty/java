package com.order_service.dto;

import java.util.List;

import lombok.Data;

@Data
public class OrderRequest {
	
	private Integer userId;

	private List<OrderItemRequest> items;

}
