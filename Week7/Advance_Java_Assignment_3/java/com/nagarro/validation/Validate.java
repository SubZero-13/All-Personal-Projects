package com.nagarro.validation;

public class Validate {

	public static String validateUsername(String uname) {
		if (uname == null || uname.trim().isEmpty()) {
			return "Please enter a username";
		}
		return null;
	}

	public static String validatePassword(String pass) {
		if (pass == null || pass.trim().isEmpty()) {
			return "Please enter a password";
		}
		return null;
	}
}
