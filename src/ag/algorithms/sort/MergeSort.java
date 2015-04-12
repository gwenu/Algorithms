package ag.algorithms.sort;

public class MergeSort<T extends Comparable<T>> {
	
	private Comparable<T>[] array;

	public void sort(Comparable<T>[] elements, int firstElement, int lastElement) {
		this.array = elements;
		doMergeSort(firstElement, lastElement);
	}

	private void doMergeSort(int firstElement, int lastElement) {
		if (firstElement < lastElement) {
			int midElement = firstElement + (lastElement - firstElement) / 2;
			
			doMergeSort(firstElement, midElement);
			doMergeSort(midElement + 1, lastElement);
			
			merge(array, firstElement, midElement, lastElement);
		}
	}

	@SuppressWarnings("unchecked")
	private void merge(Comparable<T>[] elements, int firstElement, int midElement, int lastElement) {
		Comparable<T>[] helperArray = elements.clone();

		int i = firstElement;
		int j = midElement + 1;
		int k = firstElement;

		while (i <= midElement && j <= lastElement) {
			if (helperArray[i].compareTo((T) helperArray[j]) >= 1) {
				elements[k] = helperArray[j];
				j++;
			} else {
				elements[k] = helperArray[i];
				i++;
			} 
			
			k++;
		}

		while (i <= midElement) {
			elements[k] = helperArray[i];
			k++;
			i++;
		}
	}
}
