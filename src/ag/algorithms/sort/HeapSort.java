package ag.algorithms.sort;

// Worst case: N log N
// In place. But not stable and not often used.
public class HeapSort<T extends Comparable<T>> {

	public void sort(Comparable<T>[] elements) {
		int arrayLength = elements.length - 1;

		for (int i = arrayLength / 2; i >= 0; i--) {
			sink(elements, i, arrayLength);
		}

		int cursor = 0;
		while (arrayLength > 1) {
			swap(elements, cursor++, arrayLength--);
			sink(elements, cursor, arrayLength);
		}
	}

	private void sink(Comparable<T>[] elements, int k, int arrayLength) {
		while (k < arrayLength && isLess(elements[k], elements[getMaxChildIndex(elements, k)])) {
			int swapTo = getMaxChildIndex(elements, k);
			swap(elements, k, swapTo);
			k = swapTo;
		}
	}

	private void swap(Comparable<T>[] elements, int swapFrom, int swapTo) {
		Comparable<T> fromValue = elements[swapFrom];

		elements[swapFrom] = elements[swapTo];
		elements[swapTo] = fromValue;
	}

	@SuppressWarnings("unchecked")
	private boolean isLess(Comparable<T> elements, Comparable<T> elements2) {
		return elements.compareTo((T) elements2) <= -1;
	}

	private int getMaxChildIndex(Comparable<T>[] elements, int k) {
		int firstChild = 2 * k;
		int secondChild = 2 * k + 1;
		int lastElement = elements.length;

		if (secondChild < lastElement
				&& isLess(elements[firstChild], elements[secondChild])) {
			return secondChild;
		}

		return firstChild >= lastElement ? k : firstChild;
	}
}
