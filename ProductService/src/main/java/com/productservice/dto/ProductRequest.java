package com.productservice.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ProductRequest {
	
	@NotBlank
	private String sku;
	
	@NotBlank
	private String name;
	private String category;
	private String description;
	
	@NotNull
	@DecimalMin("0.0")
	private Double price;
	
	@NotNull
	@Min(0)
	private Integer stock;

}
