package com.user_service.mapper;

import org.springframework.beans.BeanUtils;

import com.user_service.dto.CredentialDto;
import com.user_service.dto.UserDto;
import com.user_service.entity.Credential;
import com.user_service.entity.User;



public interface UserMapper {
	
	public static User toEntity(UserDto userDto) {
		
		User user = new User();
		BeanUtils.copyProperties(userDto, user);
		
		
		if(userDto.getCredentialDto() != null) {
		Credential credential = new Credential();
		BeanUtils.copyProperties(userDto.getCredentialDto(), credential);
		user.setCredential(credential);
		}
		return user;
	}
	
	public static UserDto toDto(User user) {
		
		UserDto userDto = new UserDto();
		BeanUtils.copyProperties(user, userDto);
		if(user.getCredential() != null) {
		CredentialDto credentialDto = new CredentialDto();
		BeanUtils.copyProperties(user.getCredential(), userDto);
		userDto.setCredentialDto(credentialDto);
		}
		return userDto;
		
		
		
	}

}
