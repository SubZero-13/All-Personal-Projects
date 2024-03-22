package com.nagarro.Mini_Assignment_2.validators;

import org.springframework.stereotype.Component;

import com.nagarro.Mini_Assignment_2.exception.BadRequestException;

@Component
public class EnglishAlphabetsValidator implements Validator<String> {

	private static final EnglishAlphabetsValidator instance = new EnglishAlphabetsValidator();

	private EnglishAlphabetsValidator() {
		// private constructor to prevent instantiation
	}

	public static EnglishAlphabetsValidator getInstance() {
		return instance;
	}

	@Override
	public void validate(String input, String parameter) {
		if (!input.matches("[a-zA-Z]+")) {
			throw new BadRequestException("Invalid Type for Request Parameter: " + parameter, 400);
		}
	}
}
