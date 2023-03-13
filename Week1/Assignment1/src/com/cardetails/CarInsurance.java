// This code is a class named "CarInsurance" that implements the "Insurance" interface.
// The purpose of this code is to calculate insurance based on the car's cost price, 

package com.cardetails;

import com.constants.*; // Importing the necessary constants from the "constants" package.
import com.exceptions.*; // Importing the necessary exceptions from the "exceptions" package.

public class CarInsurance implements Insurance {

	// This method returns the premium rate for a given car type.
	// It throws an InvalidInputException if the car type is not one of the
	// predefined constants.
	private double getPremiumRate(String carType) throws InvalidInputException {
		switch (carType) {
		case Constant.HATCHBACK_TYPE:
			return Constant.HATCHBACK_PREMIUM_RATE;
		case Constant.SEDAN_TYPE:
			return Constant.SEDAN_PREMIUM_RATE;
		case Constant.SUV_TYPE:
			return Constant.SUV_PREMIUM_RATE;
		default:
			throw new InvalidInputException("Invalid car type");
		}
	}

	// This method calculates the insurance premium based on the car's cost price,
	// car type, and insurance type.
	// It throws an InvalidInputException if the insurance type is not one of the
	// predefined constants.
	@Override
	public double calculateInsurance(double carCostPrice, String carType, String insuranceType)
			throws InvalidInputException {
		double premium = 0.0;
		if (insuranceType.equals(Constant.BASIC_INSURANCE)) { // Checking if insurance type is BASIC_INSURANCE.
			premium = carCostPrice * getPremiumRate(carType); // Calculating the premium without any surcharge.
			return premium;
		} else {
			premium = carCostPrice * getPremiumRate(carType); // Calculating the premium without surcharge.
			premium += Constant.PREMIUM_SURCHARGE_RATE * premium; // Adding surcharge to the premium.

			return premium;
		}
	}
}
