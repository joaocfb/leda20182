package sorting.divideAndConquer;

import sorting.AbstractSorting;

/**
 * Merge sort is based on the divide-and-conquer paradigm. The algorithm
 * consists of recursively dividing the unsorted list in the middle, sorting
 * each sublist, and then merging them into one single sorted list. Notice that
 * if the list has length == 1, it is already sorted.
 */
public class MergeSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if (leftIndex < rightIndex) {
			int middleIndex = ((leftIndex + rightIndex) / 2);
			sort(array, leftIndex,middleIndex);
			sort(array, middleIndex + 1, rightIndex);
			mergeSort(array, leftIndex, middleIndex, rightIndex);
		}
		
	}

	private void mergeSort(T[] array, int firstIndex, int middleIndex, int lastIndex) {
		@SuppressWarnings("unchecked")
		T[] array_aux = ((T[]) new Object[array.length]);
		
		for (int i = firstIndex; i <= lastIndex; i++) {
			array_aux[i] = array[i];
		}
		
		int i = firstIndex;
		int j = middleIndex + 1;
		int k = firstIndex;
		
		while (i <= middleIndex && j <= lastIndex) {
			if (array_aux[i].compareTo(array_aux[j]) < 0 ) {
				util.Util.swap(array, k, i);
				i++;
			} else {
				util.Util.swap(array, k, j);
				j++;
			}
			k++;
		}
		
		while (i <= middleIndex) {
			array[k] = array_aux[i];
			util.Util.swap(array, k, i);
		}
		
		while(j <= lastIndex) {
			array[k] = array_aux[j];
			util.Util.swap(array, k, j);
		}
		
	}
}
