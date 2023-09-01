package com.example.eBookStoreConsumerFeign.proxy;

import java.util.ArrayList;
import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.eBookStoreConsumerFeign.entity.Book;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;

@FeignClient(name="book-service")
public interface BookServiceProxy {

    @Retry(name="book-service")
	@CircuitBreaker(name = "book-service", fallbackMethod = "fallbackMethodgetBookById")
	@GetMapping("/books/{id}")
	public Book getBookById(@PathVariable("id")int id);
	
    @Retry(name="book-service")
	@CircuitBreaker(name = "book-service", fallbackMethod = "fallbackMethodgetAllBooks")
	@GetMapping("/books")
	public List<Book> getAllBooks() ;
	

	
	public default List<Book> fallbackMethodgetAllBooks(Throwable cause) {
		System.out.println("Exception Raised with the message:===>" + cause.getMessage());
		return new ArrayList<Book>();
	}

	
	public default Book fallbackMethodgetBookById(int id ,Throwable cause) {
		
		System.out.println("Exception Raised with the message:===>" + cause.getMessage());
		return new Book(id,"titlefallback","fallbackpublisher","123455","200","2021");
	}


}
