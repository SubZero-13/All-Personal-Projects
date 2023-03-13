/*
This is a Java interface named "Insurance". It declares one method signature "calculateInsurance" 
which takes three parameters, the cost price of the car as a double, the car type as a String, 
and the insurance type as a String, and throws an "InvalidInputException".
Any class implementing this interface should provide an implementation for this method.
 */
package com.cardetails;

import com.exceptions.InvalidInputException;

public interface Insurance {
	double calculateInsurance(double carCostPrice, String carType, String insuranceType) throws InvalidInputException;
}
