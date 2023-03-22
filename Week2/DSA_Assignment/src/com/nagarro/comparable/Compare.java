/**
 * Constructor with Comparator argument.
 * 
 * @param comp the comparator to be used for comparison.
 */

package com.nagarro.comparable;

import java.util.Comparator;

public class Compare<E> implements Comparator<E> {
	private Comparator comp;

	public Compare(Comparator comp) {
		this.comp = comp;
	}

	/**
	 * Compares two elements of type E.
	 * 
	 * @param element1 the first element to be compared.
	 * @param element2 the second element to be compared.
	 * @return a negative integer, zero, or a positive integer as the first argument
	 *         is less than, equal to, or greater than the second, respectively.
	 */

	@Override
	public int compare(E element1, E element2) {
		if (comp == null) {
			return (((Comparable<E>) element1).compareTo(element2));
		} else {
			return comp.compare(element1, element2);
		}
	}

}
