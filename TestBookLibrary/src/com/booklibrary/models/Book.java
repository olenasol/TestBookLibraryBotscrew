package com.booklibrary.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Book {
	@Id@GeneratedValue
	private int bookId;
	private String name;
	private String author;
	
	public Book() {}
	public Book(String name,String author) {
		this.name=name;
		this.author=author;
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String toString() {
		return "\""+this.name+"\""+" "+this.author;
	}
	
}
