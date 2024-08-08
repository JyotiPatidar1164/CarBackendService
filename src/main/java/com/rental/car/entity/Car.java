package com.rental.car.entity;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;


@Entity
public class Car {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int carId;
	private String brand;
	private String colour;
	private double basePricePerDay;
	@JsonProperty("isAvailable")
	private boolean isAvailable;
	@Lob
	@Column(name = "imageData", columnDefinition = "MEDIUMBLOB")
	private byte[] imageData;
	public int getCarId() {
		return carId;
	}
	public void setCarId(int carId) {
		this.carId = carId;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	public String getColour() {
		return colour;
	}
	public void setColour(String colour) {
		this.colour = colour;
	}
	public double getBasePricePerDay() {
		return basePricePerDay;
	}
	public void setBasePricePerDay(double basePricePerDay) {
		this.basePricePerDay = basePricePerDay;
	}
	public boolean isAvailable() {
		return isAvailable;
	}
	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	public byte[] getImageData() {
		return imageData;
	}
	public void setImageData(byte[] imageData) {
		this.imageData = imageData;
	}
//	public Car(int carId, String brand, String colour, double basePricePerDay, boolean isAvailable,byte[] imageData) {
//		super();
//		this.carId = carId;
//		this.brand = brand;
//		this.colour = colour;
//		this.basePricePerDay = basePricePerDay;
//		this.isAvailable = isAvailable;
//		this.imageData = imageData;
//	}
	public Car()
	{
		
	}
	public Car(int carId, String brand, String colour, double basePricePerDay, boolean isAvailable, byte[] imageData) {
	super();
	this.carId = carId;
	this.brand = brand;
	this.colour = colour;
	this.basePricePerDay = basePricePerDay;
	this.isAvailable = isAvailable;
	this.imageData = imageData;
}
	@Override
	public String toString() {
		return "Car [carId=" + carId + ", brand=" + brand + ", colour=" + colour + ", basePricePerDay=" + basePricePerDay
				+ ", isAvailable=" + isAvailable + "]";
	}
	
	
	public double calculatePrice (int day)
	{
		return day*basePricePerDay;
	}
	
	
}
