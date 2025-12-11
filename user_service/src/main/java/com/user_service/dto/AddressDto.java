package com.user_service.dto;



import com.user_service.entity.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class AddressDto {
	
	private Integer addressId;
	private String fullAddress;
	private String postalCode;
	private String city;
	
	
	private User user;

}
