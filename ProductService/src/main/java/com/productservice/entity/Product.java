package com.productservice.entity;

import java.time.Instant;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false,unique = true)
	private String sku;
	
	@Column(nullable = false)
	private String name;
	
	private String category;
	
	@Column(length = 2000)
	private String description;
	
	@Column(nullable = false)
    private Double price;
	
	@Column(nullable = false)
	private Integer stock;
	
	private Boolean active =true;
	
	private Long createdAt =Instant.now().toEpochMilli();
	private Long updatedAt=Instant.now().toEpochMilli();
	
	

}
