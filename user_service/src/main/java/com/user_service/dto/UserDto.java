package com.user_service.dto;

import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
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
public class UserDto {
	
	private Integer uderId;
	@NotEmpty(message ="firstName should be required")
	private String firstName;
	private String lastName;
	@Email
	private String email;
	
	private String phone;
	
	@JsonProperty("credential")
	@JsonInclude(value=Include.NON_NULL)
	private CredentialDto credentialDto;

	
}
