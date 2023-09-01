package com.example.eBookStoreConsumer.entity;

public class Book {
	

	private Integer id;
	private String title;
	private String publisher;	
	private String isbn;
	private String pages;
	private String year;
	
	public Book(Integer id, String title, String publisher, String isbn, String pages, String year) {
		super();
		this.id = id;
		this.title = title;
		this.publisher = publisher;
		this.isbn = isbn;
		this.pages = pages;
		this.year = year;
	}
	
	public Book() {
		super();
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getPages() {
		return pages;
	}
	public void setPages(String pages) {
		this.pages = pages;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", publisher=" + publisher + ", isbn=" + isbn + ", pages="
				+ pages + ", year=" + year + "]";
	}

}
