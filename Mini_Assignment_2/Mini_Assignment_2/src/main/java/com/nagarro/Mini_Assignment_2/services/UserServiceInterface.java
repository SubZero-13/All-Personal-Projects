package com.nagarro.Mini_Assignment_2.services;

import java.util.List;

import com.nagarro.Mini_Assignment_2.dtos.PageInfo;

import com.nagarro.Mini_Assignment_2.dtos.UserResponse;
import com.nagarro.Mini_Assignment_2.entities.User;

public interface UserServiceInterface {

	public List<UserResponse> createUser(int size);

	public List<User> getUsers(String sortType, String sortOrder, int limit, int offset, PageInfo pageInfo);

}
