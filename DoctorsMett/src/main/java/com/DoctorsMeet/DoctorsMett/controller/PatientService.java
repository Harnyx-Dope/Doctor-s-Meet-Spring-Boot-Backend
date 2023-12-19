package com.DoctorsMeet.DoctorsMett.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PatientService {

    @Autowired
    DoctorsLoginR repository; // Assuming DoctorLoginRepository extends MongoRepository<DoctorLogin, String>

    public boolean checkBookAlreadyExist(String id) {
        Optional<DoctorLogin> doctor = repository.findById(id);
        return doctor.isPresent();
        
    }
    public boolean checkBookAlreadyExistByLicense(String license) {
        // Use the findByLicense method provided by Spring Data MongoDB
        Optional<DoctorLogin> doctor = repository.findByLicense(license);
        
        // Return true if the doctor is present (already booked)
        return doctor.isPresent();
    }
	 
}
