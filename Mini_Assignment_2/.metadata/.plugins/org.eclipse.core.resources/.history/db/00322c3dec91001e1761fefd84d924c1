package com.nagarro.Mini_Assignment_2.serviceImpl;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.Mini_Assignment_2.dtos.PageInfo;
import com.nagarro.Mini_Assignment_2.dtos.Results;
import com.nagarro.Mini_Assignment_2.dtos.UserInfo;
import com.nagarro.Mini_Assignment_2.dtos.UserResponse;
import com.nagarro.Mini_Assignment_2.entities.User;
import com.nagarro.Mini_Assignment_2.enums.VerificationResult;
import com.nagarro.Mini_Assignment_2.exception.CustomException;
import com.nagarro.Mini_Assignment_2.repos.UserRepository;

@Service
public class UserService {

	private final ApiService apiService;
	private final VerificationService verificationService;
	private final UserRepository repo;

	@Autowired
	public UserService(ApiService apiService, VerificationService verificationService, UserRepository repo) {
		this.apiService = apiService;
		this.verificationService = verificationService;
		this.repo = repo;
	}

	public List<UserResponse> createUser(int size) {
		List<UserResponse> users;
		try {
			users = IntStream.range(0, size).mapToObj(i -> {
				try {
					Results results = apiService.getUserDetails();
					UserInfo userDetails = results.getResults().get(0);

					VerificationResult verificationResult = verificationService.verifyUser(userDetails);

					User user = new User();
					String fullName = userDetails.getName().getFirst() + " " + userDetails.getName().getLast();
					user.setName(fullName);
					user.setAge(userDetails.getDob().getAge());
					SimpleDateFormat formatter = new SimpleDateFormat("dd MMMM yyyy");
					String dob = formatter.format(userDetails.getDob().getDate());
					user.setDob(dob);
					DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("E, dd MMM yyyy HH:mm:ss");
					String localDate = LocalDateTime.now().format(dateFormatter);
					user.setDateCreated(localDate);
					user.setDateModified(localDate);
					user.setGender(userDetails.getGender());
					user.setNationality(userDetails.getNat());
					user.setVerificationStatus(verificationResult.name());

					repo.save(user);

					UserResponse response = new UserResponse();
					response.setName(user.getName());
					response.setDob(user.getDob());
					response.setAge(user.getAge());
					response.setGender(user.getGender());
					response.setNationality(user.getNationality());
					response.setVerificationStatus(user.getVerificationStatus());

					return response;
				} catch (CustomException ex) {
					throw new CustomException(ex.getMessage(), ex.getStatusCode());
				} catch (Exception ex) {
					throw new CustomException(ex.getMessage(), 500);
				}
			}).collect(Collectors.toList());
		} catch (RuntimeException ex) {
			throw new CustomException(ex.getMessage(), 500);
		}

		return users;

	}

	public List<User> getUsers(String sortType, String sortOrder, int limit, int offset, PageInfo pageInfo) {

		long totalUsers = repo.count();
		// Calculate the total number of pages
		long totalPages = (long) Math.ceil((double) totalUsers / limit);

		offset = Math.min(offset, (int) (totalPages - 1));

		List<User> users;

		if ("Age".equalsIgnoreCase(sortType)) {
			if ("EVEN".equalsIgnoreCase(sortOrder)) {
				users = repo.findAllByAgeIsEven();
			} else {
				users = repo.findAllByAgeIsOdd();
			}
		} else {
			if ("ODD".equalsIgnoreCase(sortOrder)) {
				users = repo.findAllByNameLengthIsOdd();
			} else {
				users = repo.findAllByNameLengthIsEven();
			}
		}

		int startIndex = Math.min(offset, users.size());
		int endIndex = Math.min(startIndex + limit, users.size());

		List<User> limitedUsers = users.subList(startIndex, endIndex);

		pageInfo.setHasNextPage(offset < totalPages - 1);
		pageInfo.setHasPreviousPage(offset > 0);
		pageInfo.setTotal(totalUsers);

		return limitedUsers;
	}
}
