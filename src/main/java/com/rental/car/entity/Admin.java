package com.rental.car.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
	public class Admin {
	
		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
		private int adminId;
		private String name;
		private int number;
		private String email;
		private int password;
		
		@Override
		public String toString() {
			return "Admin [adminId=" + adminId + ", name=" + name + ", number=" + number + ", email=" + email
					+ ", password=" + password + "]";
		}
		public int getAdminId() {
			return adminId;
		}
		public void setAdminId(int adminId) {
			this.adminId = adminId;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public Admin(int adminId, String name, int number, String email, int password) {
			super();
			this.adminId = adminId;
			this.name = name;
			this.number = number;
			this.email = email;
			this.password = password;
		}
		
		public Admin()
		{
			
		}
		public int getNumber() {
			return number;
		}
		public void setNumber(int number) {
			this.number = number;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public int getPassword() {
			return password;
		}
		public void setPassword(int password) {
			this.password = password;
		}
		
		

	


}
