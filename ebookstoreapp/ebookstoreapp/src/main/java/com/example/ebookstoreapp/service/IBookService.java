package com.example.ebookstoreapp.service;

import java.util.List;

import com.example.ebookstoreapp.entity.Book;

public interface IBookService {
	
	public Book addBook(Book book);
	public Book updateBook(Book book);
	public List<Book> getAllBooks();
	public Book getBookById(Integer id);
	public void deleteBookById(Integer id);
	public List<Book> findByTitle(String title);
	public List<Book> findByPublisherLike(String publisher);
	public List<Book> findByYear(String year);

}
