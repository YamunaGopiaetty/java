package com.productservice.service;



import org.springframework.data.domain.Page;

import com.productservice.dto.ProductRequest;
import com.productservice.dto.ProductResponse;

public interface ProductService{
	
	ProductResponse createProduct(ProductRequest req);
	ProductResponse updateProduct(Long id,ProductRequest req);
	ProductResponse getProductById(Long id);
	Page<ProductResponse> searchProduct(String keyword , int page ,int size);
	void deleteproduct(Long id);
	

}
