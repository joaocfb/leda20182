package adt.linkedList;

public class SingleLinkedListImpl<T> implements LinkedList<T> {

	protected SingleLinkedListNode<T> head;

	public SingleLinkedListImpl() {
		this.head = new SingleLinkedListNode<T>();
	}

	@Override
	public boolean isEmpty() {
		if (this.head == null) {
			return true;
		}
		return false;
	}

	@Override
	public int size() {
		int contador = 0;
		while (this.head.getNext() != null) {
			contador++;
			this.head.getNext();
		}
		return contador;
	}

	@Override
	public T search(T element) {
		while (this.head.getNext() != null) {
			if (this.head.equals(element)) {
				return head.getData();
			}
			this.head.getNext();
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void insert(T element) {
		while (this.head.getNext() != null) {
			this.head.getNext();
		}
		this.head.setNext((SingleLinkedListNode<T>)element);
	}

	@Override
	public void remove(T element) {
		while(this.head.getNext() != null) {
			if (this.head.equals(element)) {
				this.head.setData(null);
				this.head.setNext(null);
			}
			this.head.getNext();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public T[] toArray() {
		T[] arrayRetorno = (T[]) new Object[this.size()];
		SingleLinkedListNode<T> elemento = this.head;
		int indexAtual = 0;
		
		while(this.head.getNext() != null) {
			if (elemento != null) {
				arrayRetorno[indexAtual] = (T) elemento.getData();
				indexAtual++;
				elemento.getNext();
			}
		}
		return arrayRetorno;
	}

	public SingleLinkedListNode<T> getHead() {
		return head;
	}

	public void setHead(SingleLinkedListNode<T> head) {
		this.head = head;
	}

}
