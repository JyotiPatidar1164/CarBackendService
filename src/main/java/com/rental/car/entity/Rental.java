package com.rental.car.entity;



import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
@Component
public class Rental {
	
@Id	
private int carId;
private String name;
private String email;
private int day;
private String status;
private LocalDate fromDate;
private LocalDate toDate;
private int price;




public Rental()
{
}









public int getPrice() {
	return price;
}









public void setPrice(int price) {
	this.price = price;
}









@Override
public String toString() {
	return "Rental [carId=" + carId + ", name=" + name + ", email=" + email + ", day=" + day + ", status=" + status
			+ ", fromDate=" + fromDate + ", toDate=" + toDate + ", price=" + price + "]";
}









public Rental(int carId, String name, String email, int day, LocalDate fromDate, LocalDate toDate) {
	super();
	this.carId = carId;
	this.name = name;
	this.email = email;
	this.day = day;
	this.fromDate = fromDate;
	this.toDate = toDate;
}









public int getCarId() {
	return carId;
}




public void setCarId(int carId) {
	this.carId = carId;
}




public String getName() {
	return name;
}




public void setName(String name) {
	this.name = name;
}




public String getEmail() {
	return email;
}




public void setEmail(String email) {
	this.email = email;
}




public int getDay() {
	return day;
}




public void setDay(int day) {
	this.day = day;
}




public String getStatus() {
	return status;
}

public void setStatus(String status) {
	this.status = status;
	
}

public LocalDate getFromDate() {
	return fromDate;
}




public void setFromDate(LocalDate fromDate) {
	this.fromDate = fromDate;
}




public LocalDate getToDate() {
	return toDate;
}




public void setToDate(LocalDate toDate) {
	this.toDate = toDate;
}

}

