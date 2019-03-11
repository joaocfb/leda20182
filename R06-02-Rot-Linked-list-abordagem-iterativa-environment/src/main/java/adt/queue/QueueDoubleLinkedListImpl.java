package adt.queue;

import adt.linkedList.DoubleLinkedList;
import adt.linkedList.DoubleLinkedListImpl;
import adt.linkedList.DoubleLinkedListNode;

public class QueueDoubleLinkedListImpl<T> implements Queue<T> {

	protected DoubleLinkedList<T> list;
	protected int size;

	public QueueDoubleLinkedListImpl(int size) {
		this.size = size;
		this.list = new DoubleLinkedListImpl<T>();
	}

	@Override
	public void enqueue(T element) throws QueueOverflowException {
		if (list.size() == this.size)
	         throw new QueueOverflowException();
	      if (element != null) {
	         list.insert(element);
	         this.size++;
	      }
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		if (list.size() == 0)
	         throw new QueueUnderflowException();
	      DoubleLinkedListNode<T> element = (DoubleLinkedListNode<T>) list;
	      while (element.getNext() != null)
	         element.getNext();
	      list.removeLast();
	      this.size--;
	      return element.getData();
	}

	@Override
	public T head() {
		 if (list.size() == 0)
	         return null;
	      DoubleLinkedListNode<T> element = (DoubleLinkedListNode<T>) list;
	      while (element.getNext() != null)
	         element.getNext();
	      return element.getData();
	}

	@Override
	public boolean isEmpty() {
		  if (list.size() == 0) {
		         return true;
		         }
		  return false;
	}

	@Override
	public boolean isFull() {
		if (list.size() == this.size) {
			return true;
		}
		return false;
	}

}
