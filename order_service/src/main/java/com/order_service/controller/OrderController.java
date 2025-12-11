package com.order_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.order_service.dto.OrderRequest;
import com.order_service.dto.OrderResponse;
import com.order_service.services.OrderService;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
	
	@Autowired
	public OrderService orderservice;
	
	@PostMapping
	public ResponseEntity<OrderResponse> createOrder(@RequestBody OrderRequest orderRequest) {
		OrderResponse placedOrder = orderservice.createOrder(orderRequest);
		return ResponseEntity.ok(placedOrder);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<OrderResponse> findById(@PathVariable Integer id){
		OrderResponse findBy = orderservice.findById(id);
		return ResponseEntity.ok(findBy);
	}
	
	
	@GetMapping
	public ResponseEntity<List<OrderResponse>> findAll(){
		List<OrderResponse> findAll = orderservice.findAllOrders();
		return ResponseEntity.ok(findAll);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteById(@PathVariable Integer id){
		orderservice.deleteOrder(id);
		return ResponseEntity.ok("Order deleted successfully!");
	}
	
	@PutMapping("/{orderId}/status")
	public ResponseEntity<String> updateOrderStatus(@PathVariable Integer orderId,
	                                                @RequestParam String status) {
	    orderservice.updateOrderStatus(orderId, status);
	    return ResponseEntity.ok("Order status updated to " + status);
	}
}
