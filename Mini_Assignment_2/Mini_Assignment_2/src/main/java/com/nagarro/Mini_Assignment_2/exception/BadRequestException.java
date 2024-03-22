package com.nagarro.Mini_Assignment_2.exception;

public class BadRequestException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	private final int statusCode;

	public BadRequestException(String message, int statusCode) {
		super(message);
		this.statusCode = statusCode;
	}

	public int getStatusCode() {
		return statusCode;
	}

}
