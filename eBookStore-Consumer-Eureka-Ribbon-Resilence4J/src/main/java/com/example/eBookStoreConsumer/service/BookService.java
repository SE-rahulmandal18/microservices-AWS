package com.example.eBookStoreConsumer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.eBookStoreConsumer.entity.Book;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;

@Service
public class BookService {

	@Autowired
	private RestTemplate restTemplate;
	
	@Retry(name="book-service")
	@CircuitBreaker(name = "book-service", fallbackMethod="fallBackMethodForGetBookById")
	public Book getBookById(int id)
	{
		Book book = restTemplate.getForObject("http://book-service/books/" + id, Book.class);
		return book;
	}
	
	public Book fallBackMethodForGetBookById(int id, Throwable cause)
	{

		System.out.println("Exception Raised with the message:===>" + cause.getMessage());
		return new Book(id,"titlefallback","fallbackpublisher","123455","200","2021");
	}
}
