package com.example.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import com.example.filters.ErrorFilter;
import com.example.filters.PostFilter;
import com.example.filters.PreFilter;
import com.example.filters.RouteFilter;

@EnableZuulProxy
@SpringBootApplication
public class EBookStoreProxyApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(EBookStoreProxyApiApplication.class, args);
	}

	@Bean
	public PreFilter getPreFilter() {
		return new PreFilter();
	}
	
	@Bean
	public PostFilter getPostFilter() {
		return new PostFilter();
	}
	
	@Bean
	public RouteFilter getRouteFilter() {
		return new RouteFilter();
	}
	
	@Bean
	public ErrorFilter getErrorFilter() {
		return new ErrorFilter();
	}
}
