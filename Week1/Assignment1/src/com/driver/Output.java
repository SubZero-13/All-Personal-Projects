package com.driver;

import com.cardetails.*;

public class Output {
	public static void printCarDetails(Car car) {
		try {
			String model = car.getCarModel();
			String type = car.getCarType();
			double price = car.getCarPrice();
			String insuranceType = car.getInsuranceType();
			CarInsurance carinsurance = new CarInsurance();
			
			double insurancePaid = carinsurance.calculateInsurance(price, type, insuranceType);
			System.out.println("Car Model: " + model);
			System.out.println("Car Type: " + type);
			System.out.println("Car Type: " + price);
			System.out.println("Insurance Type: " + insuranceType);
			System.out.println("Total Insurance to be Paid: " + insurancePaid);
		} catch (Exception e) {
			 System.out.print("Invalid input. Please try again.");
		}
	}
}