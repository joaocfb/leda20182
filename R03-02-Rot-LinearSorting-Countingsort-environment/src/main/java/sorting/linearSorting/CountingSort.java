package sorting.linearSorting;
import sorting.AbstractSorting;

/**
 * Classe que implementa a estratÃ©gia de Counting Sort vista em sala. Procure
 * evitar desperdicio de memoria alocando o array de contadores com o tamanho
 * sendo o mÃ¡ximo inteiro presente no array a ser ordenado.
 * 
 */
public class CountingSort extends AbstractSorting<Integer> {

	@Override
	public void sort(Integer[] array, int leftIndex, int rightIndex) {
		try {
			counting(array);
		} catch (Exception e) {
			
			e.getMessage();
		}
	}
/*
 * Método privado que faz todo o processo de counting sort
 */
	private void counting(Integer[] array) throws Exception {
		/*
		 * Checagem de tamanho do array passado lançando exceção caso seja vazio
		 */
		if (array.length == 0) {
			throw new Exception("Array vazio ou nulo");
		}
		/*
		 * Valor usado para ser o tamanho do array de contagem
		 */
		    int maiorValor = array[0];
		    for (int i = 1; i < array.length; i++) {
		    	if (array[i] > maiorValor) {
		    		maiorValor = array[i];
		    	}
		    }
		/*
		 * Definindo array auxiliar para ser usado localmente para manipulação
		 * Definindo array de contagem
		 */
		Integer[] array_aux = new Integer[array.length];
		Integer[] contador =  new Integer[maiorValor + 1];
		/*
		 * Setando array de contagem com valores 0
		 */
		for (int i = 0; i < contador.length; i++) {
			contador[i] = 0;
		}
		/*
		 * Fazendo contagem
		 */
		for (int k = 0; k < array.length; k++) {
			++contador[array[k]];
		}
		/*
		 * Soma acumulativa para set de posições no array principal
		 */
		for (int j = 1; j <= contador.length - 1; j++) {
			contador[j] += contador[j - 1];
		}
		/*
		 * Setando array secundário 
		 */
		for (int i = array_aux.length - 1; i >= 0; i--) {
			array_aux[contador[array[i]] - 1] = array[i];
			--contador[array[i]]; 
		}
		/*
		 * Setando array principal baseado no secundário
		 */
		for (int i = 0; i < array.length; i++) {
			array[i] = array_aux[i];
		}
	}
}
