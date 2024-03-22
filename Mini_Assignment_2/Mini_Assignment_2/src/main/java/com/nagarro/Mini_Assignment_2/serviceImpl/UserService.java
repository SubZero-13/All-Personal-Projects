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
import com.nagarro.Mini_Assignment_2.enums.SortOrder;
import com.nagarro.Mini_Assignment_2.enums.SortType;
import com.nagarro.Mini_Assignment_2.enums.VerificationResult;
import com.nagarro.Mini_Assignment_2.exception.CustomException;
import com.nagarro.Mini_Assignment_2.repos.UserRepository;
import com.nagarro.Mini_Assignment_2.services.UserServiceInterface;
import com.nagarro.Mini_Assignment_2.sorting.factory.SortingStrategyFactory;
import com.nagarro.Mini_Assignment_2.sorting.strategy.UserSortingStrategy;

@Service
public class UserService implements UserServiceInterface {

	private final ApiService apiService;
	private final VerificationService verificationService;
	private final UserRepository repo;
	private final SortingStrategyFactory sortingStrategyFactory;

	@Autowired
	public UserService(ApiService apiService, VerificationService verificationService, UserRepository repo,
			SortingStrategyFactory sortingStrategyFactory) {
		this.apiService = apiService;
		this.verificationService = verificationService;
		this.repo = repo;
		this.sortingStrategyFactory = sortingStrategyFactory;
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

		List<User> users;

		UserSortingStrategy sortingStrategy = sortingStrategyFactory.getSortingStrategy(
				SortType.valueOf(sortType.toUpperCase()), SortOrder.valueOf(sortOrder.toUpperCase()));
		users = sortingStrategy.applySort();

		int startIndex = Math.min(offset, users.size());
		int endIndex = Math.min(startIndex + limit, users.size());

		List<User> limitedUsers = users.subList(startIndex, endIndex);

		if (limitedUsers.size() == 0) {
			throw new CustomException("No Result found.", 404);
		}

		if (limitedUsers.size() < limit) {
			throw new CustomException("There are fewer results than the requested limit", 404);
		}

		pageInfo.setHasNextPage(offset + limit < totalUsers);
		pageInfo.setHasPreviousPage(offset > 0);
		pageInfo.setTotal(totalUsers);

		return limitedUsers;
	}
}
