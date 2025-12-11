package com.cartservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cartservice.dto.CartItemRequest;
import com.cartservice.dto.CartResponse;
import com.cartservice.service.CartService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/cart") 
@RequiredArgsConstructor
public class CartController {
	
	 private final CartService cartService;

    // add item (JSON body)
    @PostMapping("/{userId}/items")
    public ResponseEntity<CartResponse> addItemToCart(@PathVariable Long userId,
                                                @Valid @RequestBody CartItemRequest request) {
        CartResponse response = cartService.addItemToCart(userId, request);
        return  ResponseEntity.ok(response);
    }

    // get cart
    @GetMapping("/{userId}")
    public ResponseEntity<CartResponse> getCart(@PathVariable Long userId) {
        return ResponseEntity.ok(cartService.getCartByUserId(userId));
    }

    // update item quantity
    @PutMapping("/{userId}/items/{itemId}")
    public ResponseEntity<CartResponse> updateItemQuantity(@PathVariable Long userId,
                                                           @PathVariable Long itemId,
                                                           @RequestParam int quantity) {
        return ResponseEntity.ok(cartService.updateItemQuantity(userId, itemId, quantity));
    }

    // remove item
    @DeleteMapping("/{userId}/items/{itemId}")
    public ResponseEntity<CartResponse> removeItem(@PathVariable Long userId,
                                                   @PathVariable Long itemId) {
        return ResponseEntity.ok(cartService.removeItem(userId, itemId));
    }

    // clear cart
    @DeleteMapping("/{userId}")
    public ResponseEntity<CartResponse> clearCart(@PathVariable Long userId) {
        return ResponseEntity.ok(cartService.clearCart(userId));
    }

}
