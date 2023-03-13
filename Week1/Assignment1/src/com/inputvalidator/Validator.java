package com.inputvalidator;

// Package Import Starts
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.enums.*;
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
		if (model.equals(CarType.HATCHBACK.toString()) || model.equals(CarType.SEDAN.toString()) || model.equals(CarType.SUV.toString())) {
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
		if (insurance.equals(InsuranceType.BASIC.getValue()) || insurance.equals(InsuranceType.PREMIUM.getValue())) {
			return true;
		}
		return false;
	}
}
