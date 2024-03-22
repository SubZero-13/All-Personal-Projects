package com.example.Notes_App.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Notes_App.configure.JwtUtils;
import com.example.Notes_App.entity.JwtRequest;
import com.example.Notes_App.entity.JwtResponse;
import com.example.Notes_App.servicesimpl.UserDetailsServiceImpl;

@RestController
@CrossOrigin("*")
public class AuthenticateController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UserDetailsServiceImpl detailsServiceImpl;

	@Autowired
	private JwtUtils jwtUtils;

	@PostMapping("/generate-token")
	@CrossOrigin("*")
	public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtRequest) {
        try {
            // Try to authenticate the user
            authenticate(jwtRequest.getUserName(), jwtRequest.getPassword());

            // If authentication is successful, load user details
            UserDetails userDetails = detailsServiceImpl.loadUserByUsername(jwtRequest.getUserName());

            // Generate a JWT token for the user
            String token = jwtUtils.generateToken(userDetails);

            // Return the JWT token in the response
            return ResponseEntity.ok(new JwtResponse(token));
        } catch (BadCredentialsException e) {
            // Handle bad credentials (incorrect username or password)
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Bad credentials: Username or password is incorrect.");
        } catch (UsernameNotFoundException e) {
            // Handle user not found
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("User not found.");
        } catch (Exception e) {
            // Handle other exceptions, e.g., internal server error
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error generating token.");
        }
    }

    private void authenticate(String username, String password) {
        // Use the authentication manager to authenticate the user
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
    }
    

}
