package com.example.Notes_App.services;

import java.util.List;

import com.example.Notes_App.entity.User;

public interface UserService {

	public User createUser(User user) throws Exception;

	public User save(User user);

	public User showUser(String email);

	public List<User> findAll();

}
