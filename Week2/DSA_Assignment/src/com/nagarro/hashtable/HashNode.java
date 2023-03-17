package com.nagarro.hashtable;

public class HashNode<K, V> {
	private K key;
	private V value;
	private HashNode<K, V> next;

	public HashNode(K key, V value) {
		this.key = key;
		this.value = value;
		this.next = null;
	}

	public K getKey() {
		return this.key;
	}

	public V getValue() {
		return this.value;
	}

	public HashNode<K, V> getNext() {
		return this.next;
	}

	public void setKey(K key) {
		this.key = key;
	}

	public void setValue(V value) {
		this.value = value;
	}

	public void setNext(HashNode<K, V> next) {
		this.next = next;
	}

}
