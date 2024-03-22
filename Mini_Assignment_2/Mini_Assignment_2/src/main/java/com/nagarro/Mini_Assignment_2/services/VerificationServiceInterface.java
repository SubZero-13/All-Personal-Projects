package com.nagarro.Mini_Assignment_2.services;

import com.nagarro.Mini_Assignment_2.dtos.UserInfo;
import com.nagarro.Mini_Assignment_2.enums.VerificationResult;

public interface VerificationServiceInterface {
	public VerificationResult verifyUser(UserInfo userDetails);

}
