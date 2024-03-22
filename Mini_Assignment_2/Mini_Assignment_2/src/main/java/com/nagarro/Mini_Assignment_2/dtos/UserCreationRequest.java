package com.nagarro.Mini_Assignment_2.dtos;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class UserCreationRequest {

	@NotNull(message = "Size is Mandatory")
	@Min(value = 1, message = "Size should not be less than 1")
	@Max(value = 5, message = "Size should not be greater than 5")
	private int size;

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

}
