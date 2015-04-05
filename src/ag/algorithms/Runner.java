package ag.algorithms;

import ag.algorithms.stack.ArrayStack;
import ag.algorithms.stack.StringStackImplementable;
import ag.algorithms.stack.LinkedStack;

public class Runner {
	
	public static void main(String[] args) {
		Runner runner = new Runner();
		
		// Stack package [FIFO -> First In First Out]
		runner.runLinkedStack();
		runner.runArrayStack();
	}
	
	
	// Stack implementation: using private class emulate one-way linked elements
	private void runLinkedStack() {
		LinkedStack linkedStack = new LinkedStack();
		linkedStack.push("first");
		linkedStack.push("second");
		linkedStack.push("third");
		linkedStack.push("fourth");
		
		printResultOfStackApiMethods(linkedStack);
	}
	
	// Stack implementation: is used array for stack emulation
	private void runArrayStack() {
		ArrayStack arrayStack = new ArrayStack();
		arrayStack.push("first");
		arrayStack.push("second");
		arrayStack.push("third");
		arrayStack.push("fourth");
		
		printResultOfStackApiMethods(arrayStack);
	}
	
	private void printResultOfStackApiMethods(StringStackImplementable stack) {
		System.out.println("Instance: " + stack.getClass().getSimpleName());
		System.out.println("Pop 1: " + stack.pop());
		System.out.println("Pop 2: " + stack.pop());
		System.out.println("Pop 3: " + stack.pop());
		System.out.println("Pop 4: " + stack.pop());
		
		System.out.println("isEmpty: " + stack.isEmpty());
		System.out.println("--------------------------");
	}
}
