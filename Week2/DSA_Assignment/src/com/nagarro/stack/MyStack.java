package com.nagarro.stack;

// Necessary Packages Import starts Here
import com.nagarro.linkedlist.*;

import com.nagarro.exceptions.*;
import com.nagarro.iterator.NodeIterator;

import java.util.Comparator;
import java.util.Iterator;

import com.nagarro.comparable.*;
//Necessary Packages Import ends Here

public class MyStack<E> implements Iterable<E> {
	private Node<E> top;
	private int size;
	// objects to compare elements of the queue
	Compare compare;
	Comparator comparator;

	public MyStack() {
		this(null);
	}

	public MyStack(Comparator comparator) {
		top = null;
		size = 0;
		this.comparator = comparator;
		compare = new Compare(comparator);
	}

	/**
	 * Method to Push Element into Stack
	 * 
	 * @param value
	 */

	public void push(E value) {
		Node<E> newNode = new Node(value);
		if (top == null) {
			top = newNode;
		} else {
			newNode.next = top;
			top = newNode;
		}
		size++;
	}

	/**
	 * Method to Pop Element from stack
	 * 
	 * @return <E>
	 * @throws UnderFlowException
	 */
	public E pop() throws UnderFlowException {
		if (top == null) {
			throw new UnderFlowException("Stack is Empty");
		}

		E value = top.val;
		top = top.next;
		size--;
		return value;
	}

	/**
	 * Method to Return Peek element from Stack
	 * 
	 * @return <E>
	 * @throws UnderFlowException
	 */
	public E peek() throws UnderFlowException {
		if (top == null) {
			throw new UnderFlowException("Stack is Empty");
		}
		return top.val;
	}

	public boolean isEmpty() {
		return top == null;
	}

	public int size() {
		return size;
	}

	/**
	 * Sort the stack in ascending order
	 * 
	 * @throws UnderFlowException
	 */
	public void sort() throws UnderFlowException {
		if (isEmpty()) {
			throw new UnderFlowException("List is Empty");
		}

		MyStack<E> tempStack = new MyStack<>();

		while (!isEmpty()) {
			E currentData = pop();

			while (!tempStack.isEmpty() && compare.compare(currentData, tempStack.peek()) < 0) {
				push(tempStack.pop());
			}

			tempStack.push(currentData);
		}

		while (!tempStack.isEmpty()) {
			push(tempStack.pop());
		}
	}

	/**
	 * Reverse the stack
	 * 
	 * @throws UnderFlowException
	 */
	public void reverse() throws UnderFlowException {
		if (isEmpty()) {
			throw new UnderFlowException("Stack is Empty");
		}
		Node<E> current = top;
		Node<E> previous = null;

		while (current != null) {
			Node<E> next = current.next;
			current.next = previous;
			previous = current;
			current = next;
		}
		top = previous;
	}

	public boolean contains(E element) {
		Node<E> node = top;
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
		Node<E> slow = top;
		Node<E> fast = top;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow.val;
	}

	public void traverse() throws UnderFlowException {
		if (top == null) {
			throw new UnderFlowException("Stack is Empty");
		}
		Node<E> temp = top;
		while (temp != null) {
			System.out.println(temp.val);
			temp = temp.next;
		}
	}

	public Iterator<E> iterator() {
		return new NodeIterator(top);
	}
}
