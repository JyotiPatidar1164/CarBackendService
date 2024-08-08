package com.rental.car.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Customer {
	
	@Id
	private int aadhar_number;
	private String name;
	private String phone;
	private String email;
	private String password;
	
	
	public Customer(int aadhar_number, String name, String phone, String email, String password) {
		super();
		this.aadhar_number = aadhar_number;
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.password = password;
	}
	public int getAadhar_number() {
		return aadhar_number;
	}
	public void setAadhar_number(int aadhar_number) {
		this.aadhar_number = aadhar_number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Customer [aadhar_number=" + aadhar_number + ", name=" + name + ", phone=" + phone + ", email=" + email
				+ ", password=" + password + "]";
	}
	public Customer()
	{
		}
	}
	
	