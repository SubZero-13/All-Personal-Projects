package com.nagarro.io;

import java.util.List;

import com.nagarro.tshirtdetails.Tshirt;

public class OutputResult {
	public void printData(List<Tshirt> result) {
		System.out.println(result.size() + " T-shirt(s) Available in Our Store that matches your search criteria");
		System.out.println("----------------------------------------------------------------------------------------");
		result.forEach(tshirt -> {
			System.out.println(tshirt);
			System.out.println("--------------------------------------------------------------");
		});
	}
}
