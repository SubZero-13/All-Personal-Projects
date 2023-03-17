/**

A hash table implementation that maps keys to values.

@param <K> The type of the key

@param <V> The type of the value
*/

package com.nagarro.hashtable;

//Package Import starts Here
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.nagarro.exceptions.KeyNotFoundException;
import com.nagarro.exceptions.NullKeyException;
import com.nagarro.exceptions.UnderFlowException;
import com.nagarro.iterator.*;
// Package Import Ends Here

public class MyHashTable<K, V> implements Iterable<K> {

	private static final int DEFAULT_CAPACITY = 16;
	private static final float DEFAULT_LOAD_FACTOR = 0.75f;

	private HashNode<K, V>[] table;
	private int size;
	private float loadFactor;
	private int threshold;

	public MyHashTable() {
		this(DEFAULT_CAPACITY, DEFAULT_LOAD_FACTOR);
	}

	public MyHashTable(int initialCapacity, float loadFactor) {
		table = new HashNode[initialCapacity];
		size = 0;
		this.loadFactor = loadFactor;
		threshold = (int) (initialCapacity * loadFactor);
	}

	/**
	 * 
	 * Associates the specified value with the specified key in this hash table.
	 * 
	 * @param key   The key
	 * @param value The value to be associated with the key
	 * @throws NullKeyException If the key is null
	 */

	public void put(K key, V value) throws NullKeyException {
		if (key == null) {
			throw new NullKeyException("Key cannot be null");
		}
		int index = getIndex(key);
		HashNode<K, V> newNode = new HashNode<>(key, value);
		if (table[index] == null) {
			table[index] = newNode;
		} else {
			HashNode<K, V> current = table[index];
			while (current.getNext() != null) {
				if (current.getKey().equals(key)) {
					current.setValue(value);
					return;
				}
				current = current.getNext();
			}
			if (current.getKey().equals(key)) {
				current.setValue(value);
				return;
			} else {
				current.setNext(newNode);
			}
		}
		size++;
		if (size >= threshold) {
			resize();
		}
	}

	/**
	 * 
	 * Returns the value to which the specified key is mapped, or null if this hash
	 * table contains no mapping for the key.
	 * 
	 * @param key The key
	 * @return The value mapped to the key, or null if the key is not present
	 * @throws KeyNotFoundException If the key is not present in the hash table
	 */

	public V get(K key) throws KeyNotFoundException {
		if (key == null) {
			return null;
		}
		int index = getIndex(key);
		HashNode<K, V> current = table[index];
		while (current != null) {
			if (current.getKey().equals(key)) {
				return current.getValue();
			}
			current = current.getNext();
		}
		throw new KeyNotFoundException("Key is not Present");
	}

	/**
	 * 
	 * Returns true if this hash table contains a mapping for the specified key.
	 * 
	 * @param key The key
	 * @return true if the hash table contains a mapping for the key, false
	 *         otherwise
	 */

	public boolean containsKey(K key) {
		if (key == null) {
			return false;
		}
		int index = getIndex(key);
		HashNode<K, V> current = table[index];
		while (current != null) {
			if (current.getKey().equals(key)) {
				return true;
			}
			current = current.getNext();
		}
		return false;
	}

	public int size() {
		return size;
	}

	private int getIndex(K key) {
		int hashCode = key.hashCode();
		return Math.abs(hashCode % table.length);
	}

	/**
	 * The resize() method is used to increase the capacity of the hash table when
	 * the number of elements stored in it exceeds a certain threshold.
	 * 
	 * @throws NullKeyException
	 */

	/**
	 * The remove(K key) method is used to remove a key-value pair from the hash
	 * table based on the key provided.
	 * 
	 * @throws NullKeyException
	 */
	private void resize() throws NullKeyException {
		int newCapacity = table.length * 2;
		List<HashNode<K, V>> nodes = new ArrayList<>();
		for (HashNode<K, V> node : table) {
			while (node != null) {
				nodes.add(node);
				node = node.getNext();
			}
		}

		table = new HashNode[newCapacity];
		size = 0;
		threshold = (int) (newCapacity * loadFactor);
		for (HashNode<K, V> node : nodes) {
			put(node.getKey(), node.getValue());
		}
	}

	public void remove(K key) throws KeyNotFoundException {
		int index = getIndex(key);
		HashNode<K, V> prev = null;
		HashNode<K, V> curr = table[index];
		while (curr != null) {
			if (curr.getKey().equals(key)) {
				if (prev == null) {
					table[index] = curr.getNext();
				} else {
					prev.setNext(curr.getNext());
				}
				size--;
				return;
			}
			prev = curr;
			curr = curr.getNext();
		}

		throw new KeyNotFoundException("Key is not Prsent");
	}

	public void traverse() throws UnderFlowException {
		if (size == 0) {
			throw new UnderFlowException("Hash Table is Empty");
		}
		for (int index = 0; index < table.length; index++) {
			HashNode<K, V> temp = table[index];
			while (temp != null) {
				System.out.println(temp.getKey() + " --> " + temp.getValue());
				temp = temp.getNext();
			}
		}
	}

	public ArrayList<K> keySet() throws UnderFlowException {
		if (size == 0) {
			throw new UnderFlowException("Hash Table is Empty");
		}

		ArrayList<K> keys = new ArrayList<>();
		for (int index = 0; index < table.length; index++) {
			HashNode<K, V> temp = table[index];
			while (temp != null) {
				keys.add(temp.getKey());
				temp = temp.getNext();
			}
		}
		return keys;
	}

	@Override
	public Iterator<K> iterator() {
		return new HashTableIterator(table);
	}
}
