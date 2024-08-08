package com.rental.car.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rental.car.entity.Car;
import com.rental.car.entity.CarWithImageDataDTO;
import com.rental.car.entity.Customer;
import com.rental.car.entity.Rental;
import com.rental.car.repo.CarRepository;
import com.rental.car.repo.CustomerRepo;

@Service
public class Carservice {
	
	@Autowired
	private CarRepository r;
	
	@Autowired
	private CustomerRepo customerRepo;
	

	public List<Car> getcar() {
//		// TODO Auto-generated method stub
	List<Car> cars = new ArrayList<>();
	for(Car car : r.findAll())
	{
		car.setImageData(ImageUtils.decompressImage(car.getImageData()));
		cars.add(car);
	}
	return cars;
    
	}
	
	
	
	

	public List<Customer> getCustomer() {
		// TODO Auto-generated method stub
		List<Customer> list=customerRepo.findAll();
	return list;
}

	public void updateCar(Rental rental) {
		// TODO Auto-generated method stub
	    int carId = rental.getCarId(); // Assuming getCarId() retrieves the carId from Rental entity

		r.updateAvailability(carId);
		
	}

	public void status(int carId) {
		// TODO Auto-generated method stub
		r.statue(carId);
	}

	

	public boolean loging(String password, String email) {
		boolean user=(customerRepo.existsByEmail(email) && customerRepo.existsByPassword(password));
		return user;
	}

	
	 
	
	
	
	

}
