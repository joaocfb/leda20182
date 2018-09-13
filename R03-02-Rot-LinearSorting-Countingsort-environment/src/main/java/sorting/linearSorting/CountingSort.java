package sorting.linearSorting;

import sorting.AbstractSorting;

/**
 * Classe que implementa a estratégia de Counting Sort vista em sala. Procure
 * evitar desperdicio de memoria alocando o array de contadores com o tamanho
 * sendo o máximo inteiro presente no array a ser ordenado.
 * 
 */
public class CountingSort extends AbstractSorting<Integer> {

	@Override
	public void sort(Integer[] array, int leftIndex, int rightIndex) {
		
	}

	private void counting(Integer[] array, int rightIndex) {
		int maiorValor = 0;
		
		
		for (int i = 0; i <= rightIndex; i++) {
			if (array[i] > maiorValor) {
				maiorValor = array[i];
			}
		}
		
		Integer[] array_aux = new Integer[rightIndex];
		Integer[] contador =  new Integer[maiorValor];
		
		for (int i = 0; i < contador.length; i++) {
			contador[i] = 0;
		}
		
		for (int k = 0; k < array.length; k++) {
			contador[array[k]] ++;
		}
		
		for (int j = 1; j < contador.length; j++) {
			contador[j] += contador[j - 1];
		}
		
		for (int i = 0; i < array_aux.length; i++) {
			contador[array[i]]--; 
			array_aux[contador[array[i]]] = array[i];
		}
		
	}
}
