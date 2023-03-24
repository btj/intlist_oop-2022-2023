package intlist_oop;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class IntListTest {

	@Test
	void test() {
		int[] xs = {10, 20, 30};
		IntList myIntList = new IntList(xs);
		assertArrayEquals(new int[] {10, 20, 30}, myIntList.getElements());
		
		myIntList.add(40);
		assertArrayEquals(new int[] {10, 20, 30, 40}, myIntList.getElements());
		
		myIntList.removeLast();
		assertArrayEquals(new int[] {10, 20, 30}, myIntList.getElements());
	}

}
