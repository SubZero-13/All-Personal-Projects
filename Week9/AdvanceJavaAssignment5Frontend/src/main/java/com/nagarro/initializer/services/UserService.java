package com.nagarro.initializer.services;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.nagarro.initializer.entities.User;

@Service
public class UserService {
	private RestTemplate restTemplate;
	private String url = "http://localhost:8085/";

	public UserService(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	public boolean checkUser(int id, String password) {

		User validUser = restTemplate.getForObject(url + "user/" + id, User.class);

		if (validUser != null && validUser.getPassword().equals(password)) {
			return true;
		} else {
			return false;
		}
	}

}
