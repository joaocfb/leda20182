package sorting.simpleSorting;

import sorting.AbstractSorting;

/**
 * The selection sort algorithm chooses the smallest element from the array and
 * puts it in the first position. Then chooses the second smallest element and
 * stores it in the second position, and so on until the array is sorted.
 */
public class SelectionSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		int menorInd = 0;
		for (int i = 0; i <= rightIndex; i++) {
			menorInd = i;
			for (int j = i + 1; j <= rightIndex; j++) {
				if (array[j].compareTo(array[menorInd]) ==  -1) {
					menorInd = j;
				}
			}
			util.Util.swap(array, i, menorInd);
		}
	}
}
