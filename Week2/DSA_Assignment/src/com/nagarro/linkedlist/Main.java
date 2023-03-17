package com.nagarro.linkedlist;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		LinkedList<Integer> l = new LinkedList<>();
		try {
			MyLinkedList<Integer> list = new MyLinkedList<>();
			System.out.println("Adding 1 in Empty list");
			list.add(1);
			list.display(list.getHead());
			System.out.println("Adding 2 in the list");
			list.add(2);
			list.display(list.getHead());
			System.out.println("Adding 3 from the begining of the list");
			list.addFirst(3);
			list.display(list.getHead());
			System.out.println("Adding 4 from the last");
			list.addLast(4);
			list.display(list.getHead());
			System.out.println("Adding 5 at the index 3 in the list");
			list.addAtIndex(5, 3);
			list.display(list.getHead());
			System.out.println("Adding 7, 6, 2, and 12 in the list");
			list.add(7);
			list.add(6);
			list.add(2);
			list.add(12);
			list.display(list.getHead());
			System.out.println("Removing Element from the begining of the list");
			list.removeFirst();
			list.display(list.getHead());
			System.out.println("Removing Element from the last of the list");
			System.out.println(list.removeLast());
			list.display(list.getHead());
			System.out.println("Removing Element at Index 4");
			list.remove(4);
			list.display(list.getHead());
			System.out.println("printing Middle Element of List");
			System.out.println(list.getMiddle());
			list.display(list.getHead());
			System.out.println("Sorting The List");
			System.out.println("List Before Sorting");
			list.display(list.getHead());
			System.out.println("List After Sorting");
			list.sort();
			list.display(list.getHead());
			System.out.println("Reversing The List");
			list.reverse();
			list.display(list.getHead());
			System.out.println("Iterating through List Using Iterator");
			Iterator<Integer> iterator = list.iterator();
			while (iterator.hasNext())
				System.out.print(iterator.next() + " ");

			System.out.println();
			
			System.out.println("Iterating through for ech loop of Iterator");
			for(int val: list)
				System.out.print(val + " ");

			System.out.println();

		} catch (Exception exception) {
			System.out.print(exception.getMessage());
		}
	}
}
