package com.cardetails;

import com.constants.*;
import com.exceptions.*;

public class CarInsurance implements Insurance {

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

	@Override
	public double calculateInsurance(double carCostPrice, String carType, String insuranceType) throws InvalidInputException {
		double premium = 0.0;
		if (insuranceType.equals(Constant.BASIC_INSURANCE)) {
			premium = carCostPrice * getPremiumRate(carType);
			return premium;
		} else {
			premium = carCostPrice * getPremiumRate(carType);
			premium += Constant.PREMIUM_SURCHARGE_RATE * premium;
			return premium;
		}
	}
}