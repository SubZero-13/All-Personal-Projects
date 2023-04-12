package com.nagarro.searching;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.nagarro.tshirtdetails.Tshirt;
import com.nagarro.tshirtdetails.TshirtInput;
import com.nagarro.enums.*;
import com.nagarro.exceptions.ItemNotPresentException;
import com.nagarro.comparator.*;
import com.nagarro.csvfiles.*;

public class Search {
	public List<Tshirt> searchTshirt(TshirtInput tshirtIp) throws ItemNotPresentException {
		List<Tshirt> result = new ArrayList<Tshirt>();

		CSVFileReader csvReader = new CSVFileReader();
		Map<String, List<Tshirt>> data = csvReader.getData();
		List<Tshirt> tshirts = new ArrayList<>();
		for (List<Tshirt> value : data.values()) {
			tshirts.addAll(value);
		}

		Comparator<Tshirt> pricecompare = new PriceComparator();
		Comparator<Tshirt> ratingcompare = new RatingComparator();
		Comparator<Tshirt> bothcompare = new BothComparator();

		String color = tshirtIp.getColor().toString();
		String gender = tshirtIp.getGender().toString();
		String size = tshirtIp.getSize().toString();
		OutputPreference preference = tshirtIp.getOutputPreference();

		for (Tshirt tshirt : tshirts) {
			if (tshirt.getColor().toString().equalsIgnoreCase(color)
					&& tshirt.getSize().toString().equalsIgnoreCase(size)
					&& tshirt.getGender().toString().equalsIgnoreCase(gender)
					&& tshirt.getAvalibilty().equalsIgnoreCase("Y")) {
				result.add(tshirt);
			}
		}
		if (result.size() == 0) {
			throw new ItemNotPresentException(
					"Oh no, it seems we're all out of T-shirts that match your search. Time to change up your style!");
		}

		switch (preference) {
		case PRICE:
			Collections.sort(result, pricecompare);
			break;
		case RATING:
			Collections.sort(result, ratingcompare);
			break;
		case BOTH:
			Collections.sort(result, bothcompare);
			break;
		}
		return result;
	}
}
