package sorting.variationsOfBubblesort;

import sorting.AbstractSorting;

/**
 * The combsort algoritm.
 */
public class CombSort<T extends Comparable<T>> extends AbstractSorting<T> {
	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		combSort(array);
	}
	
	private void combSort(T[] array) {
		int gap = array.length;
	    double fator = 1.25;
	    boolean troca = true;
	    int i;
	    while (gap != 1 || troca) {
	    	gap = (int) (gap / fator);
	        if (gap < 1)
	        	gap = 1;
	        i = 0;
	        troca = false;
	        while (i + gap < array.length) {
	        	if (array[ i ].compareTo(array[ i + gap ]) > 0) {
	        		util.Util.swap(array, i, i + gap);
	                	troca = true;
	               }
	               i++;
	          	}
	     	}
	     }
	}
