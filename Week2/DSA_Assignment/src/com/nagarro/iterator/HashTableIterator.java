package com.nagarro.iterator;

import java.util.Iterator;

import com.nagarro.hashtable.*;

public class HashTableIterator<K, V> implements Iterator<K> {
	private int currentIndex = -1;
	private HashNode<K, V> currentNode = null;
	HashNode<K, V> table[];

	public HashTableIterator(HashNode<K, V> table[]) {
		this.table = table;
	}

	@Override
	public boolean hasNext() {
		if (currentNode != null && currentNode.getNext() != null) {
			return true;
		}
		for (int i = currentIndex + 1; i < table.length; i++) {
			if (table[i] != null) {
				return true;
			}
		}
		return false;
	}

	public K next() {
		if (currentNode != null && currentNode.getNext() != null) {
			currentNode = currentNode.getNext();
		} else {
			do {
				currentIndex++;
				if (currentIndex >= table.length) {
					throw new java.util.NoSuchElementException();
				}
				currentNode = table[currentIndex];
			} while (currentNode == null);
		}
		return currentNode.getKey();
	}
}
