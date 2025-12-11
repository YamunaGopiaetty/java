package com.cartservice.service;

import com.cartservice.dto.CartItemRequest;

import com.cartservice.dto.CartResponse;

public interface CartService {

	CartResponse addItemToCart(Long userId, CartItemRequest request);
    CartResponse updateItemQuantity(Long userId, Long itemId, int quantity);
    CartResponse removeItem(Long userId, Long itemId);
    CartResponse getCartByUserId(Long userId);
    CartResponse clearCart(Long userId);
}
