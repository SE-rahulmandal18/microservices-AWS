package com.example.eBookStoreConsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.ComponentScan;

@EnableCircuitBreaker
@EnableHystrixDashboard
@SpringBootApplication
public class EBookStoreConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EBookStoreConsumerApplication.class, args);
	}

}
