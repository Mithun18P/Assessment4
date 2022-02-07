package com.thoughtfocus.RegistrationDetails;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
public class RegistrationDetailsApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(RegistrationDetailsApplication.class, args);
		System.out.println("started....");	
	}

}
