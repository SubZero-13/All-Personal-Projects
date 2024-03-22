package com.nagarro.Mini_Assignment_2.dtos;

import lombok.Data;

@Data
public class Street {
	private int number;
	private String name;

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
