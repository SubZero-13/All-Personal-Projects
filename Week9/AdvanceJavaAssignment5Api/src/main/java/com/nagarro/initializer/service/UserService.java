package com.nagarro.initializer.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nagarro.initializer.entities.User;

@Repository
public interface UserService extends CrudRepository<User, Integer> {
}
