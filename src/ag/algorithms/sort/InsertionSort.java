package ag.algorithms.sort;

// 1 / 4 * N^2 compares and exchanges
// If array has already sorted in acs order: N - 1
// Bad case (If array has already sorted in desc order and no duplicates): 1 /2 * N^2
public class InsertionSort<T extends Comparable<T>> {

	public void sort(Comparable<T>[] elements) {
		int arrayLength = elements.length;

		for (int i = 0; i < arrayLength; i++) {
			for (int j = i + 1; j > 0 && j < arrayLength; --j) {
				if (isLess(elements[j], elements[i])) {
					swapElementsPositions(elements, i, j);
				} else {
					break;
				}
			}
		}
	}

	@SuppressWarnings("unchecked")
	private boolean isLess(Comparable<T> firstElement,
			Comparable<T> secondElement) {
		return firstElement.compareTo((T) secondElement) <= -1;
	}

	private void swapElementsPositions(Comparable<T>[] elements, int swapTo,
			int swapFrom) {
		Comparable<T> minElementValue = elements[swapFrom];

		elements[swapFrom] = elements[swapTo];
		elements[swapTo] = minElementValue;
	}
}
