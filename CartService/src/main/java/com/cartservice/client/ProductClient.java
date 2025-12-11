package com.cartservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cartservice.dto.ProductResponse;

@FeignClient(name = "product-service", url = "http://localhost:8081/api/products")
public interface ProductClient {
	
	@GetMapping("/{id}")
   ProductResponse getProductById(@PathVariable("id") Long id);
	
	 record ProductDTO(Long id, String name, String description, double price, int stock, String sku) {}
}
