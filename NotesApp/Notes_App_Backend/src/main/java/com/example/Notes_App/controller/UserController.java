package com.example.Notes_App.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Notes_App.entity.User;
import com.example.Notes_App.servicesimpl.UserServiceImpl;

import com.example.Notes_App.servicesimpl.*;

@RestController
@CrossOrigin("*")
public class UserController {

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Autowired
	private UserServiceImpl userService;

	@Autowired
	private UserDetailsServiceImpl detailsServiceImpl;

	@PostMapping("/user/register")
	@CrossOrigin("*")
	public ResponseEntity<?> register(@RequestBody User user) {
	    try {
	        // Encode the password
	        user.setPassword(this.passwordEncoder.encode(user.getPassword()));

	        // Check if the user already exists
	        User existingUser = this.userService.getUserByEmail(user.getEmail());
	        if (existingUser != null) {
	            // User with the given email already exists
	            return ResponseEntity.status(HttpStatus.CONFLICT).body("User with this email already exists!");
	        }

	        // If the user doesn't exist, create a new user
	        User createdUser = this.userService.createUser(user);

	        // Return the created user object
	        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
	    } catch (Exception e) {
	        // Handle other exceptions, e.g., database errors
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Registration failed due to an internal error.");
	    }
	}

	@GetMapping("/current-user")
	public User getCurrentUser(Principal principal) {
		System.out.println(principal.getName());
		return ((User) this.detailsServiceImpl.loadUserByUsername(principal.getName()));
	}

}
