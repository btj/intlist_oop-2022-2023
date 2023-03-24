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

// Procedure for implementing a data abstraction
//
// 1. Declare the fields and indicate which are the representation objects of 'this'
//    = define the raw concrete state space
//             = the values of the fields and the states of the representation objects
//
// 2. Define the set of valid concrete states
//    = write down the representation invariants
//
// 3. Define the mapping from concrete states to abstract states =
//    = implement the inspectors
//    Should satisfy the property that valid concrete states are mapped to valid abstract states
//
// 4. Implement the constructors, factory methods, and mutators

/**
 * Each instance of this class stores a sequence of int values.
 * 
 * @invar | getElements() != null
 */
public class IntList {
	
	/**
	 * @invar | elements != null
	 * 
	 * @representationObject
	 */
	private int[] elements;
	
	/**
	 * @creates | result
	 */
	public int[] getElements() { return elements.clone(); }
	
	/**
	 * @throws IllegalArgumentException | elements == null
	 * @inspects | elements
	 * @post The sequence of elements stored in this object equals the given sequence of elements.
	 *      | Arrays.equals(this.getElements(), elements)
	 */
	public IntList(int[] elements) {
		if (elements == null)
			throw new IllegalArgumentException("`elements` is null");
		this.elements = elements.clone();
	}

	/**
	 * @mutates | this
	 * @post | getElements().length == old(getElements().length) + 1
	 * @post | IntStream.range(0, old(getElements().length)).allMatch(i ->
	 *       |     getElements()[i] == old(getElements())[i])
	 * @post | getElements()[getElements().length - 1] == element
	 */
	public void add(int element) {
		elements = Arrays.copyOf(elements, elements.length + 1);
		elements[elements.length - 1] = element;
	}
	
	/**
	 * @throws IllegalStateException | getElements().length == 0
	 * @mutates | this
	 * @post | getElements().length == old(getElements().length) - 1
	 * @post | Arrays.equals(getElements(), 0, getElements().length,
	 *       |     old(getElements()), 0, getElements().length)
	 */
	public void removeLast() {
		if (elements.length == 0)
			throw new IllegalStateException("The IntList object is empty");
		
		elements = Arrays.copyOf(elements, elements.length - 1);
	}
	
}
