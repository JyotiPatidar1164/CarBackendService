package com.rental.car.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rental.car.repo.AdminRepo;

@Service
public class AdminService {
	
	@Autowired
	private AdminRepo adminRepo;
	
	public boolean logingAdmin(int password, String email) {
		boolean user=(adminRepo.existsByEmail(email) && adminRepo.existsByPassword(password));
		return user;
	}
	
	
	 

}
