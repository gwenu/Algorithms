package ag.algorithms.sort;

//N log N
// No recursion
public class BottomUpMergeSort<T extends Comparable<T>> {
	
	public void sort(Comparable<T>[] elements, int firstElement, int lastElement) {
		int arrayLength = elements.length;
		
		for(int i = 1; i < arrayLength; i = i + i) {
			for(int j = 0; j < arrayLength; j += i + i) {
				int mid = j + i - 1;
				int last = Math.min(j + i + i -1, arrayLength - 1);
				
				if(mid < last) {
					merge(elements, j, mid, last);
				}
			}
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
