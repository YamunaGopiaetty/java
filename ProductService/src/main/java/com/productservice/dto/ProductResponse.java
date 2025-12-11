package com.productservice.dto;

import lombok.Data;

@Data
public class ProductResponse {
	
	private Long id;
    private String sku;
    private String name;
    private String category;
    private String description;
    private Double price;
    private Integer stock;
    private Boolean active;
    private Long createdAt;
    private Long updatedAt;

}
