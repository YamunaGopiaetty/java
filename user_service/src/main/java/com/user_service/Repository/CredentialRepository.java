package com.user_service.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


import com.user_service.entity.Credential;

public interface CredentialRepository extends JpaRepository<Credential, Integer>{
	
	//DSL Domain specific languages methods
	
	
	Optional<Credential> findByUsername(String username);
	
	

}
