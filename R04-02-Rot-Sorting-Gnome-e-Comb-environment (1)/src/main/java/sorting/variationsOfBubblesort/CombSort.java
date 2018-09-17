package sorting.variationsOfBubblesort;

import sorting.AbstractSorting;

/**
 * The combsort algoritm.
 */
public class CombSort<T extends Comparable<T>> extends AbstractSorting<T> {
	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		
	}
	
	private void combSort(T[] array) {
		double fator = 1.25;
		int gap = (int) (array.length/fator);
		int i = 0;
		while(i < array.length - 1) {
			while(i + gap < array.length - 1) {
				if (array[i].compareTo(array[i + gap]) > 0) {
					util.Util.swap(array, i, i + gap);
				}
			}
		}
	}
}
