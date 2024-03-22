package com.nagarro.Mini_Assignment_2.sorting.strategy;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.nagarro.Mini_Assignment_2.entities.User;
import com.nagarro.Mini_Assignment_2.repos.UserRepository;

@Configuration
public class AgeOddSortingStrategy implements UserSortingStrategy {

	private final UserRepository repo;

	@Autowired
	public AgeOddSortingStrategy(UserRepository repo) {
		this.repo = repo;

	}

	@Override
	public List<User> applySort() {
		return repo.findAllByAgeIsOdd();
	}
}