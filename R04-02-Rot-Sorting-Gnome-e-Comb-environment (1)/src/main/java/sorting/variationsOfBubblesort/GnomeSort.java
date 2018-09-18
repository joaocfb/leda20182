package sorting.variationsOfBubblesort;

import sorting.AbstractSorting;

/**
 * The implementation of the algorithm must be in-place!
 */
public class GnomeSort<T extends Comparable<T>> extends AbstractSorting<T> {
	
	public void sort(T[] array, int leftIndex, int rightIndex) {
		gnomeSort(array, leftIndex, rightIndex);
	}
	
	private void gnomeSort(T[] array, int leftIndex, int rightIndex) {
		int pivot = 0;
		
		while(pivot <= rightIndex) {
			if (pivot == 0) pivot++;
			if (array[pivot].compareTo(array[pivot - 1]) >= 0 ) {
				pivot++;
			} else {
				util.Util.swap(array, pivot, pivot - 1);
				pivot --;
			}
			
		}
		
		
	}
}
