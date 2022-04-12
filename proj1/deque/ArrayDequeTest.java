package deque;

import org.junit.Test;
import static org.junit.Assert.*;

/** Performs some basic arraylist tests */

public class ArrayDequeTest {

    @Test
    /** Adds a few things to the list, checking isEmpty() and size() are correct,
     * finally printing the results.
     *
     * && is the "and" operation. */
    public void addIsEmptySizeTest() {

        System.out.println("Make sure to uncomment the lines below (and delete this print statement).");

        ArrayDeque<String> lal1 = new ArrayDeque<String>();

		assertTrue("A newly initialized LLDeque should be empty", lal1.isEmpty());
        lal1.addFirst("front");

		// The && operator is the same as "and" in Python.
		// It's a binary operator that returns true if both arguments true, and false otherwise.
        assertEquals(1, lal1.size());
        assertFalse("lld1 should now contain 1 item", lal1.isEmpty());

        lal1.addLast("middle");
		assertEquals(2, lal1.size());

        lal1.addLast("back");
		assertEquals(3, lal1.size());

		System.out.println("Printing out deque: ");
        lal1.printDeque();

    }
}
