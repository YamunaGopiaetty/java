package com.cartservice.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.cartservice.client.ProductClient;
import com.cartservice.dto.CartItemRequest;
import com.cartservice.dto.CartResponse;
import com.cartservice.dto.ProductResponse;
import com.cartservice.entity.Cart;
import com.cartservice.entity.CartItem;
import com.cartservice.mapper.CartMapper;
import com.cartservice.repository.CartItemRepository;
import com.cartservice.repository.CartRepository;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
@Transactional
public class CartServiceImpl implements CartService{

	
	private final CartRepository cartRepository;
	//private final CartItemRepository cartItemRepository;
	private final CartMapper cartMapper;
	private final ProductClient productClient;
     
   
     
     
         
     @Override
     //@CircuitBreaker(name = "productService", fallbackMethod = "fallbackAddToCart")
     public CartResponse addItemToCart(Long userId, CartItemRequest request) {
         var product = productClient.getProductById(request.getProductId());
         if (product == null) throw new IllegalArgumentException("Product not found");

         if (request.getQuantity() > product.getStock()) {
             throw new IllegalArgumentException("Insufficient stock. Available: " + product.getStock());
         }

         Cart cart = cartRepository.findByUserId(userId).orElseGet(() -> {
             Cart c = Cart.builder().userId(userId).build();
             return cartRepository.save(c);
         });

         // if already present, update quantity
         var existing = cart.getItems().stream()
                 .filter(i -> i.getProductId().equals(request.getProductId()))
                 .findFirst();

         if (existing.isPresent()) {
             CartItem item = existing.get();
             item.setQuantity(item.getQuantity() + request.getQuantity());
             item.setTotalPrice(product.getPrice() * item.getQuantity());
             cartRepository.save(cart);
         } else {
             CartItem item = CartItem.builder()
                     .productId(product.getId())
                     .productName(product.getName())
                     .quantity(request.getQuantity())
                     .totalPrice(product.getPrice() * request.getQuantity())
                     .cart(cart)
                     .build();
             cart.getItems().add(item);
             cartRepository.save(cart);
         }

         return toCartResponse(cart);
         
     }
     
/*     public CartResponse fallbackAddToCart(Long productId, int quantity, Throwable ex) {
         return new CartResponse(0L, 0L, List.of(),"Product temporarily unavailable");
        		 //(productId, , 0, 0.0);
     }*/


     @Override
     public CartResponse updateItemQuantity(Long userId, Long itemId, int quantity) {
         Cart cart = cartRepository.findByUserId(userId)
                 .orElseThrow(() -> new IllegalArgumentException("Cart not found"));

         CartItem item = cart.getItems().stream()
                 .filter(i -> i.getId().equals(itemId))
                 .findFirst()
                 .orElseThrow(() -> new IllegalArgumentException("Item not found"));

         var product = productClient.getProductById(item.getProductId());
         if (product == null) throw new IllegalArgumentException("Product not found");
         if (quantity > product.getStock()) throw new IllegalArgumentException("Insufficient stock");

         item.setQuantity(quantity);
         item.setTotalPrice(product.getPrice() * quantity);

         cartRepository.save(cart);
         return toCartResponse(cart);
     }

     @Override
     public CartResponse removeItem(Long userId, Long itemId) {
         Cart cart = cartRepository.findByUserId(userId)
                 .orElseThrow(() -> new IllegalArgumentException("Cart not found"));

         cart.getItems().removeIf(i -> i.getId().equals(itemId));
         cartRepository.save(cart);
         return toCartResponse(cart);
     }

     @Override
     public CartResponse getCartByUserId(Long userId) {
         Cart cart = cartRepository.findByUserId(userId).orElseGet(() -> Cart.builder().userId(userId).build());
         return toCartResponse(cart);
     }

     @Override
     public CartResponse clearCart(Long userId) {
         Cart cart = cartRepository.findByUserId(userId)
                 .orElseThrow(() -> new IllegalArgumentException("Cart not found"));
         cart.getItems().clear();
         cartRepository.save(cart);
         return toCartResponse(cart);
     }

     private CartResponse toCartResponse(Cart cart) {
         var items = cart.getItems().stream()
                 .map(cartMapper::toDto)
                 .collect(Collectors.toList());
         return CartResponse.builder()
                 .cartId(cart.getId())
                 .userId(cart.getUserId())
                 
                 .items(items)
                 .build();
     }

}
