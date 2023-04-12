package com.nagarro.io;

import java.util.*;
import com.nagarro.enums.*;
import com.nagarro.tshirtdetails.TshirtInput;

public class Input {
	Scanner scanner;

	public Input() {
		scanner = new Scanner(System.in);
	}

	public TshirtInput getInput() {
		TshirtInput tshirtIp = new TshirtInput();

		boolean isValid = true;
		System.out.println("Enter color of Tshirt:\n(available: Black,White,Blue,Purple,Grey,Pink,Maroon,Yellow)");
		String colorType = "";
		do {
			try {
				colorType = scanner.nextLine();
				if (Color.valueOf(colorType.toUpperCase()) != null) {
					tshirtIp.setColor(Color.valueOf(colorType.toUpperCase()));
					isValid = false;
				}
			} catch (IllegalArgumentException e) {
				System.out.println(
						"Enter a valid color of Tshirt:\n(available: Black,White,Blue,Purple,Grey,Pink,Maroon,Yellow)");
			}
		} while (isValid);

		isValid = true;
		System.out.println("Enter size of Tshirt: \n(choose: S , M , L, XL )");

		String sizeType = "";
		do {
			try {
				sizeType = scanner.nextLine();
				if (Size.valueOf(sizeType.toUpperCase()) != null) {
					tshirtIp.setSize(Size.valueOf(sizeType.toUpperCase()));
					isValid = false;
				}
			} catch (IllegalArgumentException e) {
				System.out.println("Enter a valid size of Tshirt:\n(choose: S , M , L, XL )");
			}

		} while (isValid);
		isValid = true;
		System.out.println("Gender : \n(M-male,F-female,U-unisex)");

		String gender = "";
		do {
			try {
				gender = scanner.nextLine();
				if (Gender.valueOf(gender.toUpperCase()) != null) {
					tshirtIp.setGender(Gender.valueOf(gender.toUpperCase()));
					isValid = false;
				}

			} catch (IllegalArgumentException e) {
				System.out.println("Enter a valid Gender:\n(M-male , F-femle,U-unisex )");
			}
		} while (isValid);

		isValid = true;
		System.out.println("Enter sorting output preference of Tshirt : \n(Price,Rating,Both)");

		String outputPreference = "";
		do {
			try {
				outputPreference = scanner.nextLine();
				if (OutputPreference.valueOf(outputPreference.toUpperCase()) != null) {
					tshirtIp.setOutputPreference(OutputPreference.valueOf(outputPreference.toUpperCase()));
					isValid = false;
				}

			} catch (IllegalArgumentException exception) {
				System.out.println("Enter a valid output preference:");
			}
		} while (isValid);

		return tshirtIp;
	}

	public String getYesOrNoInput() {
		scanner = new Scanner(System.in);
		System.out.println("Do You want to Search More T-shirts: (Y/N)");
		String input = scanner.next();
		return input;
	}
}
