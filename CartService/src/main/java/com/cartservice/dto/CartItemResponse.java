package com.cartservice.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class CartItemResponse {
	
	private Long itemId;
	private String productName;
	private Long productId;
	private Integer quantity;
	private double totalPrice;
}
