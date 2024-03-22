package com.nagarro.Mini_Assignment_2.controller;

//UserController.java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.Mini_Assignment_2.dtos.PageInfo;
import com.nagarro.Mini_Assignment_2.dtos.UserCreationRequest;
import com.nagarro.Mini_Assignment_2.dtos.UserResponse;
import com.nagarro.Mini_Assignment_2.entities.User;
import com.nagarro.Mini_Assignment_2.serviceImpl.UserService;
import com.nagarro.Mini_Assignment_2.validators.ValidatorFactory;
import com.nagarro.Mini_Assignment_2.validators.Validator;

import jakarta.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserController {

	private final UserService userService;
	private final ValidatorFactory validatorFactory;

	@Autowired
	public UserController(UserService userService, ValidatorFactory validatorFactory) {
		this.userService = userService;
		this.validatorFactory = validatorFactory;
	}

	@PostMapping
	public ResponseEntity<?> createUsers(@RequestBody @Valid UserCreationRequest request) {
		int size = request.getSize();
		List<UserResponse> users = userService.createUser(size);
		return ResponseEntity.ok(users);
	}

	@GetMapping
	public ResponseEntity<Map<String, Object>> getUsers(@RequestParam String sortType, @RequestParam String sortOrder,
			@RequestParam String limit, @RequestParam String offset) {

		validateInput("SortType", sortType);
		validateInput("SortOrder", sortOrder);
		validateInput("Limit", String.valueOf(limit));
		validateInput("Offset", String.valueOf(offset));

		PageInfo pageInfo = new PageInfo();
		List<User> users = userService.getUsers(sortType, sortOrder, Integer.parseInt(limit), Integer.parseInt(offset),
				pageInfo);

		Map<String, Object> response = new HashMap<>();
		response.put("data", users);
		response.put("pageInfo", pageInfo);

		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	private void validateInput(String parameterName, String value) {
		Validator<String> validator = validatorFactory.getValidator(parameterName);
		validator.validate(value, parameterName);
	}
}
