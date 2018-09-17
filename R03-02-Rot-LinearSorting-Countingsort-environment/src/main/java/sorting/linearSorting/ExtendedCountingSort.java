package sorting.linearSorting;

import sorting.AbstractSorting;

/**
 * Classe que implementa do Counting Sort vista em sala. Desta vez este
 * algoritmo deve satisfazer os seguitnes requisitos: - Alocar o tamanho minimo
 * possivel para o array de contadores (C) - Ser capaz de ordenar arrays
 * contendo numeros negativos
 */
public class ExtendedCountingSort extends AbstractSorting<Integer> {

	@Override
	public void sort(Integer[] array, int leftIndex, int rightIndex) {
		try {
			counting(array);
		} catch (Exception e) {
			e.getMessage();
		}
	}
	
	private void counting(Integer[] array) throws Exception {
		/*
		 * Checagem de tamanho do array passado lançando exceção caso seja vazio
		 */
		if (array.length == 0) {
			throw new Exception("Array vazio ou nulo");
		}
		int tamanhoArray = array.length;
		/*
		 * Encontra valor max e min para ser o tamanho do array de contagem
		 */
        int maiorValor = array[0]; 
        int menorValor = array[0];
        for (int i = 1; i < tamanhoArray; i++) {
            if (array[i] > maiorValor)
                maiorValor = array[i];
            if (array[i] < menorValor)
                menorValor = array[i];
        }
        int rangeContador = maiorValor - menorValor + 1;
        /*
         * Definindo array de contagem
         */
        int[] contador = new int[rangeContador];
        /*
         * Fazendo contagem de ocorrencias
         */
        for (int i = 0; i < tamanhoArray; i++)
            contador[array[i] - menorValor]++;
        /*
         *  Soma acumulativa
         */
        for (int i = 1; i < rangeContador; i++)
            contador[i] += contador[i - 1];
        /*
         * Modificando o array original de acordo com a contagem
         */
        int j = 0;
        for (int i = 0; i < rangeContador; i++)
            while (j < contador[i])
                array[j++] = i + menorValor;
    	}
	}
