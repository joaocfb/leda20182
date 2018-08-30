package vetor;

import java.util.Comparator;

/**
 * Implementação de um vetor de objetos simples para exercitar os conceitos de
 * Generics.
 * 
 * @author Adalberto
 *
 */
public class Vetor {

	// O array interno onde os objetos manipulados são guardados
	private Object[] arrayInterno;

	// O tamanho que o array interno terá
	private int tamanho;

	// Indice que guarda a proxima posição vazia do array interno
	private int indice;

	// O Comparators a serem utilizados
	private Comparator comparadorMaximo;
	private Comparator comparadorMinimo;

	public Vetor(int tamanho) {
		super();
		this.tamanho = tamanho;
		this.indice = -1;
	}

	public void setComparadorMaximo(Comparator comparadorMaximo) {
		this.comparadorMaximo = comparadorMaximo;
	}

	public void setComparadorMinimo(Comparator comparadorMinimo) {
		this.comparadorMinimo = comparadorMinimo;
	}

	// Insere um objeto no vetor
	public void inserir(Object o) {
		this.arrayInterno[this.indice++] = o;
	}

	// Remove um objeto do vetor
	public Object remover(Object o) {
		boolean found = false;
		int i = 0;
		while (!found || i < this.tamanho - 1) {
			if (this.arrayInterno[i].equals(o)) {
				this.arrayInterno[i] = this.arrayInterno[this.indice--];
				this.arrayInterno[this.indice] = null;
				found = true;
			} else {
				i++;
			}
		}
		return found;
	}

	// Procura um elemento no vetor
	public Object procurar(Object o) {
		Object objToReturn = null;
		for (Object object : arrayInterno) {
			if (object.equals(o)) {
				objToReturn = object;
			}
		}
		return objToReturn;
	}

	// Diz se o vetor está vazio
	public boolean isVazio() {
		if (this.indice == -1) {
			return true;
		} else return false;
	}

	// Diz se o vetor está cheio
	public boolean isCheio() {
		if (this.indice == this.tamanho - 1) {
			return true;
		} else return false;
	}

}
