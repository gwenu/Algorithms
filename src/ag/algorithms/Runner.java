package ag.algorithms;

import ag.algorithms.queue.LinkedQueue;
import ag.algorithms.queue.StringQueueImplementable;
import ag.algorithms.sort.elementary.SelectionSort;
import ag.algorithms.stack.ArrayStack;
import ag.algorithms.stack.LinkedStack;
import ag.algorithms.stack.StringStackImplementable;

public class Runner {
	
	private static final String FIRST_STRING = "first";
	private static final String SECOND_STRING = "second";
	private static final String THIRD_STRING = "third";
	private static final String FOURTH_STRING = "fourth";
	
	public static void main(String[] args) {
		Runner runner = new Runner();
		
		// Stack package [LIFO -> Last In First Out]
		runner.runLinkedStack();
		runner.runArrayStack();
		
		// Queue package [FIFO -> First In First Out]
		runner.runLinkedQueue();
		
		// Selection sort
		runner.runSelectionSort();
	}
	
	
	// Stack implementation: using private class emulate one-way linked elements
	private void runLinkedStack() {
		LinkedStack linkedStack = new LinkedStack();
		linkedStack.push(FIRST_STRING);
		linkedStack.push(SECOND_STRING);
		linkedStack.push(THIRD_STRING);
		linkedStack.push(FOURTH_STRING);
		
		printResultOfStackApiMethods(linkedStack);
	}
	
	// Stack implementation: is used array for stack emulation
	private void runArrayStack() {
		ArrayStack arrayStack = new ArrayStack();
		arrayStack.push(FIRST_STRING);
		arrayStack.push(SECOND_STRING);
		arrayStack.push(THIRD_STRING);
		arrayStack.push(FOURTH_STRING);
		
		printResultOfStackApiMethods(arrayStack);
	}
	
	private void runLinkedQueue() {
		LinkedQueue queue = new LinkedQueue();
		queue.enqueue(FIRST_STRING);
		queue.enqueue(SECOND_STRING);
		queue.enqueue(THIRD_STRING);
		queue.enqueue(FOURTH_STRING);
		
		printResultOfQueueApiMethods(queue);
	}
	
	private void runSelectionSort() {
		Double[] elements = {2.5, 1.2, 4.4};
		
		SelectionSort<Double> selectionSort = new SelectionSort<Double>(elements);
		selectionSort.sort();
		
		System.out.println("Sorted array: ");
		
		for(Double element : elements) {
			System.out.println(element.doubleValue());
		}
		
		System.out.println("--------------------------");
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
	
	private void printResultOfQueueApiMethods(StringQueueImplementable queue) {
		System.out.println("Instance: " + queue.getClass().getSimpleName());
		System.out.println("Dequeue 1: " + queue.dequeue());
		System.out.println("Dequeue 2: " + queue.dequeue());
		System.out.println("Dequeue 3: " + queue.dequeue());
		System.out.println("Dequeue 4: " + queue.dequeue());
		
		System.out.println("isEmpty: " + queue.isEmpty());
		System.out.println("--------------------------");
	}
}
