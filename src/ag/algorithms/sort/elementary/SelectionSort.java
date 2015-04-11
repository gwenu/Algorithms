package ag.algorithms.sort.elementary;

// N^2 in every cases (even if array has already sorted)
// N^2 / 2 - compares, N - changes
public class SelectionSort<T extends Number> {
	
	private T[] elements;
	
	public SelectionSort(T[] elements) {
		this.elements = elements;
	}
	
	public void sort() {
		for(int i = 0; i < elements.length; i ++) {
			int minElementPosition = i;
			T minElement = elements[i];
			
			for(int j = i + 1; j < elements.length; j++) {
				if(isLess(elements[j], minElement)) {
					minElement = elements[j];
					minElementPosition = j;
				}
			}
			
			swapElementsPositions(minElementPosition, i);
		}
	}
	
	// It was maybe stupid idea to interact with non primitives. And yes it is awful implementation :(
	private boolean isLess(T firstElement, T secondElement) {
		boolean isLess = false;
		
		if(firstElement instanceof Integer |
				firstElement instanceof Short | firstElement instanceof Byte) {
			isLess = firstElement.intValue() < secondElement.intValue();
		} else if(firstElement instanceof Double 
				| firstElement instanceof Float) {
			isLess = firstElement.doubleValue() < secondElement.doubleValue();
		} else if(firstElement instanceof Long) {
			isLess = firstElement.longValue() < secondElement.longValue();
		}
		return isLess;
	}
	
	private void swapElementsPositions(int swapFrom, int swapTo) {
		T minElementValue = elements[swapTo];
		
		elements[swapTo] = elements[swapFrom];
		elements[swapFrom] = minElementValue;
	}
}
