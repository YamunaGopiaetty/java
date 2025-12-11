package com.user_service.Repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.user_service.entity.Address;

public interface AddressRepository  extends JpaRepository<Address, Integer>{

}
