package com.example.eBookStoreConsumer.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.eBookStoreConsumer.entity.Book;
import com.example.eBookStoreConsumer.service.BookService;

@RestController
@Scope("request")
public class BookClientController {

	@Autowired
	private BookService bookService;
	
	private Logger log = LoggerFactory.getLogger(BookClientController.class);
	
	@GetMapping("/get-books/{id}")
	public Book getBookById(@PathVariable("id")int id)
	{
		log.debug("In getBookById with Id:" + id);
		Book book =  bookService.getBookById(id);
		log.debug("In getBookById with return value Book:" + book);
		return book;
	}
}
