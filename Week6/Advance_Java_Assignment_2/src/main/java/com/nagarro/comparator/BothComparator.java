package com.nagarro.comparator;

import java.util.Comparator;

import com.nagarro.tshirtdetails.Tshirt;

public class BothComparator implements Comparator<Tshirt> {

	public int compare(Tshirt tshirt1, Tshirt tshirt2) {
		int ratingComparison = (int) (tshirt2.getRating() - tshirt1.getRating());
		if (ratingComparison == 0) {
			return (int) (tshirt1.getPrice() - tshirt2.getPrice());
		} else {
			return ratingComparison;
		}
	}
}
