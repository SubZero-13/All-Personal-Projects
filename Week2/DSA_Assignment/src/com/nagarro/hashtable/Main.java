package com.nagarro.hashtable;

import java.util.*;

public class Main {
	public static void main(String[] args) {

		System.out.println("Creating A HashMap");
		MyHashTable<String, Integer> map = new MyHashTable<>();
		System.out.println("Putting Key(Aman) and Value(18) in Map");
		try {
			map.put("Aman", 18);
			map.traverse();
		} catch (Exception exception) {
			System.out.println(exception.getMessage());
		}
		System.out.println("Putting Key(Shivam) and Value(21) in Map");
		try {
			map.put("Shivam", 21);
			map.traverse();
		} catch (Exception exception) {
			System.out.println(exception.getMessage());
		}

		System.out.println("Putting Key(Ayush) and Value(20) in Map");
		try {
			map.put("Ayush", 20);
			map.traverse();
		} catch (Exception exception) {
			System.out.println(exception.getMessage());
		}

		System.out.println("Putting Duplicate Key(Ayush) and Updated Value(23) in Map");
		try {
			map.put("Ayush", 23);
			map.traverse();
		} catch (Exception exception) {
			System.out.println(exception.getMessage());
		}

		System.out.println("Getting Value of Key(Aman) from the map");
		try {
			System.out.println(map.get("Aman"));
			map.traverse();
		} catch (Exception exception) {
			System.out.println(exception.getMessage());
		}

		System.out.println("Getting Value of Key(that does not exist) from the map");
		try {
			System.out.println(map.get("Ashish"));
			map.traverse();
		} catch (Exception exception) {
			System.out.println(exception.getMessage());
		}

		System.out.println("Checking If Key(Shivam) is present in Map");
		try {
			System.out.println(map.containsKey("Shivam"));
			map.traverse();
		} catch (Exception exception) {
			System.out.println(exception.getMessage());
		}

		System.out.println("Removing Key(Ayush) from The Map");
		try {
			map.remove("Ayush");
			map.traverse();
		} catch (Exception exception) {
			System.out.println(exception.getMessage());
		}

		System.out.println("Printing Size of The Map");
		try {
			System.out.println(map.size());
			map.traverse();
		} catch (Exception exception) {
			System.out.println(exception.getMessage());
		}

		System.out.println("Iterating Over Map");
		try {
			for (String key : map.keySet()) {
				System.out.println(key + " -> " + map.get(key));
			}
		} catch (Exception exception) {
			System.out.println(exception.getMessage());
		}

		System.out.println("HashTable using Iterator:");
		try {
			Iterator<String> iter = map.iterator();
			while (iter.hasNext()) {
				String key = iter.next();
				System.out.println(key + " --> " + map.get(key));
			}
		} catch (Exception exception) {
			System.out.println(exception.getMessage());
		}

		System.out.println("Printing Hash Table using For Each Loop of Iterator:");
		try {
			for (String key : map)
				System.out.println(key + " --> " + map.get(key));
		} catch (Exception exception) {
			System.out.println(exception.getMessage());
		}

	}

}
