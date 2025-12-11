  package com.user_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user_service.dto.CredentialDto;
import com.user_service.services.CredentialService;

@RestController
@RequestMapping("/api/credentials")
public class CredentialController {

	@Autowired
	private CredentialService credentialservices;
	
	@GetMapping("username/{username}")
	public ResponseEntity<CredentialDto> findByUsername(@PathVariable String username) {
		
		CredentialDto result = credentialservices.findByUsername(username);
		return ResponseEntity.ok(result);
		
	}
}
