package com.rental.car.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rental.car.entity.Admin;
import com.rental.car.entity.Car;
import com.rental.car.entity.CarWithImageDataDTO;
import com.rental.car.entity.Customer;
import com.rental.car.entity.Rental;
import com.rental.car.repo.AdminRepo;
import com.rental.car.repo.CarRepository;
import com.rental.car.repo.CustomerRepo;
import com.rental.car.repo.RentalRepo;
import com.rental.car.service.AdminService;
import com.rental.car.service.Carservice;
import com.rental.car.service.ImageUtils;
import com.rental.car.service.StorageService;
import java.time.Duration;

import jakarta.transaction.Transactional;

@RestController
@CrossOrigin(origins = "*")
public class Controller {
	

@Autowired
private Carservice s;

@Autowired
private CarRepository repo;

@Autowired
private CustomerRepo customerRepo;

@Autowired
private RentalRepo rentalRepo;

@Autowired
private AdminService adminService;

@Autowired
private AdminRepo admiRepo;

@Autowired
private Rental rental;

@GetMapping("/car")
public List<Car> getCarsWithImages() {
	return  s.getcar();
    
}
@PostMapping("/addCar")
public void addCar(@RequestParam("image")MultipartFile file,@RequestParam("cardetails")String cardetails)
{
	ObjectMapper objectMapper = new ObjectMapper();
    try {
		Car car = objectMapper.readValue(cardetails, Car.class);
		System.out.println(car.toString());
		car.setImageData(ImageUtils.compressImage(file.getBytes()));
		repo.save(car);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 

	
	}

@DeleteMapping("/deleteCar/{carId}")
public void deleteCar(@PathVariable("carId") int carId )
{
	repo.deleteById(carId);
}

@PutMapping("/updateCar/{carId}")

	public void updateCar(@PathVariable("carId") int carId, @RequestBody Car car)
	{
    repo.save(car);	
}

@GetMapping("/cutomer")
public List<Customer> getCustomer()
{
	
	List<Customer> list=s.getCustomer();
	return list;	
}

@PostMapping("/addCustomer")
public void addCar(@RequestBody Customer customer)
{
	customerRepo.save(customer);
	}


@PostMapping("/login")
public String loging(@RequestBody Customer login)
{
	 
	 boolean b=s.loging(login.getPassword(),login.getEmail());
	 
	 if(b)
	 { 
		 return "user exits";
	 }
	 else {
           return "not exist";
       }
	 

}


@PostMapping("/loginAdmin")
public String logingAdmin(@RequestBody Admin login)
{
	 
	 boolean b=adminService.logingAdmin(login.getPassword(),login.getEmail());
	 
	 if(b)
	 { 
		 return "user exits";
	 }
	 else {
           return "not exist";
       }
	 

}


@PostMapping("addAdmin")
public void addAdmin(@RequestBody Admin admin)
{
	admiRepo.save(admin);
	}

@GetMapping("/getAdmin")
public List<Admin> getAdmin()
{
	
	List<Admin> list=admiRepo.findAll();
	return list;
	
	}


//
//@PostMapping("/selectCar")
//@Transactional
//public ResponseEntity<String> selectCar(@RequestBody Rental rental) {
//
//     
//    if (repo.findById(rental.getCarId()).isPresent()) {
//    	if(rental.getDay()==(rental.getToDate()-rental.getFromDate()))
//    	{
//    		rental.setStatus("Booked");
//            rentalRepo.save(rental);
//            s.updateCar(rental);
//            return ResponseEntity.ok("Car Book");
//    	}
//    
//    } else {
//        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Car with provided ID does not exist");
//    }
//}

@PostMapping("/selectCar")
@Transactional
public ResponseEntity<String> selectCar(@RequestBody Rental rental) {
    if (repo.findById(rental.getCarId()).isPresent()) {
        LocalDate fromDate = rental.getFromDate();
        LocalDate toDate = rental.getToDate();
        long rentalDays = Duration.between(fromDate.atStartOfDay(), toDate.atStartOfDay()).toDays();
        
        if (rental.getDay() == rentalDays) {
            rental.setStatus("Booked");
            int pricePerDay = repo.price(rental.getCarId());
            rental.setPrice(rental.getDay() * pricePerDay);
            rentalRepo.save(rental);
            s.updateCar(rental);
            return ResponseEntity.ok("Car Booked"+ "price="+ pricePerDay);
        } else {
        	return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Car Days Not Correct According Date");
            // Number of rental days does not match the duration, handle accordingly
        }
    } else {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Car with provided ID does not exist");
    }
}



@GetMapping("/rental")
public List<Rental> rental()
{
	
	List<Rental> list=rentalRepo.findAll();
	return list;
}

@DeleteMapping("/rentalDelete/{carId}")
@Transactional
public void deleteRental(@PathVariable("carId") int carId) {
    rentalRepo.deleteById(carId);
    s.status(carId);    
}


@Autowired
private StorageService service;

@PostMapping
public ResponseEntity<?> uploadImage(@RequestParam("image")MultipartFile file) throws IOException {
	String uploadImage = service.uploadImage(file);
	return ResponseEntity.status(HttpStatus.OK)
			.body(uploadImage);
}



 


}
