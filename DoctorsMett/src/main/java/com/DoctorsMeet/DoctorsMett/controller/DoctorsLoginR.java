package com.DoctorsMeet.DoctorsMett.controller;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorsLoginR extends MongoRepository<DoctorLogin, String> {
	 Optional<DoctorLogin> findByLicense(String license);

	 
}
