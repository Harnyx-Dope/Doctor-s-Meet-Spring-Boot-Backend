package com.DoctorsMeet.DoctorsMett;

 

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.web.bind.annotation.CrossOrigin;


 

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@CrossOrigin(origins = "*", allowedHeaders = "*")
@EnableMongoRepositories(basePackages = "com.DoctorsMeet.DoctorsMett.controller")
public class DoctorsMettApplication {
	@Bean
	public MongoTemplate mongoTemplate(MongoDatabaseFactory mongoDbFactory) {
	    return new MongoTemplate(mongoDbFactory);
	}
	public static void main(String[] args)  {


				 
		SpringApplication.run(DoctorsMettApplication.class, args);
	}

}
