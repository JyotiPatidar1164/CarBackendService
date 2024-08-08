package com.rental.car.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.rental.car.entity.Car;

public interface CarRepository extends JpaRepository<Car,Integer>{

	
    

//	@Modifying
//	@Query(nativeQuery = true, value = "UPDATE Car SET isAvailable = 'false' WHERE carId = :carId")
//	void updateAvailabilityByCarId(int carId);

	@Modifying
	@Query(nativeQuery = true, value = "UPDATE Car SET is_available = 1 WHERE car_id = :carId")
	void statue(int carId);



@Modifying
@Query(nativeQuery = true, value = "UPDATE Car SET is_available = 0 WHERE car_id = :carId")
	void updateAvailability(int carId);


//@Modifying
//@Query(nativeQuery = true, value = "select basePricePerDay from Car where car_id = :carId")
//int price(int carId);

@Query("select c.basePricePerDay from Car c where c.carId = :carId")
Integer price(@Param("carId") int carId);




    
  

}
