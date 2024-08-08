package com.rental.car.service;



import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.rental.car.entity.ImageData;
import com.rental.car.repo.StorageRepository;


@Service
public class StorageService {
	
	@Autowired
    private StorageRepository repository;
	
	

    public String uploadImage(MultipartFile file) throws IOException {

    	ImageData imageData = new ImageData();
    	imageData.setName(file.getOriginalFilename());
    	imageData.setType(file.getContentType());
    	imageData.setImageData(ImageUtils.compressImage(file.getBytes()));

    	// Save the imageData object to the repository
    	ImageData savedImageData = repository.save(imageData);

    	if (savedImageData != null) {
    	    return "file uploaded successfully: " + file.getOriginalFilename();
    	} else {
    	    return null; // or handle the case where saving failed
    	}
        
    }

//    public byte[] downloadImage(String fileName){
//        Optional<ImageData> dbImageData = repository.findByName(fileName);
//        byte[] images=ImageUtils.decompressImage(dbImageData.get().getImageData());
//        return images;
//    }

}
