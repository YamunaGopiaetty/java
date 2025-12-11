package com.cartservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cartservice.entity.CartItem;

public interface CartItemRepository extends JpaRepository<CartItem, Long>{

}
