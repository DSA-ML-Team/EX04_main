package de.unistuttgart.vis.dsass2021.ex04.p2;

public class LinkedListNode<T extends Comparable<T>> implements ILinkedListNode<T>{

	

	T element;
	public ILinkedListNode<T> next;
	public ILinkedListNode<T> previous;


	@Override
	public T getElement() {
		return this.element;
	}

	@Override
	public void setElement(T element) {
		this.element = element;
	}

	@Override
	public ILinkedListNode<T> getNext() {
		return this.next;
	}

	@Override
	public void setNext(ILinkedListNode<T> next) {
		this.next = next;
	}

	@Override
	public ILinkedListNode<T> getPrev(){
		return this.previous;
	}

	@Override
	public void setPrev(ILinkedListNode<T> prev) {
		this.previous = prev;
	}
	
	public  LinkedListNode( T element, ILinkedListNode<T>next, ILinkedListNode<T> previous ) {
		this.setElement(element);
		this.setNext(next);
		this.setPrev(previous);
	}
	

}
