package com.example.eBookStoreConsumer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.eBookStoreConsumer.entity.Book;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class BookService {

	@Autowired
	private RestTemplate restTemplate;
	
	@HystrixCommand(fallbackMethod="fallBackMethodForGetBookById")
	public Book getBookById(int id)
	{
		Book book = restTemplate.getForObject("http://book-service/books/"+id,Book.class);
		return book;
	}
	
	public Book fallBackMethodForGetBookById(int id)
	{
		return new Book(id,"titlefallback","fallbackpublisher","123455","200","2021");
	}
}
