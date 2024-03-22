package com.nagarro.Mini_Assignment_2.validators;

import org.springframework.stereotype.Component;

import com.nagarro.Mini_Assignment_2.constant.UserQueryConstants;
import com.nagarro.Mini_Assignment_2.exception.BadRequestException;

@Component
public class NumericValidator implements Validator<String> {

	private static NumericValidator instance = new NumericValidator();

	private NumericValidator() {
		// private constructor to prevent instantiation
	}

	public static synchronized NumericValidator getInstance() {
		if (instance == null) {
			instance = new NumericValidator();
		}
		return instance;
	}

	@Override
	public void validate(String input, String parameter) {
		if (!input.matches("\\d+")) {
			throw new BadRequestException("Invalid Type for Request Parameter: " + parameter, 400);
		} else if (UserQueryConstants.OFFSET.equalsIgnoreCase(parameter)) {
			int offsetValue = Integer.parseInt(input);
			if (offsetValue < 0 || offsetValue > 5) {
				throw new BadRequestException(
						"Invalid value for offset parameter: " + input + " (Should be Between 0 and 5)", 400);
			}
		} else if (UserQueryConstants.LIMIT.equalsIgnoreCase(parameter)) {
			int limitValue = Integer.parseInt(input);
			if (limitValue < 1 || limitValue > 5) {
				throw new BadRequestException(
						"Invalid value for limit parameter: " + input + " (Should be Between 1 and 5)", 400);
			}
		}
	}
}