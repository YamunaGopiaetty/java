package com.cartservice.dto;



import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CartResponse {
	
	
	private Long cartId;
    private Long userId;
    private List<CartItemResponse> items;
    private String message;
	
	

}
