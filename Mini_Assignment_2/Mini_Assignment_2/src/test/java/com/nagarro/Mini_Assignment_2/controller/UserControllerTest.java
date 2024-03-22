package com.nagarro.Mini_Assignment_2.controller;

import com.nagarro.Mini_Assignment_2.constant.UserQueryConstants;
import com.nagarro.Mini_Assignment_2.controller.UserController;
import com.nagarro.Mini_Assignment_2.dtos.UserCreationRequest;
import com.nagarro.Mini_Assignment_2.dtos.UserResponse;
import com.nagarro.Mini_Assignment_2.serviceImpl.UserService;
import com.nagarro.Mini_Assignment_2.entities.User;
import com.nagarro.Mini_Assignment_2.validators.EnglishAlphabetsValidator;
import com.nagarro.Mini_Assignment_2.validators.NumericValidator;
import com.nagarro.Mini_Assignment_2.validators.ValidatorFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class UserControllerTest {

	@Mock
	private UserService userService;

	@Mock
	private ValidatorFactory validatorFactory;

	@Mock
	private EnglishAlphabetsValidator englishAlphabetsValidator;

	@Mock
	private NumericValidator numericValidator;

	@Mock
	UserCreationRequest request;

	@InjectMocks
	private UserController userController;

	@Test
	@DisplayName("createUser Test")
	public void testCreateUsers() {

		when(request.getSize()).thenReturn(3);

		when(userService.createUser(3)).thenReturn(createMockUserResponses(3));

		// Act
		ResponseEntity<?> responseEntity = userController.createUsers(request);

		// Assert
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());

	}

	private UserResponse createMockUserResponse() {
		// Create and return a mock UserResponse for testing
		return new UserResponse("Aniket Keshri", "13 September 2000", "Male", 23, "IN", "VERIFIED");
	}

	private List<UserResponse> createMockUserResponses(int count) {
		return IntStream.range(0, count).mapToObj(i -> createMockUserResponse()).collect(Collectors.toList());

	}

	@Test
	@DisplayName("getUser Test")
	void testGetUsers() {
		when(validatorFactory.getValidator(anyString())).thenReturn(englishAlphabetsValidator);
		when(validatorFactory.getValidator(eq(UserQueryConstants.LIMIT))).thenReturn(numericValidator);
		when(validatorFactory.getValidator(eq(UserQueryConstants.OFFSET))).thenReturn(numericValidator);
		
		// Mock data
		List<User> mockUsers = Arrays.asList(
				new User(1L, "Kazimira Shabliy", 67, "female", "15 March 1956", "UA", "VERIFIED",
						"Sat, 02 Dec 2023 14:37:14", "Sat, 02 Dec 2023 14:37:14"),
				new User(2L, "Rosa Oliver", 41, "female", "04 September 1982", "US", "TO_BE_VERIFIED",
						"Sat, 02 Dec 2023 15:06:34", "Sat, 02 Dec 2023 15:06:34"));

		// Mock service method
		when(userService.getUsers(anyString(), anyString(), anyInt(), anyInt(), any())).thenReturn(mockUsers);

		// Call the controller method
		ResponseEntity<?> responseEntity = userController.getUsers("Age", "Odd", "2", "0");

		// Assert the response
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());

		@SuppressWarnings("unchecked")
		Map<String, Object> responseBody = (Map<String, Object>) responseEntity.getBody();
		assertNotNull(responseBody);

		@SuppressWarnings("unchecked")
		List<User> responseUsers = (List<User>) responseBody.get("data");
		assertNotNull(responseUsers);
		assertEquals(2, responseUsers.size());
		assertEquals(mockUsers, responseUsers);
	}
}