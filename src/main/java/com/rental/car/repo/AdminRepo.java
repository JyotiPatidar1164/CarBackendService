package com.rental.car.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rental.car.entity.Admin;

public interface AdminRepo extends JpaRepository<Admin,Integer>{
	
	boolean existsByPassword(int  password);

	boolean existsByEmail(String email);

}
