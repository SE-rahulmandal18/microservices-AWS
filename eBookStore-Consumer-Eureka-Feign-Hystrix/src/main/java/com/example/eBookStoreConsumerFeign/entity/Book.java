package com.example.eBookStoreConsumerFeign.entity;




//@Data
//@NoArgsConstructor
//@AllArgsConstructor                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    
public class Book {
    
	
	private int id;
	private String bookTitle;
	private String bookPublisher;
	private String bookIsbn;
	private int bookNumberOfPages;
	private int bookYear;
	public Book(int id, String bookTitle, String bookPublisher, String bookIsbn, int bookNumberOfPages, int bookYear) {
		super();
		this.id = id;
		this.bookTitle = bookTitle;
		this.bookPublisher = bookPublisher;
		this.bookIsbn = bookIsbn;
		this.bookNumberOfPages = bookNumberOfPages;
		this.bookYear = bookYear;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBookTitle() {
		return bookTitle;
	}
	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}
	public String getBookPublisher() {
		return bookPublisher;
	}
	public void setBookPublisher(String bookPublisher) {
		this.bookPublisher = bookPublisher;
	}
	public String getBookIsbn() {
		return bookIsbn;
	}
	public void setBookIsbn(String bookIsbn) {
		this.bookIsbn = bookIsbn;
	}
	public int getBookNumberOfPages() {
		return bookNumberOfPages;
	}
	public void setBookNumberOfPages(int bookNumberOfPages) {
		this.bookNumberOfPages = bookNumberOfPages;
	}
	public int getBookYear() {
		return bookYear;
	}
	public void setBookYear(int bookYear) {
		this.bookYear = bookYear;
	}
	public Book() {
		super();
	}
	
}
