package com.DoctorsMeet.DoctorsMett.controller;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Doctors")
public class DoctorLogin {

    @Id
    private String id; // MongoDB will automatically generate an ID
    private String license;
    private String name;
    private String email;
    private String password;
    private String collegeName;
    private String firstName;
    private String lastName;

    // Constructors, getters, and setters

    // Default constructor
    public DoctorLogin() {
    }

    // Parameterized constructor
    public DoctorLogin(String license, String name, String email, String password, String collegeName, String firstName, String lastName) {
        this.license = license;
        this.name = name;
        this.email = email;
        this.password = password;
        this.collegeName = collegeName;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    // Getters and setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
