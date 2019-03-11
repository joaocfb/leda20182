package adt.stack;

import adt.linkedList.DoubleLinkedList;
import adt.linkedList.DoubleLinkedListImpl;
import adt.linkedList.DoubleLinkedListNode;

public class StackDoubleLinkedListImpl<T> implements Stack<T> {

	protected DoubleLinkedList<T> top;
	protected int size;

	public StackDoubleLinkedListImpl(int size) {
		this.size = size;
		this.top = new DoubleLinkedListImpl<T>();
	}

	@Override
	public void push(T element) throws StackOverflowException {
		if (top.size() == this.size) {
			throw new StackOverflowException();
		}
		if (element != null) {
			top.insert(element);
			this.size++;
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public T pop() throws StackUnderflowException {
		if (top.size() == 0) {
			throw new StackUnderflowException();
		}
		DoubleLinkedListNode<T> elemento = (DoubleLinkedListNode<T>) top;
		top.removeFirst();
		this.size--;
		return elemento.getData();
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public T top() {
		if (top.size() == 0) {
			return null;
		}
		DoubleLinkedListNode<T> elemento = (DoubleLinkedListNode<T>) top;
		return elemento.getData();
	}

	@Override
	public boolean isEmpty() {
		if (top.size() == 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean isFull() {
		if (top.size() == this.size) {
			return true;
		}
		return false;
	}

}
