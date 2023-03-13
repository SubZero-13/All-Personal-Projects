package com.inputvalidator;

// Package Import Starts
import java.util.regex.Matcher;
import java.util.regex.Pattern;
// Package Import ends

public class Validator {

	// Validate Car Model
	public boolean validateCarModel(String model) {
		Pattern p = Pattern.compile("^[ A-Za-z]+$");
		Matcher m = p.matcher(model);
		return m.matches();
	}

	// Validating Car Type
	public boolean validateCarType(String model) {
		if (model.equals("Hatchback") || model.equals("Sedan") || model.equals("SUV")) {
			return true;
		}
		return false;
	}

	// Validating Car Price
	public boolean validateCarPrice(double price) {
		if (price <= 0)
			return false;
		return true;
	}

	// Validating Car Insurance
	public boolean validateCarInsurance(String insurance) {
		if (insurance.equals("Basic") || insurance.equals("Premium")) {
			return true;
		}
		return false;
	}
}
