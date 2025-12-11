package com.user_service.entity;

import java.beans.FeatureDescriptor;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter

public class Credential {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer credentialId;
	
	@Column(unique = true)
	private String username;
	private String password;
	
	private Boolean isEnabled;
	
	
	private Boolean isAccountNotExpired;
	private Boolean isAccountNonLocked;
	private Boolean isCredentialNonExpired;
	
	@Enumerated(EnumType.STRING)
	@Column(name ="role")
	private RoleBasedAuthority roleBasedAuthority;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="user_id",nullable = false)
	private User user;
}
