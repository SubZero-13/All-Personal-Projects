package com.driver;

import com.cardetails.*;
import com.exceptions.*;
import java.util.Scanner;

public class InputHandler {
    private static Scanner scanner = new Scanner(System.in);

    public static Car getCarDetailsFromUser() {
        String model = null;
        String type = null;
        double price = 0.0;
        String insuranceType = null;

        try {
            System.out.print("Enter Car Model: ");
            model = scanner.nextLine();

            System.out.print("Enter Car Type (Hatchback/Sedan/SUV): ");
            type = scanner.nextLine();

            System.out.print("Enter Car Cost Price: ");
            price = scanner.nextDouble();

            scanner.nextLine();
            System.out.print("Enter Insurance Type (Basic/Premium): ");
            insuranceType = scanner.nextLine();
            return new Car(model, type, price, insuranceType);
        } catch (Exception e) {
            System.out.println(e.getMessage());
//            scanner.nextLine();
            return null;
        }
    }

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

