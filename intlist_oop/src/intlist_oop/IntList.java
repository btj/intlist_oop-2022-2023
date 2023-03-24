package intlist_oop;

import java.util.Arrays;
import java.util.stream.IntStream;

// Procedure for defining a data abstraction (= defining its API)
//
// 0. Declare the class and write a line of informal documentation
//
// 1. Define the raw abstract state space =
//    declare the getters/inspectors (= name and return type)
//
// 2. Define the set of valid abstract states =
//    write down the abstract state invariants
//
// 3. Declare and document the constructors, factory methods and mutators

/**
 * Each instance of this class stores a sequence of int values.
 * 
 * @invar | getElements() != null
 */
public class IntList {
	
	private class Node {
		private int value;
		private Node next;
		
		Node(int value, Node next) { this.value = value; this.next = next; }
	}
	
	/**
	 * @invar | 0 <= size
	 * @invar | size == 0 ? head == null : getNodes()[size - 1] != null && getNodes()[size - 1].next == null
	 */
	private Node head;
	private int size;
	
	/**
	 * @representationObjects
	 */
	private Node[] getNodes() {
		Node[] result = new Node[size];
		int i = 0;
		for (Node n = head; n != null; n = n.next)
			result[i++] = n;
		return result;
	}
	
	/**
	 * @creates | result
	 */
	public int[] getElements() {
		int[] result = new int[size];
		int i = 0;
		for (Node n = head; n != null; n = n.next)
			result[i++] = n.value;
		return result;
	}
	
	/**
	 * @throws IllegalArgumentException | elements == null
	 * @inspects | elements
	 * @post The sequence of elements stored in this object equals the given sequence of elements.
	 *      | Arrays.equals(this.getElements(), elements)
	 */
	public IntList(int[] elements) {
		if (elements == null)
			throw new IllegalArgumentException("`elements` is null");
		
		Node n = null;
		for (int i = elements.length - 1; 0 <= i; i--)
			n = new Node(elements[i], n);
		head = n;
		size = elements.length;
	}

	/**
	 * @mutates | this
	 * @post | getElements().length == old(getElements().length) + 1
	 * @post | IntStream.range(0, old(getElements().length)).allMatch(i ->
	 *       |     getElements()[i] == old(getElements())[i])
	 * @post | getElements()[getElements().length - 1] == element
	 */
	public void add(int element) {
		if (head == null) {
			head = new Node(element, null);
			size = 1;
		} else {
			Node n = head;
			while (n.next != null)
				n = n.next;
			n.next = new Node(element, null);
			size++;
		}
	}
	
	/**
	 * @throws IllegalStateException | getElements().length == 0
	 * @mutates | this
	 * @post | getElements().length == old(getElements().length) - 1
	 * @post | Arrays.equals(getElements(), 0, getElements().length,
	 *       |     old(getElements()), 0, getElements().length)
	 */
	public void removeLast() {
		if (head == null)
			throw new IllegalStateException("The IntList object is empty");
		
		if (head.next == null) {
			head = null;
			size = 0;
		} else {
			Node n = head;
			while (n.next.next != null)
				n = n.next;
			n.next = null;
			size--;
		}
	}
	
}
