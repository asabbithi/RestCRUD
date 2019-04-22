package com.crudrestproject.crudrest.controller;
import static org.mockito.Mockito.*;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.bind.annotation.PathVariable;

import com.crudrestproject.crudrest.model.Book;
import com.crudrestproject.crudrest.repo.BookService;

@RunWith(SpringRunner.class)
@WebMvcTest(BookController.class)

public class BookControllerTest {
	
	@MockBean
	BookService bookService;
	
	BookController bookController;
	
	private static final String URL="Http://localhost:8080/book/";
	
	 
	  @Autowired
	  private MockMvc mockMvc;

	@Before
	public void init() {
		bookController = new BookController();
	}

	@Test
	public void testGetBooks() {
		Book book = new Book("Harry_Potter","xxx",123);
		List<Book> booksList = new ArrayList<Book>();
		booksList.add(book);
		booksList.add(book);
		Mockito.when(bookService.getAllBooks()).thenReturn(booksList);
		bookController.getBooks();
	
	}
	
	public ResponseEntity<Book> getBook(@PathVariable("id") int id) {
		  Book book1 = bookService.getBookById(id);
		  if (book1 == null) {
		  System.out.println("No Book found with Id " + id);
		  return new ResponseEntity<Book>(HttpStatus.NOT_FOUND);
		  }
		  System.out.println("Book details: " + book1);
		  return new ResponseEntity<Book>(book1, HttpStatus.OK);
		}
	
	@Test
	 public void testGetBook() throws Exception {
	 
	  Book bk = new Book("Kite Runner", "Hussain",132.43);
	  when(bookService.getBookById(any(Integer.class))).thenReturn(bk);
	  MvcResult result = (MvcResult) mockMvc.perform(MockMvcRequestBuilders.get(URL + "{id}",new Integer(1)));
	  
	  assertEquals("Incorrect Response Status", HttpStatus.OK.value());
	  verify(bookService).getBookById(any(Integer.class));
	 
	  JSONAssert.assertEquals("{name:Kite Runner,author:Hussain,price:132.43,id:1}", result.getResponse().getContentAsString(), false);
	}
	
	 public void testGetEmployeeNotExist() throws Exception {
		  MvcResult result = (MvcResult) mockMvc.perform(MockMvcRequestBuilders.get(URL + "{id}",new Integer(1)));
		  int status = result.getResponse().getStatus();
		  assertEquals("Incorrect Response Status",HttpStatus.NOT_FOUND.value(), status);
		  verify(bookService).getBookById(any(Integer.class));
		  JSONAssert.assertEquals(null, result.getResponse().getContentAsString(), false);
		}
	 
	 @Test
	 public void testAddBook() throws Exception {
	  Book bookadd = new Book("Shopoholic", "developer", 120.00);
	  when(bookService.addBook(any(Book.class))).thenReturn(bookadd);
	  MvcResult result = (MvcResult) mockMvc.perform(MockMvcRequestBuilders.post(URL));
	  int status = result.getResponse().getStatus();
	  assertEquals("Incorrect Response Status", HttpStatus.CREATED.value(), status);
	  verify(bookService).addBook(any(Book.class));

	  JSONAssert.assertEquals("{name:Shopoholic,author:developer,price:120.00,id:1}", result.getResponse().getContentAsString(), false);
	}
	 
	 @Test
	  public void testUpdateEmployee() throws Exception {
	   Book bookupdate = new Book();
	   when(bookService.getBookById(any(Integer.class))).thenReturn(bookupdate);
	   MvcResult result = mockMvc.perform(MockMvcRequestBuilders.put(URL)).andReturn();
	   int status = result.getResponse().getStatus();
	   assertEquals("Incorrect Response Status", HttpStatus.OK.value(), status);
	   verify(bookService).updateBook(any(Book.class));
	  
	 }
	 
	 @Test
	 public void testDeleteBook() throws Exception {
	 	Book bk = new Book();
	 	when(bookService.getBookById(any(Integer.class))).thenReturn(bk);
	 	MvcResult result = mockMvc.perform(MockMvcRequestBuilders.delete(URL + "{id}", new Integer(1)))
	 							  .andReturn();
	 	int status = result.getResponse().getStatus();
	 	assertEquals("Incorrect Response Status", HttpStatus.GONE.value(), status);
	 	verify(bookService).deleteBook(any(Integer.class));

	 }
}
