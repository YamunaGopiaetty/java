package com.user_service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CredentialDto {
	
    private Integer credentialId;
	
	
	private String username;
	private String password;
	
	private Boolean isEnabled;
	
	
	private Boolean isAccountNotExpired;
	private Boolean isAccountNonLocked;
	private Boolean isCredentialNonExpired;
	
	@JsonProperty("user")
	private UserDto userDto;

}
