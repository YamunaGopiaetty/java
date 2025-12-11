package com.cartservice.mapper;

import com.cartservice.dto.CartItemRequest;
import com.cartservice.dto.CartItemResponse;
import com.cartservice.dto.CartResponse;
import com.cartservice.entity.Cart;
import com.cartservice.entity.CartItem;


import org.springframework.stereotype.Component;


@Component
public class CartMapper {
	
	public CartItemResponse toDto(CartItem item) {
        if (item == null) {
            return null;
        }
        return CartItemResponse.builder()
                .productId(item.getProductId())
                .productName(item.getProductName())
                .quantity(item.getQuantity())
                .totalPrice(item.getTotalPrice())
                .build();
    }
    
}
