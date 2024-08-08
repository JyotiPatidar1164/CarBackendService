package com.rental.car.entity;

import com.rental.car.entity.Car;

public class CarWithImageDataDTO {
    private Car car;
    private byte[] imageData;

    public CarWithImageDataDTO() {
    }

    public CarWithImageDataDTO(Car car, byte[] imageData) {
        this.car = car;
        this.imageData = imageData;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public byte[] getImageData() {
        return imageData;
    }

    public void setImageData(byte[] imageData) {
        this.imageData = imageData;
    }
}
