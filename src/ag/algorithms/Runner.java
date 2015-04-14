package ag.algorithms;

import ag.algorithms.heap.BinaryHeap;
import ag.algorithms.queue.LinkedQueue;
import ag.algorithms.queue.StringQueueImplementable;
import ag.algorithms.sort.BottomUpMergeSort;
import ag.algorithms.sort.InsertionSort;
import ag.algorithms.sort.MergeSort;
import ag.algorithms.sort.QuickSort;
import ag.algorithms.sort.SelectionSort;
import ag.algorithms.sort.ShellSort;
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

		// Elementary sorts
		runner.runSelectionSort();
		runner.runInsertionSort();
		runner.runShellSort();
		runner.runMergeSort();
		runner.runBottomUpMergeSort();
		runner.runQuickSort();
		
		// Binary Heap
		runner.runBinaryHeap();
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
		Double[] elements = { 2.5, 1.2, 4.4, 2.2, 5.1 };

		SelectionSort<Double> selectionSort = new SelectionSort<Double>();
		selectionSort.sort(elements);

		printResultOfSortAlgorithms("[Selection Sort] Sorted array: ", elements);
	}

	private void runInsertionSort() {
		Double[] elements = { 2.5, 1.2, 4.4, 2.2, 5.1 };

		InsertionSort<Double> insertionSort = new InsertionSort<Double>();
		insertionSort.sort(elements);
		
		printResultOfSortAlgorithms("[Insertion Sort] Sorted array: ", elements);
	}

	private void runShellSort() {
		Double[] elements = { 2.5, 1.2, 4.4, 2.2, 5.1 };

		ShellSort<Double> shellSort = new ShellSort<Double>();
		shellSort.sort(elements);
		
		printResultOfSortAlgorithms("[Shell Sort] Sorted array: ", elements);
	}
	
	private void runMergeSort() {
		Double[] elements = { 2.5, 1.2, 4.4, 2.2, 5.1 };

		MergeSort<Double> mergeSort = new MergeSort<Double>();
		mergeSort.sort(elements, 0, 4);
		
		printResultOfSortAlgorithms("[Merge Sort] Sorted array: ", elements);
	}
	
	private void runBottomUpMergeSort() {
		Double[] elements = { 2.5, 1.2, 4.4, 2.2, 5.1 };

		BottomUpMergeSort<Double> bottomUpSort = new BottomUpMergeSort<Double>();
		bottomUpSort.sort(elements, 0, 4);
		
		printResultOfSortAlgorithms("[BottomUp Merge Sort] Sorted array: ", elements);
	}

	private void runQuickSort() {
		Double[] elements = { 2.5, 1.2, 4.4, 2.2, 5.1 };

		QuickSort<Double> quickSort = new QuickSort<Double>();
		quickSort.sort(elements);
		
		printResultOfSortAlgorithms("[Quick Sort] Sorted array: ", elements);
	}
	
	private void runBinaryHeap() {
		Integer[] elements = { 5, 1, 4, 8, 12, 3 };
		BinaryHeap<Integer> binaryHeap = new BinaryHeap<>(new Integer[10], 10);
		binaryHeap.insert(elements[0]);
		binaryHeap.insert(elements[1]);
		binaryHeap.insert(elements[2]);
		binaryHeap.insert(elements[3]);
		binaryHeap.insert(elements[4]);
		binaryHeap.insert(elements[5]);
		
		System.out.println("Binary heap: ");
		System.out.println(binaryHeap.toString());
		System.out.println("\nAfter delete max item: ");
		
		binaryHeap.deleteMax();
		System.out.println(binaryHeap.toString());
		
		System.out.println("\nAfter 2 delete max item: ");
		
		binaryHeap.deleteMax();
		System.out.println(binaryHeap.toString());
		
		System.out.println("\nAfter 3 delete max item: ");
		
		binaryHeap.deleteMax();
		System.out.println(binaryHeap.toString());
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
	
	@SuppressWarnings("unchecked")
	private <T> void printResultOfSortAlgorithms(String sortTitle, Comparable<T>[] elements) {
		System.out.println(sortTitle);

		for (Comparable<T> element : elements) {
			System.out.println(((T) element));
		}

		System.out.println("--------------------------");
	}
}
