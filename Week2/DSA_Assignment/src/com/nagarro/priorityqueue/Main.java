package com.nagarro.priorityqueue;

import java.util.Collections;
import java.util.Iterator;

import com.nagarro.queue.MyQueue;

public class Main {
	public static void main(String[] args) {
		System.out.println("Initializing A Integer Type Queue");
		MyPriorityQueue<Integer> queue = new MyPriorityQueue<>(Collections.reverseOrder());

		try {
			System.out.println("Enqueue 1 into the queue");
			queue.enQueue(1);
			queue.traverse();
			System.out.println();
		} catch (Exception exception) {
			System.out.println(exception.getMessage());
		}

		try {
			System.out.println("Enqueue 5 into the queue");
			queue.enQueue(5);
			queue.traverse();
			System.out.println();
		} catch (Exception exception) {
			System.out.println(exception.getMessage());
		}

		try {
			System.out.println("Enqueue 8 into the queue");
			queue.enQueue(8);
			queue.traverse();
			System.out.println();
		} catch (Exception exception) {
			System.out.println(exception.getMessage());
		}

		try {
			System.out.println("Enqueue 5 into the queue");
			queue.enQueue(5);
			queue.traverse();
			System.out.println();
		} catch (Exception exception) {
			System.out.println(exception.getMessage());
		}

		try {
			System.out.println("Enqueue 10 into the queue");
			queue.enQueue(10);
			queue.traverse();
			System.out.println();
		} catch (Exception exception) {
			System.out.println(exception.getMessage());
		}

		try {
			System.out.println("Dequeue from queue");
			System.out.println("Dequeued Element: " + queue.deQueue());
			System.out.println();
			queue.traverse();
			System.out.println();
		} catch (Exception exception) {
			System.out.println(exception.getMessage());
		}

		try {
			System.out.println("Dequeued Element: " + queue.deQueue());
			System.out.println();
			queue.traverse();
			System.out.println();
		} catch (Exception exception) {
			System.out.println(exception.getMessage());
		}

		try {
			System.out.println("Check If Queue is Empty");
			System.out.println(queue.isEmpty());
			queue.traverse();
			System.out.println();
		} catch (Exception exception) {
			System.out.println(exception.getMessage());
		}

		try {
			System.out.println("Peek Element of Queue");
			System.out.println("Peek: " + queue.peek());
			System.out.println();
			queue.traverse();
			System.out.println();
		} catch (Exception exception) {
			System.out.println(exception.getMessage());
		}

		try {
			System.out.println("Reverse The Priority Queue");
			queue.reverse();
			queue.traverse();
			System.out.println();
		} catch (Exception exception) {
			System.out.println(exception.getMessage());
		}

		try {
			System.out.println("Enqueue 15 into the queue");
			queue.enQueue(15);
			queue.traverse();
			System.out.println();
		} catch (Exception exception) {
			System.out.println(exception.getMessage());
		}

		try {
			System.out.println("Dequeue from queue");
			System.out.println("Dequeued Element: " + queue.deQueue());
			System.out.println();
			queue.traverse();
			System.out.println();
		} catch (Exception exception) {
			System.out.println(exception.getMessage());
		}

		try {
			System.out.println("Check if the queue contains 13 ");
			System.out.println(queue.contains(13));
			queue.traverse();
			System.out.println();
		} catch (Exception exception) {
			System.out.println(exception.getMessage());
		}

		try {
			System.out.println("Get the size of the queue");
			System.out.println(queue.size());
			queue.traverse();
			System.out.println();
		} catch (Exception exception) {
			System.out.println(exception.getMessage());
		}

		try {
			System.out.println("Get the center element of the queue");
			System.out.println(queue.center());
			queue.traverse();
			System.out.println();
		} catch (Exception exception) {
			System.out.println(exception.getMessage());
		}

		try {
			System.out.println("Iterating through the queue using an Iterator");
			Iterator iterate = queue.iterator();
			while (iterate.hasNext()) {
				System.out.print(iterate.next() + " ");
			}
			System.out.println();
		} catch (Exception exception) {
			System.out.println(exception.getMessage());
		}

		try {
			System.out.println("Iterating through the queue");
			Iterator iterator = queue.iterator();
			while (iterator.hasNext()) {
				System.out.print(iterator.next() + " ");
			}
			System.out.println();
		} catch (Exception exception) {
			System.out.println(exception.getMessage());
		}

		try {
			System.out.println("Dequeued Element: " + queue.deQueue());
			System.out.println();
			queue.traverse();
			System.out.println();
		} catch (Exception exception) {
			System.out.println(exception.getMessage());
		}
	}
}
