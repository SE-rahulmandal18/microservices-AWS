package com.example.ebookstoreapp.repository;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ebookstoreapp.entity.Book;

@Repository(value="BookRepository")
@Scope(value="singleton")
public interface BookRepository extends JpaRepository<Book,Integer>
{
	List<Book> findByTitle(String title);
	List<Book> findByPublisherLike(String publisher);
	List<Book> findByYear(String year);


}
