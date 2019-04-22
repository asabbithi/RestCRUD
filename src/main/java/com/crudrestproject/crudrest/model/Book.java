package com.crudrestproject.crudrest.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.GeneratedValue;

@Entity
@Table(name="book")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Book {
	@Id
	@GeneratedValue
	private int Id;
	private String bookName;
	private String author;
	private double price;
	
	public Book() {
		
	}
	
	public Book(String bookName, String author, double price) {
		super();
		this.bookName = bookName;
		this.author = author;
		this.price = price;
	}
		public Integer getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
}
