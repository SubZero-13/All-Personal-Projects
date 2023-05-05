package com.nagarro.initializer.entities;

public class Book {

	// define fields

	int id;

	String name;

	String date;

	Author author;
	// define constructors

	public Book() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public Book(String name, String date, Author author) {
		id = 0;
		this.name = name;
		this.date = date;
		this.author = author;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", date=" + date + ", author=" + author + "]";
	}

}
