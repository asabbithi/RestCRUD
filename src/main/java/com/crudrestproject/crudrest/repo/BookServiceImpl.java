package com.crudrestproject.crudrest.repo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crudrestproject.crudrest.model.Book;

@Service("bookService")
public class BookServiceImpl implements BookService {
	
	@Autowired
	BookRepo bookRepo;

	@Override
	public Book getBookById(int id) {
		
		return bookRepo.getOne(id);
	}

	@Override
	public List<Book> getAllBooks() {
		
		return bookRepo.findAll();
	}

	@Override
	public Book addBook(Book book) {
		return bookRepo.save(book);
	}

	@Override
	public Book updateBook(Book book) {
		return null;
	}

	@Override
	public void deleteBook(int id) {
	     bookRepo.deleteById(id);
		
	}
	

}

