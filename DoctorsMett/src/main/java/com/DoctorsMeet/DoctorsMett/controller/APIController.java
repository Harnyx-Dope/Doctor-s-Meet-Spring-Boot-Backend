package com.DoctorsMeet.DoctorsMett.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping
public class APIController {

    private static final Logger logf = LoggerFactory.getLogger(APIController.class);

    @Autowired
    DoctorsLoginR repository;
    @Autowired
    PatientService lib;

    @PostMapping("/register")
    public LoginResponse addBookImplementation(@RequestBody DoctorLogin doctorLogin) {
        LoginResponse response = new LoginResponse();

        if (!lib.checkBookAlreadyExist(doctorLogin.getLicense())) {
            logf.info("Adding a new Doctor");
            doctorLogin.setName(doctorLogin.getFirstName() + " " + doctorLogin.getLastName());
            doctorLogin.setEmail(doctorLogin.getEmail());
            doctorLogin.setPassword(doctorLogin.getPassword());
            doctorLogin.setCollegeName(doctorLogin.getCollegeName());
            doctorLogin.setLicense(doctorLogin.getLicense());
           
            repository.save(doctorLogin);

            HttpHeaders headers = new HttpHeaders();
            headers.add("Unique", doctorLogin.getFirstName() + doctorLogin.getLastName());

            response.setMsg("Doctor info Is added");
            response.setName(doctorLogin.getFirstName() + doctorLogin.getLastName());

            return response;
        } else {
            logf.info("Doctor already exists, skipping this one");

            response.setMsg("Doctor Already present");
            response.setName("False");
            return response;
        }
    }

    @PostMapping("/updateBook")
    public String updateBook(@RequestBody DoctorLogin doctorLogin) {
        if (!lib.checkBookAlreadyExist(doctorLogin.getLicense())) {
            DoctorLogin existingDoctor = repository.findById(doctorLogin.getLicense()).orElse(null);

            if (existingDoctor != null) {
                existingDoctor.setPassword(doctorLogin.getPassword());
                repository.save(existingDoctor);
                return "Done";
            } else {
                return "Doctor not found";
            }
        } else {
            return "Doctor does not exist";
        }
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("/updateBook1")
    public Boolean updateBook1(@RequestBody DoctorLogin doctorLogin) {
        System.out.println(doctorLogin.getPassword() + " " + doctorLogin.getEmail());
        return doctorLogin.getPassword().equals(doctorLogin.getEmail());
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/ispresent")
    public String isPresent(@RequestParam(value = "id") String license) {
        if (!lib.checkBookAlreadyExist(license)) {
        	System.out.print("heelo");
             
            DoctorLogin existingDoctor = repository.findByLicense(license).orElse(null);
            return existingDoctor != null ? existingDoctor.getName() : "Doctor not found";
        } else {
            return "false";
        }
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("/ispresent1")
    public Boolean isPresent1(@RequestBody DoctorLogin doctorLogin) {
    	System.out.print(doctorLogin.getLicense());
    	 
        if (lib.checkBookAlreadyExistByLicense(doctorLogin.getLicense())) {
        	
            DoctorLogin existingDoctor = repository.findByLicense(doctorLogin.getLicense()).orElse(null);
            System.out.print(existingDoctor);
            System.out.print(existingDoctor != null &&
                    existingDoctor.getPassword().equals(doctorLogin.getPassword()) &&
                    existingDoctor.getEmail().equals(doctorLogin.getEmail()));
            return existingDoctor != null &&
                    existingDoctor.getPassword().equals(doctorLogin.getPassword()) &&
                    existingDoctor.getEmail().equals(doctorLogin.getEmail());
        } else {
        	
            return false;
        }
    }

    @GetMapping("/greeting")
    public String greeting() {
        return "Harsh Vardhan Gupta";
    }
}
