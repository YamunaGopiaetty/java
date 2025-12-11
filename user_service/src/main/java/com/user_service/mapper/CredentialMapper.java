package com.user_service.mapper;

import org.springframework.beans.BeanUtils;

import com.user_service.dto.CredentialDto;
import com.user_service.dto.UserDto;
import com.user_service.entity.Credential;
import com.user_service.entity.User;

public interface CredentialMapper {
	
	public static Credential toEntity(CredentialDto credentialDto) {
		
		Credential credential = new Credential();
		BeanUtils.copyProperties(credentialDto, credential);
		
		
		User user = new User();
		BeanUtils.copyProperties(user.getCredential(), credentialDto);
		return credential;
		
	}
	public static CredentialDto toDto(Credential credential) {
		
		CredentialDto credentialDto =new CredentialDto();
		BeanUtils.copyProperties(credential, credentialDto);
		
		if(credential.getUser()!=null) {
			UserDto userDto = new UserDto();
			BeanUtils.copyProperties(credential.getUser(), userDto);
			credentialDto.setUserDto(userDto);
			
		}
		return credentialDto;
	}
	

}
