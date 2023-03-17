package com.nagarro.queue;

import java.util.Iterator;

public class Main {
	public static void main(String[] args) {
		System.out.println("Initializing A String Type Queue");
		MyQueue<String> queue = new MyQueue<>();

		try {
			System.out.println("Enqueue 'Shivam' into the queue");
			queue.enQueue("Shivam");
			queue.traverse();
			System.out.println();
		} catch (Exception err) {
			System.out.println(err.getMessage());
		}

		try {
			System.out.println("Enqueue 'Ashish' into the queue");
			queue.enQueue("Ashish");
			queue.traverse();
			System.out.println();
		} catch (Exception err) {
			System.out.println(err.getMessage());
		}

		try {
			System.out.println("Enqueue 'Vaibhav' into the queue");
			queue.enQueue("Vaibhav");
			queue.traverse();
			System.out.println();
		} catch (Exception err) {
			System.out.println(err.getMessage());
		}

		try {
			System.out.println("Enqueue 'Srikar' into the queue");
			queue.enQueue("Srikar");
			queue.traverse();
			System.out.println();
		} catch (Exception err) {
			System.out.println(err.getMessage());
		}

		try {
			System.out.println("Enqueue 'Ayush' into the queue");
			queue.enQueue("Ayush");
			queue.traverse();
			System.out.println();
		} catch (Exception err) {
			System.out.println(err.getMessage());
		}

		try {
			System.out.println("Dequeue from queue");
			System.out.println("Dequeued Element: " + queue.deQueue());
			System.out.println();
			queue.traverse();
			System.out.println();
		} catch (Exception err) {
			System.out.println(err.getMessage());
		}

		try {
			System.out.println("Dequeued Element: " + queue.deQueue());
			System.out.println();
			queue.traverse();
			System.out.println();
		} catch (Exception err) {
			System.out.println(err.getMessage());
		}

		try {
			System.out.println("Check If Queue is Empty");
			System.out.println(queue.isEmpty());
			queue.traverse();
			System.out.println();
		} catch (Exception err) {
			System.out.println(err.getMessage());
		}

		try {
			System.out.println("Peek Element of Queue");
			System.out.println("Peek: " + queue.peek());
			System.out.println();
			queue.traverse();
			System.out.println();
		} catch (Exception err) {
			System.out.println(err.getMessage());
		}

		try {
			System.out.println("Reverse The Queue");
			queue.reverse();
			queue.traverse();
			System.out.println();
		} catch (Exception err) {
			System.out.println(err.getMessage());
		}

		try {
			System.out.println("Enqueue 'Om' into the queue");
			queue.enQueue("Om");
			queue.traverse();
			System.out.println();
		} catch (Exception err) {
			System.out.println(err.getMessage());
		}

		try {
			System.out.println("Sorting the Queue");
			queue.sort();
			queue.traverse();
			System.out.println();
		} catch (Exception err) {
			System.out.println(err.getMessage());
		}

		try {
			System.out.println("Check if the queue contains 'Ayush'");
			System.out.println(queue.contains("Ayush"));
			queue.traverse();
			System.out.println();
		} catch (Exception err) {
			System.out.println(err.getMessage());
		}

		try {
			System.out.println("Get the size of the queue");
			System.out.println(queue.size());
			queue.traverse();
			System.out.println();
		} catch (Exception err) {
			System.out.println(err.getMessage());
		}

		try {
			System.out.println("Get the center element of the queue");
			System.out.println(queue.center());
			queue.traverse();
			System.out.println();
		} catch (Exception err) {
			System.out.println(err.getMessage());
		}

		try {
			System.out.println("Iterating through the queue using an Iterator");
			Iterator iterate = queue.iterator();
			while (iterate.hasNext()) {
				System.out.print(iterate.next() + " ");
			}
			System.out.println();
		} catch (Exception err) {
			System.out.println(err.getMessage());
		}
		
		try {
			System.out.println("Iterating through the queue using For Each Loop");
			for(String val: queue) {
				System.out.print(val + " ");
			}
			System.out.println();
		} catch (Exception err) {
			System.out.println(err.getMessage());
		}
	}
}
