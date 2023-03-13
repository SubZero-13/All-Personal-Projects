// This code is the main class of the application.
// The purpose of this code is to take input from the user, process it, and display the output.

package com.app;

import com.cardetails.*; // Importing the necessary classes from the "cardetails" package.
import com.driver.*; // Importing the necessary classes from the "driver" package.
import com.commandline.*;
public class Main {

	public static void main(String args[]) {
		
		CommandLineInput command = new CommandLineInput();
		command.commandInput(args);
		System.out.println();
		
		// Creating an instance of the InputHandler class to get user input.
		InputHandler input = new InputHandler();
		
		// Creating an instance of the Output class to display the output.
		Output output = new Output();

		while (true) { // Looping until the user chooses to exit.

			// Getting car details from the user using the getCarDetailsFromUser method.
			Car car = input.getCarDetailsFromUser();

			// Printing an empty line for formatting purposes.
			System.out.println();

			// Printing the car details using the printCarDetails method.
			output.printCarDetails(car);

			System.out.println();

			// Getting the user's choice to continue or exit using the getYesNoInputFromUser
			// method.
			String choice = input.getYesNoInputFromUser();

			if (choice.equals("n")) // Checking if the user wants to exit the application.
				break; // Exiting the loop if the user chooses to exit.
		}
		System.out.print("Thank You for using our Application"); // Displaying a message to thank the user for using the
																	// application.
	}
}
