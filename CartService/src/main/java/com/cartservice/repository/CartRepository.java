package com.cartservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

//import com.cartservice.dto.CartResponse;
import com.cartservice.entity.Cart;

public interface CartRepository extends JpaRepository<Cart, Long> {

	//CartResponse findByUserId(Long userId);

	Optional<Cart> findByUserId(Long userId);

}
