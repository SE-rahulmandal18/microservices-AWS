package com.example.eBookStoreConsumerFeign.proxy;

import java.util.List;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.eBookStoreConsumerFeign.entity.Book;
import com.example.eBookStoreConsumerFeign.fallback.BookServiceFallback;

@FeignClient(name="book-service",fallback=BookServiceFallback.class)
public interface BookServiceProxy {
	
	@GetMapping("/books")
	public List<Book> getAllBooks() ;

	// Get a book by its ID
	@GetMapping("/books/{id}")
	public Book getBookById(@PathVariable("id")int id);

}
