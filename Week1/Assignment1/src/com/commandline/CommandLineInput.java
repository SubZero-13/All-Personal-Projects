package com.commandline;

import com.cardetails.Car;
import com.cardetails.CarInsurance;
import com.exceptions.InvalidInputException;

public class CommandLineInput {
		public static void commandInput(String[] args) {

			// Initializing variables for car details.
			String carModel = null;
			String carType = null;
			double carPrice = 0.0;
			String insuranceType = null;

			// Reading command line arguments and setting car details.
			try {
				for (int i = 0; i < args.length; i++) {
					if (args[i].equals("-model")) {
						carModel = args[++i];
					} else if (args[i].equals("-type")) {
						carType = args[++i];
					} else if (args[i].equals("-price")) {
						carPrice = Double.parseDouble(args[++i]);
					} else if (args[i].equals("-insuranceType")) {
						insuranceType = args[++i];
					}
				}

				// Creating a new car object with the provided details.
				Car car = new Car(carModel, carType, carPrice, insuranceType);

				// Creating a new instance of the CarInsurance class.
				CarInsurance carInsurance = new CarInsurance();

				// Calculating the insurance premium for the provided car details.
				double premium = carInsurance.calculateInsurance(car.getCarPrice(), car.getCarType().toString(),
						car.getInsuranceType().toString());

				// Printing the details and premium of the insured car.
				System.out.println("Car Details:");
				System.out.println("Model: " + car.getCarModel());
				System.out.println("Type: " + car.getCarType());
				System.out.println("Price: " + car.getCarPrice());
				System.out.println("Insurance Type: " + car.getInsuranceType());
				System.out.println("Total Insurance to be Paid: " + premium);

			} catch (InvalidInputException e) {
				System.out.println("Error: " + e.getMessage());
			} catch (IllegalArgumentException e) {
				System.out.println("Error: Invalid value provided for a command line argument.");
			} catch (Exception e) {
				System.out.println("Error: " + e.getMessage());
			}
		}
	}
