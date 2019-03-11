package problems;

/**
 * Calcula o floor e ceil de um numero em um array usando a estrategia de busca
 * binaria.
 * 
 * Restricoes: 
 * - Algoritmo in-place (nao pode usar memoria extra a nao ser variaveis locais) 
 * - O tempo de seu algoritmo deve ser O(log n).
 * 
 * @author Adalberto
 *
 */
public class FloorCeilBinarySearch implements FloorCeil {
	private static FloorCeilBinarySearch floorceil;
	@Override
	public Integer floor(Integer[] array, Integer x) {
		Integer floor = x;
		int menorDistancia = x;
		for (int i = 0; i < array.length; i++) {
			if (array[i].compareTo(x) <= 0) {
				if ((array[i] - x) == 0) {
					return array[i];
				} else if(x - array[i] < menorDistancia){
					menorDistancia = x - array[i];
					floor = array[i];
				}
				
			}
		}
		return floor;
	}
	
	private int buscamenorDistancia(Integer[] array, int inicio, int fim, int x){
		int distancia = x;
		for (int i = inicio; i < fim; i++) {
			if (array[i] - x < distancia) {
				distancia = array[i] - x;
			}
		}
		return distancia;
	}

	@Override
	public Integer ceil(Integer[] array, Integer x) {
		Integer ceil = x;
		int menorDistancia = x;
		for (int i = 0; i < array.length; i++) {
			if (array[i].compareTo(x) >= 0 ) {
				if (array[i] - x == 0) {
					return array[i];				}
				} 
				
				if(array[i] - x < menorDistancia) {
					menorDistancia = array[i] - x;
					if (menorDistancia < 0) menorDistancia = menorDistancia * (-1);
					ceil = array[i];
					
				}
		}
		return ceil;
	}
	

}
