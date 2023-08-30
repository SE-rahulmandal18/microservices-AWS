package com.example.eBookStoreConsumerFeign.fallback;

import java.util.List;
import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.example.eBookStoreConsumerFeign.entity.Book;
import com.example.eBookStoreConsumerFeign.proxy.BookServiceProxy;

@Component
public class BookServiceFallback implements BookServiceProxy{

	@Override
	public List<Book> getAllBooks() {
		
		return new ArrayList<Book>();
	}

	
	@Override
	public Book getBookById(int id) {
		
		return new Book(id,"titlefallback","fallbackpublisher","123455","200","2021");
	}

}
