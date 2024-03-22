package com.nagarro.Mini_Assignment_2.sorting.factory;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nagarro.Mini_Assignment_2.enums.SortOrder;
import com.nagarro.Mini_Assignment_2.enums.SortType;
import com.nagarro.Mini_Assignment_2.enums.SortingStrategyKey;
import com.nagarro.Mini_Assignment_2.sorting.strategy.AgeEvenSortingStrategy;
import com.nagarro.Mini_Assignment_2.sorting.strategy.AgeOddSortingStrategy;
import com.nagarro.Mini_Assignment_2.sorting.strategy.NameLengthEvenSortingStrategy;
import com.nagarro.Mini_Assignment_2.sorting.strategy.NameLengthOddSortingStrategy;
import com.nagarro.Mini_Assignment_2.sorting.strategy.UserSortingStrategy;

@Component
public class SortingStrategyFactory {

	private final AgeEvenSortingStrategy ageEvenSorting;
	private final AgeOddSortingStrategy ageOddSorting;
	private final NameLengthOddSortingStrategy nameOddSorting;
	private final NameLengthEvenSortingStrategy nameEvenSorting;

	private Map<SortingStrategyKey, UserSortingStrategy> sortingStrategyMap;

	@Autowired
	public SortingStrategyFactory(AgeEvenSortingStrategy ageEvenSorting, AgeOddSortingStrategy ageOddSorting,
			NameLengthOddSortingStrategy nameOddSorting, NameLengthEvenSortingStrategy nameEvenSorting) {
		this.ageEvenSorting = ageEvenSorting;
		this.ageOddSorting = ageOddSorting;
		this.nameOddSorting = nameOddSorting;
		this.nameEvenSorting = nameEvenSorting;

		sortingStrategyMap = new HashMap<>();
		sortingStrategyMap.put(SortingStrategyKey.AGE_EVEN, this.ageEvenSorting);
		sortingStrategyMap.put(SortingStrategyKey.AGE_ODD, this.ageOddSorting);
		sortingStrategyMap.put(SortingStrategyKey.NAME_LENGTH_ODD, this.nameOddSorting);
		sortingStrategyMap.put(SortingStrategyKey.NAME_LENGTH_EVEN, this.nameEvenSorting);
	}

	public UserSortingStrategy getSortingStrategy(SortType sortType, SortOrder sortOrder) {
		SortingStrategyKey strategyKey = buildSortingStrategyKey(sortType, sortOrder);
		return sortingStrategyMap.get(strategyKey);
	}

	private SortingStrategyKey buildSortingStrategyKey(SortType sortType, SortOrder sortOrder) {
		switch (sortType) {
		case AGE:
			return (sortOrder == SortOrder.EVEN) ? SortingStrategyKey.AGE_EVEN : SortingStrategyKey.AGE_ODD;
		case NAME:
			return (sortOrder == SortOrder.EVEN) ? SortingStrategyKey.NAME_LENGTH_EVEN
					: SortingStrategyKey.NAME_LENGTH_ODD;
		default:
			throw new IllegalArgumentException("Invalid sortType: " + sortType);
		}
	}
}
