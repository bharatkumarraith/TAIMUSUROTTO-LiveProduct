package com.example.userapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class UserapplicationApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserapplicationApplication.class, args);
	}

}
