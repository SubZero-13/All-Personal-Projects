package com.nagarro.Mini_Assignment_2.repos;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nagarro.Mini_Assignment_2.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

	@Query("SELECT u FROM User u WHERE FUNCTION('BITAND', u.age, 1) = 0")
	List<User> findAllByAgeIsEven();

	@Query("SELECT u FROM User u WHERE FUNCTION('BITAND', u.age, 1) = 1")
	List<User> findAllByAgeIsOdd();

	@Query(value = "SELECT * FROM user u WHERE LENGTH(u.name) % 2 = 0", nativeQuery = true)
	List<User> findAllByNameLengthIsEven();

	@Query(value = "SELECT * FROM user u WHERE LENGTH(u.name) % 2 = 1", nativeQuery = true)
	List<User> findAllByNameLengthIsOdd();
}
