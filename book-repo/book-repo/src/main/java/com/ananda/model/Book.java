package com.ananda.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name="book")

public class Book {
	
	@Id
	@GeneratedValue
	private Long bookId;
	
	@Size(min = 2, message = " name should have atleast two characters")
	private String name;
	
	@Size(min = 3, message = " name should have atleast three characters")
	private String author;
	
	public Long getBookId() {
		return bookId;
	}
	public void setBookId(Long bookId) {
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
	

}
