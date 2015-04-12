package ag.algorithms.sort;

// With 3 * x + 1 increments is O(N^(3 / 2))
public class ShellSort<T extends Comparable<T>> {

	public void sort(Comparable<T>[] elements) {
		int arrayLength = elements.length;
		int h = 1;

		while (h < arrayLength / 3) {
			h = 3 * h + 1; // 1, 4, 13, 40, 121, ...
		}

		// h-sort the array
		while (h >= 1) {
			for (int i = 0; i < arrayLength; i++) {
				for (int j = i; j >= h && isLess(elements[j], elements[j - h]); j -= h) {
					swapElementsPositions(elements, j, j - h);
				}
			}

			h = h / 3;
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
