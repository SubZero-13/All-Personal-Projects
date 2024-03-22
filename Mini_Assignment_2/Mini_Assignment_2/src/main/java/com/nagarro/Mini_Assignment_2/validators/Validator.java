package com.nagarro.Mini_Assignment_2.validators;

public interface Validator<T> {
	void validate(T value, T parameter);
}
