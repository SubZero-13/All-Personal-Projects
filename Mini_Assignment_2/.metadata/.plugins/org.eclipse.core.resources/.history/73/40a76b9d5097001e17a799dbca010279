package com.nagarro.Mini_Assignment_2.validators;

import org.springframework.stereotype.Component;
import com.nagarro.Mini_Assignment_2.exception.BadRequestException;

@Component
public class NumericValidator implements Validator<String> {

	private static final NumericValidator instance = new NumericValidator();

	private NumericValidator() {
		// private constructor to prevent instantiation
	}

	public static NumericValidator getInstance() {
		return instance;
	}

	@Override
	public void validate(String input, String parameter) {
		if (!input.matches("\\d+")) {
			throw new BadRequestException("Invalid Type for Request Parameter: " + parameter, 400);
		}
	}
}
