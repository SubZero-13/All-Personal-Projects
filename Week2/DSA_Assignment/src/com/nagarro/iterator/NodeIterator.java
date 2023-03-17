package com.nagarro.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

import com.nagarro.linkedlist.Node;

public class NodeIterator<E> implements Iterator<E> {

	private Node<E> current;

	public NodeIterator(Node<E> start) {
		current = start;
	}

	public boolean hasNext() {
		return current != null;
	}

	public E next() {
		E data = current.val;
		current = current.next;
		return data;
	}
}
