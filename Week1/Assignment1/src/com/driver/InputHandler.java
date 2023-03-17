package com.driver;

// Importing Necessary Package
import com.cardetails.*;
import com.exceptions.*;
import java.util.Scanner;

/**
 * A utility class for getting car details from the user and returning as Car
 * object.
 */
public class InputHandler {

	// Scanner object for taking user inputs from console
	private static Scanner scanner = new Scanner(System.in);

	/**
	 * Prompts the user to enter details of a car and returns the Car object.
	 * 
	 * @return The Car object containing the details entered by the user, or null if
	 *         an error occurred.
	 */
	public static Car getCarDetailsFromUser() {
		String model = null;
		String type = null;
		double price = 0.0;
		String insuranceType = null;

		try {
			// Prompt the user to enter car details
			System.out.println("Enter Deatils of The Car");
			System.out.print("Enter Car Model: ");
			model = scanner.nextLine();

			System.out.print("Enter Car Type (Hatchback/Sedan/SUV): ");
			type = scanner.nextLine();
			
			System.out.print("Enter Car Cost Price: ");
			while (!scanner.hasNextDouble()) {
				System.out.println("Invalid Input type Enter the double-type number:");
				System.out.print("Enter Car Cost Price Again: ");
				scanner.next();
			}
			price = scanner.nextDouble();
			System.out.print("Enter Insurance Type (Basic/Premium): ");
			scanner.nextLine();
			
			insuranceType = scanner.nextLine();
			return new Car(model, type, price, insuranceType);
		} catch (Exception e) {
			System.out.println(e.getMessage());
//            scanner.nextLine();
			return null;
		}

	}

	/**
	 * Prompts the user to enter a yes/no input and returns the input as a String.
	 * 
	 * @return The user input as a String ("y" or "n"), or null if an error
	 *         occurred.
	 */
	public static String getYesNoInputFromUser() {
		String input = null;
		try {
			System.out.print("Do you want to enter details of any other car (y/n): ");
			input = scanner.nextLine();
		} catch (Exception e) {
			System.out.println(e.getMessage());
//            scanner.nextLine();
			return null;
		}
		return input;
	}
}
