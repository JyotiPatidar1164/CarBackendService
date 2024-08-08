package com.rental.car.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rental.car.entity.ImageData;

public interface StorageRepository extends JpaRepository<ImageData,Long>{
	Optional<ImageData> findByName(String fileName);

}
