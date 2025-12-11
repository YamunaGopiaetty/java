package com.productservice.controller;

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
import org.springframework.web.bind.annotation.RestController;

import com.productservice.dto.ProductRequest;
import com.productservice.dto.ProductResponse;
import com.productservice.service.ProductService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProducrController {
	
	
	private final ProductService service;
	
	@PostMapping
	public ResponseEntity<ProductResponse> create(@Valid @RequestBody ProductRequest req){
		return ResponseEntity.status(HttpStatus.CREATED).body(service.createProduct(req));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<ProductResponse> update(@PathVariable Long id,@Valid @RequestBody ProductRequest req){
		return ResponseEntity.ok(service.updateProduct(id, req));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ProductResponse> getProductById(@PathVariable Long id){
		return ResponseEntity.ok(service.getProductById(id));
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		service.deleteproduct(id);
		return ResponseEntity.noContent().build();
	}

}
