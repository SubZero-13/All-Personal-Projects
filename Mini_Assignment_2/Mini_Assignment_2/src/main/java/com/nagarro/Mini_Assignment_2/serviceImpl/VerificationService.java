package com.nagarro.Mini_Assignment_2.serviceImpl;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.Mini_Assignment_2.dtos.UserInfo;
import com.nagarro.Mini_Assignment_2.enums.VerificationResult;
import com.nagarro.Mini_Assignment_2.exception.CustomException;
import com.nagarro.Mini_Assignment_2.services.VerificationServiceInterface;


@Service
public class VerificationService implements VerificationServiceInterface {

	private final ApiService apiService;

	@Autowired
	public VerificationService(ApiService apiService) {
		this.apiService = apiService;
	}

	public VerificationResult verifyUser(UserInfo userDetails) {
		try {
			CompletableFuture<List<String>> nationality = CompletableFuture
					.supplyAsync(() -> apiService.getCountries(userDetails.getName().getFirst()));

			CompletableFuture<String> genderStr = CompletableFuture
					.supplyAsync(() -> apiService.getGender(userDetails.getName().getFirst()));

			CompletableFuture<VerificationResult> combinedFuture = nationality.thenCombine(genderStr, (nat, gender) -> {
				if (nat.contains(userDetails.getNat()) && userDetails.getGender().equalsIgnoreCase(gender)) {
					return VerificationResult.VERIFIED;
				} else {
					return VerificationResult.TO_BE_VERIFIED;
				}
			});

			return combinedFuture.join();
		} catch (CustomException ex) {
			throw new CustomException(ex.getMessage(), ex.getStatusCode());
		} catch (Exception ex) {
			throw new CustomException(ex.getMessage(), 500);
		}
	}
}
