package com.user_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.user_service.dto.UserDto;
import com.user_service.services.UserService;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(value ="/api/users")
@Slf4j
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping
	public ResponseEntity<UserDto> save(@Valid @RequestBody UserDto userDto) {
		log.info("UserController :: save");
		UserDto dbUser = userService.createUser(userDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(dbUser);
	}
	
	@GetMapping("/{userId}")
	public ResponseEntity<UserDto> findById(@PathVariable Integer userId){
		log.info("UserController ::  fetch User details");
		return ResponseEntity.ok(userService.findById(userId));
	}
	@GetMapping
	public ResponseEntity<List<UserDto>> findAll(){
		log.info("UserController ::  fetch All User details");
		return ResponseEntity.ok(userService.findAll());
	}
	
	@DeleteMapping("/{userId}")
	public void deleteUserId(@PathVariable Integer userId) {
		log.info("UserController :: Delete User details");
		userService.deleteById(userId);
		
		ResponseEntity.noContent().build();
	}
}
