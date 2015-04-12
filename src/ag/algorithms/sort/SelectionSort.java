package ag.algorithms.sort;

// N^2 in every cases (even if array has already sorted)
// N^2 / 2 - compares, N - changes
public class SelectionSort<T extends Comparable<T>> {
	
	public void sort(Comparable<T>[] elements) {
		for(int i = 0; i < elements.length; i ++) {
			int minElementPosition = i;
			Comparable<T> minElement = elements[i];
			
			for(int j = i + 1; j < elements.length; j++) {
				if(isLess(elements[j], minElement)) {
					minElement = elements[j];
					minElementPosition = j;
				}
			}

			swapElementsPositions(elements, minElementPosition, i);
		}
	}

	@SuppressWarnings("unchecked")
	private boolean isLess(Comparable<T> firstElement, Comparable<T> secondElement) {
		return firstElement.compareTo((T) secondElement) <= -1;
	}
	
	private void swapElementsPositions(Comparable<T>[] elements, int swapFrom, int swapTo) {
		Comparable<T> minElementValue = elements[swapTo];
		
		elements[swapTo] = elements[swapFrom];
		elements[swapFrom] = minElementValue;
	}
}
