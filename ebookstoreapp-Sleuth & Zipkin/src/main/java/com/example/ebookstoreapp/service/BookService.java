package com.example.ebookstoreapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.example.ebookstoreapp.entity.Book;
import com.example.ebookstoreapp.repository.BookRepository;

@Service(value="BookService")
@Scope(value="singleton")
public class BookService implements IBookService{
	
	@Autowired
	@Qualifier(value="BookRepository")
	private BookRepository bookRepository;

	@Override
	public Book addBook(Book book) {
		
		return bookRepository.save(book);
	}

	@Override
	public Book updateBook(Book book) {
		return bookRepository.save(book);
	}

	@Override
	public List<Book> getAllBooks() {
		
		return bookRepository.findAll();
	}

	@Override
	public Book getBookById(Integer id) {
		
		return bookRepository.findById(id).get();
	}

	@Override
	public void deleteBookById(Integer id) {
		bookRepository.deleteById(id);
		
	}

	@Override
	public List<Book> findByTitle(String title) {
		
		return bookRepository.findByTitle(title);
	}

	@Override
	public List<Book> findByPublisherLike(String publisher) {
		
		return bookRepository.findByPublisherLike(publisher);
	}

	@Override
	public List<Book> findByYear(String year) {
		
		return bookRepository.findByYear(year);
	}

	
	

}
