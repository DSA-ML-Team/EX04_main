package de.unistuttgart.vis.dsass2021.ex04.p2;

import static org.junit.Assert.*;
import org.junit.Test;

public class CircularLinkedListTest {
	@Test
	public void testCircular() {
		CircularLinkedList<String> myActivity = new CircularLinkedList<String>();
		myActivity.append("sleep");
		myActivity.append("cook");
		myActivity.append("eat");
		myActivity.append("study");
		myActivity.append("gaming");
		myActivity.append("workout");
		System.out.println( "size of instance is:");
		assertEquals( myActivity.size(), 6);
		System.out.println(myActivity.size());
		System.out.println("\nmost important thing of me is:");
		System.out.println(myActivity.getHead().getElement());
		System.out.println( "then i do something like:" );
		System.out.println( myActivity.get(2) );
		System.out.println( myActivity.get(9));
		System.out.println( myActivity.get(-1));
		assertEquals("workout", myActivity.get(-1) );
	}

}
