package com.nagarro.linkedlist;

// Package Import Starts Here
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import com.nagarro.iterator.NodeIterator;

import com.nagarro.exceptions.*;
// Package Import Ends Here

public class MyLinkedList<E> implements Iterable<E> {
	private Node<E> head;
	private int size;
	Comparator comparator;

	public MyLinkedList() {
		head = null;
		comparator = null;
		size = 0;
	}

	public MyLinkedList(Comparator comparator) {
		head = null;
		this.comparator = comparator;
		size = 0;
	}

	public Node<E> getHead() throws EmptyListException {
		if (head == null) {
			throw new EmptyListException("Linked List is Empty");
		}
		return this.head;
	}

	// Adding Element At the Starting of LinkedList
	public void addFirst(E element) {
		Node<E> newNode = new Node(element);
		if (head == null) {
			head = newNode;
		} else {
			newNode.next = head;
			head = newNode;
		}
		size++;
	}

	// Adding Element at the End of LinkedList
	public void addLast(E element) {
		if (head == null) {
			addFirst(element);
		} else {
			Node<E> newNode = new Node<E>(element);
			Node<E> temp = head;
			while (temp.next != null) {
				temp = temp.next;
			}
			temp.next = newNode;
		}
		size++;
	}

	// Add Element Insert at Index
	public void addAtIndex(E element, int index) throws IndexOutOfBoundsException {
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException("Enter Correct Index");
		} else if (index == 0) {
			addFirst(element);
		} else if (index == size) {
			addLast(element);
		} else {
			Node<E> newNode = new Node<E>(element);
			Node<E> temp = head;
			for (int i = 0; i < index - 1; i++) {
				temp = temp.next;
			}
			newNode.next = temp.next;
			temp.next = newNode;
		}
		size++;
	}

	// Add Element
	public void add(E element) {
		addLast(element);
	}

	// Get method Returns Returns Element at Specified Index
	public E get(int index) throws IndexOutOfBoundsException {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Enter Correct Index");
		}
		Node<E> temp = head;
		for (int i = 0; i < index; i++) {
			temp = temp.next;
		}
		return temp.val;
	}

	// Remove First Element

	public E removeFirst() throws EmptyListException {
		if (head == null) {
			throw new EmptyListException("Cannot delete from an empty list.");
		}
		E removedElement = head.val;
		head = head.next;
		size--;
		return removedElement;
	}

	// Removing Node from last
	public E removeLast() throws EmptyListException {
		if (head == null) {
			throw new EmptyListException("Cannot delete from an empty list.");
		}

		Node<E> current = head;
		Node<E> previous = null;
		while (current.next != null) {
			previous = current;
			current = current.next;
		}

		E value = current.val;
		if (previous == null) {
			head = null;
		} else {
			previous.next = null;
		}
		size--;
		return value;
	}

	// Removing Node at Index
	public E remove(int index) throws EmptyListException, IndexOutOfBoundsException {
		if (head == null) {
			throw new EmptyListException("Cannot remove from an empty list.");
		}
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException("Index is Out of Bound.");
		}

		E value;
		if (index == 0) {
			value = removeFirst();
		} else {
			Node<E> current = head;
			Node<E> previous = null;
			int i = 0;
			while (i < index && current != null) {
				previous = current;
				current = current.next;
				i++;
			}
			if (current == null) {
				throw new IndexOutOfBoundsException("Index out of bounds.");
			}
			value = current.val;
			previous.next = current.next;
		}
		size--;
		return value;
	}

	// Get Center Element
	public E getMiddle() throws EmptyListException {
		if (head == null) {
			throw new EmptyListException("Cannot get center element of an empty list.");
		}

		Node<E> slow = head;
		Node<E> fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		return slow.val;
	}

	// Sorting the List
	public void sort() throws EmptyListException {
		if (head == null || head.next == null) {
			throw new EmptyListException("Cannot Sort an empty list.");
		}
		head = mergeSort(head);
	}

	public Node<E> mergeSort(Node<E> node) {
		if (node == null || node.next == null) {
			return node;
		}
		Node<E> middle = getMiddle(node);
		Node<E> middleNext = middle.next;
		middle.next = null;
		Node<E> left = mergeSort(node);
		Node<E> right = mergeSort(middleNext);
		return merge(left, right);
	}

	public Node<E> merge(Node<E> left, Node<E> right) {
		Node<E> dummyHead = new Node<E>(null);
		Node<E> current = dummyHead;
		while (left != null && right != null) {
			if (compare(left.val, right.val) <= 0) {
				current.next = left;
				left = left.next;
			} else {
				current.next = right;
				right = right.next;
			}
			current = current.next;
		}
		current.next = left == null ? right : left;
		return dummyHead.next;
	}

	// @Overloading the Method
	public Node<E> getMiddle(Node<E> node) {
		if (node == null) {
			return node;
		}
		Node<E> slow = node;
		Node<E> fast = node.next;
		while (fast != null) {
			fast = fast.next;
			if (fast != null) {
				slow = slow.next;
				fast = fast.next;
			}
		}
		return slow;
	}

	public void reverse() throws EmptyListException {
		if (head == null) {
			throw new EmptyListException("Cannot reverse an empty list.");
		}
		Node<E> res = null;
		Node<E> current = null;
		while (head != null) {
			current = head.next;
			head.next = res;
			res = head;
			head = current;
		}
		head = res;
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return head == null;
	}

	public void display(Node<E> head) throws EmptyListException {
		if (head == null) {
			throw new EmptyListException("Cannot display an empty list.");
		}

		Node<E> current = this.head;
		while (current != null) {
			System.out.print(current.val + " ");
			current = current.next;
		}
		System.out.println();
	}

	@Override
	public Iterator<E> iterator() {
		return new NodeIterator(head);
	}

	public int compare(E element1, E element2) {
		if (comparator == null) {
			return (((Comparable<E>) element1).compareTo(element2));
		} else {
			return comparator.compare(element1, element2);
		}
	}

}
