package com.nagarro.initializer.entities;

public class Author {

	private int id;

	private String name;

	public Author() {
	}

	public Author(String name) {
		this.name = name;
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

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return name;
	}

}
