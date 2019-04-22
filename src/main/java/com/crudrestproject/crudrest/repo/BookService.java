package com.crudrestproject.crudrest.repo;

import java.util.List;

import com.crudrestproject.crudrest.model.Book;

public interface BookService {

	public Book getBookById(int id);
	List<Book> getAllBooks();
	public Book addBook(Book book);
	public Book updateBook(Book book);
	public void deleteBook(int id);
}
