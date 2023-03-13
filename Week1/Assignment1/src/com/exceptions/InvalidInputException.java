/**
This class represents an exception that is thrown when invalid input is provided.
*/
package com.exceptions;

public class InvalidInputException extends Exception {

	/**
	 * Constructs an InvalidInputException object with the given error message.
	 * 
	 * @param errorMessage the error message associated with the exception
	 */
	public InvalidInputException(String errorMessage) {
		super(errorMessage);
	}
}
