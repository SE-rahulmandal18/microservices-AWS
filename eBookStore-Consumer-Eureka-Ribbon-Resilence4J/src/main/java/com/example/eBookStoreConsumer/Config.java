package com.example.eBookStoreConsumer;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class Config {

	@Bean
	@LoadBalanced //lookup in the registry
	public RestTemplate getRestTemplate()
	{
		return new RestTemplate();
		
	}
}
