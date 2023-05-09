package com.nagarro.initializer.service;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.nagarro.initializer.entities.User;

@Service
public interface UserService extends CrudRepository<User, Integer> {
}
