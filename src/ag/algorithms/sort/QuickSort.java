package ag.algorithms.sort;

// Average: 1.39 * N log N
// Worst case: 1 / 2 * N ^ 2
// Improvements: for small arrays (N <= 10 for example) better to add if-case and use Insertion sort 
public class QuickSort<T extends Comparable<T>> {

	public void sort(Comparable<T>[] elements) {
		// Here should be shuffle
		sortArray(elements, 0, elements.length - 1);
	}
	
	private void sortArray(Comparable<T>[] elements, int first, int last) {
		if(last <= first) return;
		
		int j = partition(elements, first, last);
		sortArray(elements, first, j - 1);
		sortArray(elements, j + 1, last);
	}
	
	private int partition(Comparable<T>[] elements, int firstElement, int lastElement) {
		int i = firstElement + 1;
		int j = lastElement;
		
		while(true) {
			if(isLess(elements[i], elements[firstElement])){
				if(i == lastElement) break;
				i++;
			}
			
			if(isLess(elements[firstElement], elements[j])) {
				if(j == firstElement) break;
				j--;
			}
			
			if(i >= j) break;
			
			swapElementsPositions(elements, i, j);
		}
		
		swapElementsPositions(elements, firstElement, j);
		
		return j;
	}
	
	@SuppressWarnings("unchecked")
	private boolean isLess(Comparable<T> firstElement, Comparable<T> secondElement) {
		return firstElement.compareTo((T) secondElement) <= -1;
	}

	private void swapElementsPositions(Comparable<T>[] elements, int swapTo,int swapFrom) {
		Comparable<T> minElementValue = elements[swapFrom];

		elements[swapFrom] = elements[swapTo];
		elements[swapTo] = minElementValue;
	}
}
