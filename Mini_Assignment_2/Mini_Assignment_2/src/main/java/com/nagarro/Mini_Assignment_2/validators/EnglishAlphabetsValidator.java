package com.nagarro.Mini_Assignment_2.validators;

import org.springframework.stereotype.Component;

import com.nagarro.Mini_Assignment_2.constant.UserQueryConstants;
import com.nagarro.Mini_Assignment_2.enums.SortOrder;
import com.nagarro.Mini_Assignment_2.enums.SortType;
import com.nagarro.Mini_Assignment_2.exception.BadRequestException;

@Component
public class EnglishAlphabetsValidator implements Validator<String> {

	private static EnglishAlphabetsValidator instance = new EnglishAlphabetsValidator();

	private EnglishAlphabetsValidator() {
		// private constructor to prevent instantiation
	}

//	public static EnglishAlphabetsValidator getInstance() {
//		return instance;
//	}
	public static synchronized EnglishAlphabetsValidator getInstance() {
		if (instance == null) {
			instance = new EnglishAlphabetsValidator();
		}
		return instance;
	}

	@Override
	public void validate(String input, String parameter) {
		if (!input.matches("[a-zA-Z]+")) {
			throw new BadRequestException("Invalid Type for Request Parameter: " + parameter, 400);
		} else if (parameter.equals(UserQueryConstants.SORT_TYPE)
				&& (!input.equalsIgnoreCase(SortType.AGE.name()) && !input.equalsIgnoreCase(SortType.NAME.name()))) {
			throw new BadRequestException(
					"Invalid value for sortType parameter: " + input + " (Should only be Age or Name)", 400);
		} else if (parameter.equals(UserQueryConstants.SORT_ORDER)
				&& (!input.equalsIgnoreCase(SortOrder.EVEN.name()) && !input.equalsIgnoreCase(SortOrder.ODD.name()))) {
			throw new BadRequestException(
					"Invalid value for sortOrder parameter: " + input + " (Should only be Even or Odd)", 400);
		}
	}
}