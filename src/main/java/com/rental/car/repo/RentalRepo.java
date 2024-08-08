package com.rental.car.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rental.car.entity.Rental;


public interface RentalRepo extends JpaRepository<Rental,Integer>{

}
