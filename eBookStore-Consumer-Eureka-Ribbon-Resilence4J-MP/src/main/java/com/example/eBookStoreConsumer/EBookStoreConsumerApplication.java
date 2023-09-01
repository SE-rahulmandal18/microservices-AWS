package com.example.eBookStoreConsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.micrometer.core.aop.TimedAspect;
import io.micrometer.core.instrument.MeterRegistry;


@SpringBootApplication
public class EBookStoreConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EBookStoreConsumerApplication.class, args);
	}

	@Bean
	public TimedAspect timeAspect(MeterRegistry registry) {
		
		return new TimedAspect(registry);
	}
}
