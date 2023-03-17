/**
 * A generic priority queue implementation that uses a heap data structure.
 * This class can be instantiated with a Comparator object to define the 
 * order of elements in the priority queue.
 * 
 * @param <E> The type of elements stored in the priority queue
 */

package com.nagarro.priorityqueue;

/** Importing Neccesary Packages*/
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import com.nagarro.comparable.Compare;
import com.nagarro.exceptions.UnderFlowException;
import com.nagarro.iterator.PriorityQueueIterator;

/** Import Packages End Here */

public class MyPriorityQueue<E> implements Iterable<E> {
	private ArrayList<E> dataList;
	private Comparator<E> comparator;
	private Compare comp; // Declaring Compare object for Comparison

	public MyPriorityQueue() {
		this(null);
	}

	public MyPriorityQueue(Comparator comparator) {
		dataList = new ArrayList<>();
		this.comparator = comparator;
		comp = new Compare(this.comparator);
	}

	// Method to insert an element into the priority queue
	public void enQueue(E element) {
		dataList.add(element);
		upheapify(dataList.size() - 1);
	}

	/**
	 * Restores the heap property by moving the element at the given index up the
	 * heap if necessary.
	 * 
	 * @param index The index of the element to be upheapified
	 */
	private void upheapify(int index) {
		if (index == 0)
			return;

		int parentIndex = (index - 1) / 2;

		if (comp.compare(dataList.get(index), dataList.get(parentIndex)) < 0) {
			swap(index, parentIndex);
			upheapify(parentIndex);
		}
	}

	// Method to remove the highest priority element from the priority queue
	public E deQueue() throws UnderFlowException {
		if (this.size() == 0)
			throw new UnderFlowException("Underflow");

		swap(0, dataList.size() - 1);
		E value = dataList.remove(dataList.size() - 1);
		downHeapify(0);
		return value;
	}

	/**
	 * Restores the heap property by moving the element at the given index down the
	 * heap if necessary.
	 * 
	 * @param parentIndex The index of the parent element
	 */

	private void downHeapify(int parentIndex) {

		int minIndex = parentIndex;
		int leftIndex = (parentIndex * 2) + 1;
		int rightIndex = (parentIndex * 2) + 2;

		if (leftIndex < size() && comp.compare(dataList.get(leftIndex), dataList.get(minIndex)) < 0) {
			minIndex = leftIndex;
		}

		if (rightIndex < size() && comp.compare(dataList.get(rightIndex), dataList.get(minIndex)) < 0) {
			minIndex = rightIndex;
		}

		if (minIndex != parentIndex) {
			swap(parentIndex, minIndex);
			downHeapify(minIndex);
		}
	}

	private void swap(int i, int j) {
		E ith = dataList.get(i);
		E jth = dataList.get(j);
		dataList.set(i, jth);
		dataList.set(j, ith);
	}

	public E peek() throws Exception {
		if (this.size() == 0)
			throw new Exception("Underflow");
		return dataList.get(0);
	}

	public int size() {
		return this.dataList.size();
	}

	public boolean isEmpty() {
		return dataList.size() == 0;
	}

	public boolean contains(E value) throws UnderFlowException {
		return dataList.contains(value);
	}

	public E center() throws UnderFlowException {
		if (dataList.size() == 0)
			throw new UnderFlowException("Priority Queue is Empty");
		int mid = (dataList.size() / 2);
		return dataList.get(mid);
	}

	public void reverse() throws UnderFlowException {
		if (dataList.size() == 0)
			throw new UnderFlowException("Priority Queue is Empty");
		Collections.reverse(dataList);
	}

	public void traverse() {
		for (E element : dataList) {
			System.out.print(element + " ");
		}
		System.out.println();
	}

	public Iterator<E> iterator() {
		return new PriorityQueueIterator(dataList);
	}
}
