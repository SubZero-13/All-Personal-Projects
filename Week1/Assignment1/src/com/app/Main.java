package com.app;

import com.cardetails.*;
import com.driver.*;

public class Main {
	public static void main(String args[]) {
		while (true) {
				InputHandler input = new InputHandler();
				Car car = input.getCarDetailsFromUser();
				Output output = new Output();
				System.out.println();
				output.printCarDetails(car);
				System.out.println();
				String choice = input.getYesNoInputFromUser();
				if (choice.equals("n"))
					break;
		}
		System.out.print("Thank You for using our Application");
	}
}
