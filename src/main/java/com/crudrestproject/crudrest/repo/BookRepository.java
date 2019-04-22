package com.crudrestproject.crudrest.repo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.crudrestproject.crudrest.model.Book;

@Repository
public class BookRepository {

	private static final Map<Integer,Book> bookmap = new HashMap<Integer,Book>();
	 
    static {
        initbooks();
    }
 
    private static void initbooks() {
        Book book1 = new Book("Alchemist", "ShakesPeare", 234.89);
        Book book2 = new Book("Twilight", "Gosling", 450.98);
        Book book3 = new Book("Harry Potter", "JK Rowling", 500.65);
 
        bookmap.put(book1.getId(),book1);
        bookmap.put(book2.getId(),book2);
        bookmap.put(book3.getId(),book3);
    }
 
    public Book getBook(int id) {
        return bookmap.get(id);
    }
 
    public Book addBook(Book book) {
        bookmap.put(book.getId(), book);
        return book;
    }
 
    public Book updateBook(Book book) {
        bookmap.put(book.getId(), book);
        return book;
    }
 
    public void deleteBook(int id) {
        bookmap.remove(id);
    }
 
    public List<Book> getAllBooks() {
        Collection<Book> c = bookmap.values();
        List<Book> list = new ArrayList<Book>();
        list.addAll(c);
        return list;
    }
 
	
	
}
