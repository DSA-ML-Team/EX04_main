package de.unistuttgart.vis.dsass2021.ex04.p2;


public class CircularLinkedList<T extends Comparable<T>> implements ICircularLinkedList<T> {
	
	public static int size = 0;
	private ILinkedListNode<T> head ;
	
	
	public CircularLinkedList(){
		head =  new LinkedListNode<T>( null, null, null);
	}   
	
	private boolean isTail( ILinkedListNode<T> node) {
		if( node.getNext() == head.getNext() & node != head) {return true;}
		else if( head.getNext() == node ) {return false;}
		else {return false;}
	}
	
	@Override
	public void append(T element) {
		ILinkedListNode<T> node = new LinkedListNode<T>( null, null, null );
		node.setElement(element);
		if( head.getNext() == null) { 		

			head.setNext( node );
		}
		else if ( head.getNext() != null && head.getNext().getNext() == null) {
		
			ILinkedListNode<T> first = head.getNext();
			first.setNext( node );
			first.setPrev( node);
			node.setNext( first );
			node.setPrev(first);
		}
		
		else {
			ILinkedListNode<T> first = head.getNext();
			ILinkedListNode<T> tail = first.getPrev();
			tail.setNext( node );
			first.setPrev( node );
			node.setPrev(tail);
			node.setNext(first);
		}

	}
		
	

	@Override
	public T get(int index) {
		T result = null;
		ILinkedListNode<T> current = null; 
		size = size();
		//so we can avoid some trouble, cause there is no first and tail
		//if we only have one node
		if( size == 1) {result = ( getHead() ).getElement() ;}
		else if( size > 1){
			//loop forward
			current = getHead();
			if( index >= 0 ) {
				for ( int i = 0 ; i <index ; i++){
					current = current.getNext();
				}
			}
			//loop backwards
			else if ( index <0 ) {
				for ( int i = 0; i > index; i--){
					current = current.getPrev();
				}
			}
			result = current.getElement();
			
		}
		return result;
	}
	// if we put this in else if (size >1){ }
	// then we can have a speedlink like property.
	// though its not explicit required in assignment.
	/*if( index < size/2 ) {
				current = getHead();
				for( int i = 0; i < index; i++ ) {
					current = current.getNext();
				}
				result = current.getElement();			
			}
	
			else if( index >= size/2 ) {
				current = ( getHead().getPrev());
				for(int i = size; i > index ; i--) {
					current = current.getPrev();
				}
				result = current.getElement();
			}*/
	
	
	@Override
	public int size() {
		ILinkedListNode<T> current = head;
		int count = 0 ;
		while( (current.getNext() != null) & (isTail( current ) == false ) ) {
			current = current.getNext();
			count = count + 1;
		}
		return count;
	}

	@Override
	public ILinkedListNode<T> getHead() {
		ILinkedListNode<T> node = head.getNext();
		return node;
	}

}



