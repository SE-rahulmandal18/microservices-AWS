package com.example.eBookStoreConsumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.eBookStoreConsumer.entity.Book;
import com.example.eBookStoreConsumer.service.BookService;

import io.micrometer.core.annotation.Timed;

@RestController
@Scope("request")
public class BookClientController {

	@Autowired
	private BookService bookService;
	

	@Timed(value = "getBookById.time", description = "Taken time to return book")
	@GetMapping("/get-books/{id}")
	public Book getBookById(@PathVariable("id")int id)
	{
		return bookService.getBookById(id);
	}
}
