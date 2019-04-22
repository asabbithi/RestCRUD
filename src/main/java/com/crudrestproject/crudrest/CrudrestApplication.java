package com.crudrestproject.crudrest;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.crudrestproject.crudrest.model.Book;
import com.crudrestproject.crudrest.repo.BookRepo;

@SpringBootApplication
public class CrudrestApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudrestApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner setup(BookRepo bookRepo) 
	{
		return (args) -> {
			bookRepo.save(new Book("Harry Potter","JK Rowling",153.62));
			bookRepo.save(new Book("Twilight","Rosling",275));
		};
	}
	
}
