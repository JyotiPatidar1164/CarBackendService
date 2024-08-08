package com.rental.car.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rental.car.entity.Customer;

public interface CustomerRepo  extends JpaRepository<Customer,Integer>{



	boolean existsByPassword(String password);

	boolean existsByEmail(String email);
	

}
