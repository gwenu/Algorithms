package ag.algorithms.heap;

// Insert, Delete: log N
// Get max element 1
// Array as a parameter - bad and temporary idea.
public class BinaryHeap<Key extends Comparable<Key>> {
	
	private Key[] heap;
	private int lastElement;
	
	public BinaryHeap(Key[] elements, int capacity) {
		this.heap = elements;
		this.lastElement = 0;
	}
	
	public void insert(Key element) {
		heap[lastElement] = element;
		swim(lastElement);
		
		lastElement++;
	}
	
	public Key deleteMax() {
		swap(0, lastElement - 1);
		
		Key deleted = heap[lastElement - 1];
		heap[lastElement - 1] = null;
		lastElement--;
		
		sink(0);
		
		return deleted;
	}
	
	public boolean isEmpty() {
		return lastElement == 0;
	}
	
	public int size() {
		return lastElement;
	}
 
	private void swim(int k) {
		int parentIndex = k / 2;
		
		while(isLess(heap[parentIndex], heap[k])) {
			swap(k, parentIndex);
			k = parentIndex;
			parentIndex = k / 2;
		}
	}
	
	private void sink(int k) {
		while(k < lastElement && isLess(heap[k], heap[getMaxChildIndex(k)])) {
			int swapTo = getMaxChildIndex(k);
			swap(k, swapTo);
			k = swapTo;
		}
	}
	
	private void swap(int swapFrom, int swapTo) {
		Key fromValue = heap[swapFrom];

		heap[swapFrom] = heap[swapTo];
		heap[swapTo] = fromValue;
	}
	
	private boolean isLess(Key firstElement, Key secondElement) {
		return firstElement.compareTo((Key) secondElement) <= -1;
	}
	
	private int getMaxChildIndex(int k) {
		int firstChild = 2 * k;
		int secondChild = 2 * k + 1;
		
		if(secondChild < lastElement && isLess(heap[firstChild], heap[secondChild])) {
			return secondChild;
		} 
		
		return firstChild >= lastElement ? k : firstChild;
	}
	
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();

		for (Key element : heap) {
			if (element != null)
				sb.append(element + " ");
		}

		return sb.toString();
	}
}
