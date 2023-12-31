package com.example.ebookstoreapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import com.example.ebookstoreapp.entity.Book;
import com.example.ebookstoreapp.repository.BookRepository;

import brave.sampler.Sampler;

@EnableDiscoveryClient
@SpringBootApplication
public class EbookstoreappApplication implements CommandLineRunner{

	@Autowired
	@Qualifier(value="BookRepository")
	private BookRepository bookRepository;
	public static void main(String[] args) {
		SpringApplication.run(EbookstoreappApplication.class, args);
	}

	@Bean 
	public Sampler getSampler() {
		
		//return Sampler.create(0.5f);
		return Sampler.ALWAYS_SAMPLE; 
	}
	@Override
	public void run(String... args) throws Exception {
	        	
//		bookRepository.save((null '.NET IL Assembler', 'PublisherE', '978-1-4302-6761-4', "492", "2014"),
				bookRepository.save(new Book(null, ".NET Standard 2.0 Cookbook", "PublisherF", "978-1-78883-466-7", "394", "2018"));
			    bookRepository.save(new Book(null, ".NET Test Automation Recipes", "PublisherG", "978-1-59059-663-0", "408", "2006"));
			    bookRepository.save(new Book(null, "10 LED Projects for Geeks", "PublisherH", "978-1-59327-825-0", "240", "2018"));
			    bookRepository.save(new Book(null, "101 Design Ingredients to Solve Big Tech Problems", "PublisherI", "978-1-93778-532-1", "298", "2013"));
			    bookRepository.save(new Book(null, "101 Excel 2013 Tips, Tricks and Timesavers", "PublisherJ", "978-1-118-64218-4", "312", "2013"));
				
			    System.out.println(bookRepository.findAll());
	}

}
