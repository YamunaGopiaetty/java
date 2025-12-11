package com.productservice.service;

import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.productservice.dto.ProductRequest;
import com.productservice.dto.ProductResponse;
import com.productservice.entity.Product;
import com.productservice.exception.ResourceNotFoundException;
import com.productservice.mapper.ProductMapper;
import com.productservice.repository.ProductRepository;

import jakarta.transaction.Transactional;

@Service
public class ProductServiceImpl implements ProductService{
	
	 private final ProductRepository repo;

	  public ProductServiceImpl(ProductRepository repo) { 
		  this.repo = repo; 
		  }
	

	@Override
	@Transactional
	public ProductResponse createProduct(ProductRequest req) {
	
	
		try {
			repo.findBySku(req.getSku())
			.orElseThrow(() -> new BadRequestException("SKU already exists: " + req.getSku()));
		} catch (BadRequestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        Product saved = repo.save(ProductMapper.toEntity(req));
        return ProductMapper.toResponse(saved);
    }

	@Transactional
	@Override
	public ProductResponse updateProduct(Long id, ProductRequest req) {
		// TODO Auto-generated method stub
		Product product =repo.findById(id).orElseThrow(()->new ResourceNotFoundException("Product not found with id"+id));
		ProductMapper.updateEntity(product, req);
		return ProductMapper.toResponse(repo.save(product));
	}

	@Override
	public ProductResponse getProductById(Long id) {
		// TODO Auto-generated method stub
		return repo.findById(id).map(ProductMapper::toResponse).orElseThrow(()-> new ResourceNotFoundException("Product Not Found :" +id));
	}

	@Override
	public Page<ProductResponse> searchProduct(String keyword, int page, int size) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteproduct(Long id) {
		if(!repo.existsById(id)) {
			throw new ResourceNotFoundException("Product not found with id"+id);
		}
		
		repo.deleteById(id);
		
	}

}
