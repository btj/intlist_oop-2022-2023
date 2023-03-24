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
	
	/**
	 * @creates | result
	 */
	public int[] getElements() { throw new RuntimeException("Not yet implemented"); }
	
	/**
	 * @throws IllegalArgumentException | elements == null
	 * @inspects | elements
	 * @post The sequence of elements stored in this object equals the given sequence of elements.
	 *      | Arrays.equals(this.getElements(), elements)
	 */
	public IntList(int[] elements) { throw new RuntimeException("Not yet implemented"); }

	/**
	 * @mutates | this
	 * @post | getElements().length == old(getElements().length) + 1
	 * @post | IntStream.range(0, old(getElements().length)).allMatch(i ->
	 *       |     getElements()[i] == old(getElements())[i])
	 * @post | getElements()[getElements().length - 1] == element
	 */
	public void add(int element) { throw new RuntimeException("Not yet implemented"); }
	
	/**
	 * @throws IllegalStateException | getElements().length == 0
	 * @mutates | this
	 * @post | getElements().length == old(getElements().length) - 1
	 * @post | Arrays.equals(getElements(), 0, getElements().length,
	 *       |     old(getElements()), 0, getElements().length)
	 */
	public void removeLast() { throw new RuntimeException("Not yet implemented"); }
	
}
