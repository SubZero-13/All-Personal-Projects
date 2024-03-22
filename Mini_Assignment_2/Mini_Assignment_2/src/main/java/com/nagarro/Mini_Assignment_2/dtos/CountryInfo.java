package com.nagarro.Mini_Assignment_2.dtos;

import java.util.List;

public class CountryInfo {

	private int count;
	private String name;
	private List<Country> country;

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Country> getCountry() {
		return country;
	}

	public void setCountry(List<Country> country) {
		this.country = country;
	}

}
