package com.example.eBookStoreEurekaServer;

import org.springframework.boot.SpringApplication;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class EBookStoreEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EBookStoreEurekaServerApplication.class, args);
	}

}
