package com.nagarro.iterator;

import java.util.ArrayList;
import java.util.Iterator;

public class PriorityQueueIterator<E> implements Iterator<E> {
	private int currentIndex = 0;
	ArrayList<E> dataList;

	public PriorityQueueIterator(ArrayList<E> dataList) {
		this.dataList = dataList;
	}

	@Override
	public boolean hasNext() {
		return currentIndex < dataList.size() && dataList.get(currentIndex) != null;
	}

	@Override
	public E next() {
		return dataList.get(currentIndex++);
	}
}
