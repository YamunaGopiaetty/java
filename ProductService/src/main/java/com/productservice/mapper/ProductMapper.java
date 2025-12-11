package com.productservice.mapper;

import com.productservice.dto.ProductRequest;
import com.productservice.dto.ProductResponse;
import com.productservice.entity.Product;

public class ProductMapper {

	
	public static Product toEntity(ProductRequest req) {
		Product p = new Product();
		p.setSku(req.getSku());
		p.setName(req.getName());
		p.setCategory(req.getCategory());
		p.setDescription(req.getDescription());
		p.setPrice(req.getPrice());
		p.setStock(req.getStock());
		return p;
	}
	
	public static void updateEntity(Product entity , ProductRequest req ) {
		entity.setName(req.getName());
		entity.setCategory(req.getCategory());
		entity.setDescription(req.getDescription());
		entity.setPrice(req.getPrice());
		entity.setStock(req.getStock());
		entity.setUpdatedAt(System.currentTimeMillis());
	}
	
	public static ProductResponse toResponse(Product entity) {
		
		ProductResponse r = new ProductResponse();
		r.setId(entity.getId());
		r.setSku(entity.getSku());
		r.setName(entity.getName());
		r.setCategory(entity.getCategory());
		r.setDescription(entity.getDescription());
		r.setPrice(entity.getPrice());
		r.setStock(entity.getStock());
		r.setCreatedAt(entity.getCreatedAt());
		r.setUpdatedAt(entity.getUpdatedAt());
		return r;
		
	}
}
