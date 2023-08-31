package com.example.eBookStoreConsumerFeign.proxy;

import java.util.ArrayList;
import java.util.List;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.eBookStoreConsumerFeign.entity.Book;

@FeignClient(name="book-service")
public interface BookServiceProxy {
	
	@GetMapping("/books")
	public List<Book> getAllBooks() ;

	// Get a book by its ID
	@GetMapping("/books/{id}")
	public Book getBookById(@PathVariable("id")int id);
	
	
	public default List<Book> fallbackMethodgetAllBooks(Throwable cause) {
		System.out.println("Exception Raised with the message:===>" + cause.getMessage());
		return new ArrayList<Book>();
	}

	
	public default Book fallbackMethodgetBookById(int id ,Throwable cause) {
		
		System.out.println("Exception Raised with the message:===>" + cause.getMessage());
		return new Book(id,"titlefallback","fallbackpublisher","123455","200","2021");
	}


}
