package com.cardetails;

import com.exceptions.InvalidInputException;

public interface Insurance {
	double calculateInsurance(double carCostPrice, String carType, String insuranceType) throws InvalidInputException;
}
