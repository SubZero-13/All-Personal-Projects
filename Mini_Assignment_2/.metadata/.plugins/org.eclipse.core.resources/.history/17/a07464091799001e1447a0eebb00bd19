package com.nagarro.Mini_Assignment_2.validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nagarro.Mini_Assignment_2.exception.BadRequestException;

@Component
public class ValidatorFactory {

	@Autowired
	private NumericValidator numericValidator;

	@Autowired
	private EnglishAlphabetsValidator englishAlphabetsValidator;

	public Validator<String> getValidator(String parameter) {
		if (parameter.equalsIgnoreCase("SortType") || parameter.equalsIgnoreCase("SortOrder")) {
			return englishAlphabetsValidator;

		} else if (parameter.equalsIgnoreCase("Limit") || parameter.equalsIgnoreCase("Offset")) {
			return numericValidator;
		} else {
			throw new BadRequestException("Parameter is not Valid", 400);
		}
	}
}
