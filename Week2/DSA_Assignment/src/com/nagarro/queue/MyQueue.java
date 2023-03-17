package com.nagarro.queue;

import java.util.Comparator;
import java.util.Iterator;

import com.nagarro.comparable.Compare;
import com.nagarro.exceptions.UnderFlowException;
import com.nagarro.iterator.NodeIterator;
import com.nagarro.linkedlist.Node;

public class MyQueue<E> implements Iterable<E> {
	private Node<E> front;
	private Node<E> rear;
	private int size = 0;
	Compare compare;
	Comparator comp;

	public MyQueue() {
		this(null);
	}

	public MyQueue(Comparator comp) {
		front = null;
		rear = null;
		size = 0;
		this.comp = comp;
		compare = new Compare(comp);
	}

	/**
	 * // method to add an element to the queue
	 * 
	 * @param value
	 */

	public void enQueue(E value) {
		Node<E> newNode = new Node(value);
		if (rear == null) {
			front = newNode;
			rear = newNode;
		} else {
			rear.next = newNode;
			rear = newNode;
		}
		size++;
	}

	/**
	 * // method to Remove an element from the queue
	 * 
	 * @return <E>
	 * @throws UnderFlowException
	 */

	public E deQueue() throws UnderFlowException {
		if (isEmpty()) {
			throw new UnderFlowException("Queue is Empty");
		}
		E value = front.val;
		front = front.next;
		if (front == null) {
			rear = null;
		}
		size--;
		return value;
	}

	/**
	 * method to Return peek element from the queue
	 * 
	 * @return <E>
	 * @throws UnderFlowException
	 */

	public E peek() throws UnderFlowException {
		if (front == null && rear == null) {
			throw new UnderFlowException("Queue is Empty");
		}
		return front.val;
	}

	public boolean isEmpty() {
		return front == null;
	}

	public int size() {
		return size;
	}

	/**
	 * method to Sort the queue
	 * 
	 * @throws UnderFlowException
	 */
	public void sort() throws UnderFlowException {
		if (isEmpty()) {
			throw new UnderFlowException("Queue is Empty");
		}
		E[] arr = toArray();
		mergeSort(arr);
		fromArray(arr);
	}

	/**
	 * Merger Sort Method to sort the Queue
	 * 
	 * @param arr
	 */
	private void mergeSort(E[] arr) {
		int n = arr.length;
		if (n < 2) {
			return;
		}
		int mid = n / 2;
		E[] left = (E[]) new Object[mid];
		E[] right = (E[]) new Object[n - mid];
		for (int i = 0; i < mid; i++) {
			left[i] = arr[i];
		}
		for (int i = mid; i < n; i++) {
			right[i - mid] = arr[i];
		}
		mergeSort(left);
		mergeSort(right);
		merge(arr, left, right);
	}

	/**
	 * method to merger two Sorted array
	 * 
	 * @param arr
	 * @param left
	 * @param right
	 */
	private void merge(E[] arr, E[] left, E[] right) {
		int nL = left.length;
		int nR = right.length;
		int i = 0, j = 0, k = 0;
		while (i < nL && j < nR) {
			if (compare.compare(left[i], right[j]) <= 0) {
				arr[k++] = left[i++];
			} else {
				arr[k++] = right[j++];
			}
		}
		while (i < nL) {
			arr[k++] = left[i++];
		}
		while (j < nR) {
			arr[k++] = right[j++];
		}
	}

	/**
	 * Convert Linked list into array
	 * 
	 * @return
	 */
	private E[] toArray() {
		E[] arr = (E[]) new Object[size];
		Node<E> node = front;
		int idx = 0;
		for (int i = 0; i < size; i++) {
			arr[i] = node.val;
			node = node.next;
		}
		return arr;
	}

	/**
	 * Converts Array into Linked List
	 * 
	 * @param arr
	 */
	private void fromArray(E[] arr) {
		front = null;
		rear = null;
		size = 0;
		for (E element : arr) {
			enQueue(element);
		}
	}

	/**
	 * Method to reverse the Queue
	 * 
	 * @throws UnderFlowException
	 */
	public void reverse() throws UnderFlowException {
		if (size == 0) {
			throw new UnderFlowException("Queue is Empty");
		}
		E[] arr = toArray();
		for (int i = 0, j = size() - 1; i < j; i++, j--) {
			E temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
		}
		fromArray(arr);
	}

	public boolean contains(E element) throws UnderFlowException {
		if (size == 0) {
			throw new UnderFlowException("Queue is Empty");
		}
		Node<E> node = front;
		while (node != null) {
			if (node.val.equals(element)) {
				return true;
			}
			node = node.next;
		}
		return false;
	}

	public E center() throws UnderFlowException {
		if (isEmpty()) {
			throw new UnderFlowException("Stack is empty");
		}
		Node<E> slow = front;
		Node<E> fast = front;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow.val;
	}

	public void traverse() throws UnderFlowException {
		if (front == null && rear == null) {
			throw new UnderFlowException("Queue is Empty");
		}
		Node<E> temp = front;
		while (temp != null) {
			System.out.print(temp.val + " ");
			temp = temp.next;
		}
		System.out.println();
	}

	public Iterator<E> iterator() {
		return new NodeIterator(front);
	}

}
