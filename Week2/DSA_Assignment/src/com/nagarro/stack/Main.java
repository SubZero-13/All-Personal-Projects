package com.nagarro.stack;

import java.util.Iterator;

public class Main {
	public static void main(String[] args) {
		System.out.println("Initializing An Integer Type Stack");
		MyStack<Integer> stack = new MyStack<>();

		try {
			System.out.println("Pushing 5 into the stack");
			stack.push(5);
			stack.traverse();
		} catch (Exception err) {
			System.out.print(err.getMessage());
		}

		try {
			System.out.println("Pushing 6 into the stack");
			stack.push(6);
			stack.traverse();
		} catch (Exception err) {
			System.out.print(err.getMessage());
		}

		try {
			System.out.println("Pushing 3 into the stack");
			stack.push(3);
			stack.traverse();
		} catch (Exception err) {
			System.out.print(err.getMessage());
		}

		try {
			System.out.println("Pushing 10 into the stack");
			stack.push(10);
			stack.traverse();
		} catch (Exception err) {
			System.out.print(err.getMessage());
		}

		try {
			System.out.println("Pushing 9 into the stack");
			stack.push(9);
			stack.traverse();
		} catch (Exception err) {
			System.out.print(err.getMessage());
		}

		try {
			System.out.println("Pop from stack");
			System.out.println("Poped Element: " + stack.pop());
			System.out.println();
			stack.traverse();
		} catch (Exception err) {
			System.out.print(err.getMessage());
		}

		try {
			System.out.println("Poped Element: " + stack.pop());
			System.out.println();
			stack.traverse();
		} catch (Exception err) {
			System.out.print(err.getMessage());
		}

		try {
			System.out.println("Check If Stack is Empty");
			System.out.println(stack.isEmpty());
			stack.traverse();
		} catch (Exception err) {
			System.out.print(err.getMessage());
		}

		try {
			System.out.println("Peek Element of Stack");
			System.out.println("Peek: " + stack.peek());
			System.out.println();
			stack.traverse();
		} catch (Exception err) {
			System.out.print(err.getMessage());
		}

		try {
			System.out.println("Reverse The Stack");
			stack.reverse();
			stack.traverse();
		} catch (Exception err) {
			System.out.print(err.getMessage());
		}

		try {
			System.out.println("Sorting the Stack");
			stack.sort();
			stack.traverse();
		} catch (Exception err) {
			System.out.print(err.getMessage());
		}

		try {
			System.out.println("Iterating through the Stack using an Iterator");
			Iterator iterate = stack.iterator();
			while (iterate.hasNext()) {
				System.out.println(iterate.next());
			}
			System.out.println();
		} catch (Exception err) {
			System.out.println(err.getMessage());
		}

		try {
			System.out.println("Iterating through the Stack using For Each Loop");
			for (Integer val : stack) {
				System.out.println(val);
			}
			System.out.println();
		} catch (Exception err) {
			System.out.println(err.getMessage());
		}
	}
}
