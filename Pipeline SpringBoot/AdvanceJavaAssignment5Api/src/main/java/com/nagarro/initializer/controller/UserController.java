package com.nagarro.initializer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.initializer.entities.User;
import com.nagarro.initializer.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/user")
	public User addUser(@RequestBody User user) {
		userService.save(user);
		return user;
	}

	@GetMapping("/user")
	public List<User> findAll() {
		return (List<User>) userService.findAll();
	}

	@GetMapping("/user/{id}")
	public User getUser(@PathVariable int id) {

		User user = userService.findById(id).orElse(null);

		/*
		 * if (user == null) { throw new RuntimeException("User name not found - " +
		 * username); }
		 */
		return user;
	}

	@PutMapping("/updateUser/{userId}/{password}")
	public User updateUser(@RequestBody User user, @PathVariable int userId, @PathVariable String password) {
		user.setUserId(userId);
		user.setPassword(password);
		userService.save(user);
		return user;
	}

	@DeleteMapping("/deleteUser/{userId}")
	public void deleteUser(@PathVariable int userId) {
		userService.deleteById(userId);
	}

}
