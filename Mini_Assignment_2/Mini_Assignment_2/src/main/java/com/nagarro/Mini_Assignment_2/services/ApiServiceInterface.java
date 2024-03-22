package com.nagarro.Mini_Assignment_2.services;

import java.util.List;

import com.nagarro.Mini_Assignment_2.dtos.Results;

public interface ApiServiceInterface {

	public Results getUserDetails();

	public List<String> getCountries(String name);

	public String getGender(String name);

}
