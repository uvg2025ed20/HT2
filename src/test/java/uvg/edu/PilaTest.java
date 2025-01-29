/**
 * Unit tests for the Pila class.
 *
 * This test class verifies the correct behavior of a generic stack implementation.
 * It ensures that elements are pushed and popped correctly, checks for empty stack
 * behavior, and validates size tracking.
 *
 * Integrantes:
 *  * - Pablo Vásquez
 *  * - Carlos López
 *  * - Angel Sanabria
 */
package uvg.edu;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.util.EmptyStackException;

/**
 * Test class for Pila.
 */
public class PilaTest {
    private Pila<Integer> stack;

    /**
     * Sets up a new stack before each test.
     */
    @Before
    public void setUp() {
        stack = new Pila<>();
    }

    /**
     * Tests the push operation by verifying the size increment after pushing elements.
     */
    @Test
    public void testPush() {
        stack.push(1);
        assertEquals(1, stack.size());
        stack.push(2);
        assertEquals(2, stack.size());
    }

    /**
     * Tests the pop operation by ensuring the last pushed element is retrieved and removed.
     */
    @Test
    public void testPop() {
        stack.push(1);
        stack.push(2);
        int element = stack.pop();
        assertEquals(2, element);
        assertEquals(1, stack.size());
    }

    /**
     * Tests that popping an empty stack throws an EmptyStackException.
     */
    @Test(expected = EmptyStackException.class)
    public void testPopEmptyStack() {
        stack.pop();
    }

    /**
     * Tests the isEmpty method by checking its response before and after adding elements.
     */
    @Test
    public void testIsEmpty() {
        assertTrue(stack.isEmpty());
        stack.push(1);
        assertFalse(stack.isEmpty());
    }

    /**
     * Tests the size method by verifying it accurately tracks the number of elements.
     */
    @Test
    public void testSize() {
        assertEquals(0, stack.size());
        stack.push(1);
        assertEquals(1, stack.size());
        stack.push(2);
        assertEquals(2, stack.size());
    }
}
