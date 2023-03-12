package com.cardetails;

//Package Import Starts Here
import com.inputvalidator.*;
import com.exceptions.*;

// Package Import Ends Here

public class Car {
	private String carModel;
	private String carType;
	private double carPrice;
	private String insuranceType;

	Validator validate = new Validator();

	public Car(String model, String type, double price, String insurance) throws InvalidInputException {
		setCarModel(model);
		setCarType(type);
		setCarPrice(price);
		setInsuranceType(insurance);
	}

	// Setting Car Model
	public void setCarModel(String model) throws InvalidInputException {
		if (validate.validateCarModel(model)) {
			this.carModel = model;
		} else {
			throw new InvalidInputException("Enter Correct Car Model");
		}
	}

	// Getting Car Model
	public String getCarModel() {
		return carModel;
	}

	// Setting Car Type
	public void setCarType(String type) throws InvalidInputException {
		if (validate.validateCarType(type)) {
			this.carType = type;
		} else {
			throw new InvalidInputException("Enter Correct Car Type");
		}
	}

	// Getting Car Type
	public String getCarType() {
		return carType;
	}

	// Setting Car Price
	public void setCarPrice(double price) throws InvalidInputException {
		if (validate.validateCarPrice(price)) {
			this.carPrice = price;
		} else {
			throw new InvalidInputException("Car Price Should be Greater than 0");
		}
	}

	// Getting Car Price
	public double getCarPrice() {
		return carPrice;
	}

	// Setting Car Insurance Type
	public void setInsuranceType(String insurance) throws InvalidInputException {
		if (validate.validateCarInsurance(insurance)) {
			this.insuranceType = insurance;
		} else {
			throw new InvalidInputException("Enter Correct Insurance Type");
		}
	}

	// Getting Car Model
	public String getInsuranceType() {
		return insuranceType;
	}

}