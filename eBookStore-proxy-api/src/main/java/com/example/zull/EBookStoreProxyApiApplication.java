package com.example.zull;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy
@SpringBootApplication
public class EBookStoreProxyApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(EBookStoreProxyApiApplication.class, args);
	}

}
