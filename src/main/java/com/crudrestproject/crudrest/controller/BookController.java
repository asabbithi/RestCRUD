package com.crudrestproject.crudrest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.crudrestproject.crudrest.model.Book;
import com.crudrestproject.crudrest.repo.BookService;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

@JsonAutoDetect(fieldVisibility=Visibility.ANY)

@RestController
public class BookController {

	@Autowired
	    private BookService bookService;
	 
	 @RequestMapping(value="/book",method=RequestMethod.GET)
	    @ResponseBody
	    public List<Book> getBooks() 
	     {
	        List<Book> list = bookService.getAllBooks();
	        return list;
	    }
	 
	  @RequestMapping(value="/book/{id}", method=RequestMethod.GET)
	    @ResponseBody
	    public Book getBook(@PathVariable("id") int id) 
	    {
	        return bookService.getBookById(id);
	    }
	 	 
	    @RequestMapping(value="/book", method=RequestMethod.POST)
	    @ResponseBody
	    public Book addEmployee(@RequestBody Book book) 
	    {
	 
	        return bookService.addBook(book);
	    }
	 

	    @RequestMapping(value="/book",method=RequestMethod.PUT)
	    @ResponseBody
	    public Book updateBook(@RequestBody Book book) 
	    {
	 	        return bookService.updateBook(book);
	    }
	 

	    @RequestMapping(value="/book/{id}",method=RequestMethod.DELETE)
	    @ResponseBody
	    public void deleteBook(@PathVariable("id") int id) 
	    {
	
	    	bookService.deleteBook(id);
	    }


}
