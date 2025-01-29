package uvg.edu;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.util.EmptyStackException;

public class PilaTest {
    private Pila<Integer> stack;

    @Before
    public void setUp() {
        stack = new Pila<>();
    }

    @Test
    public void testPush() {
        stack.push(1);
        assertEquals(1, stack.size());
        stack.push(2);
        assertEquals(2, stack.size());
    }

    @Test
    public void testPop() {
        stack.push(1);
        stack.push(2);
        int element = stack.pop();
        assertEquals(2, element);
        assertEquals(1, stack.size());
    }

    @Test(expected = EmptyStackException.class)
    public void testPopEmptyStack() {
        stack.pop();
    }

    @Test
    public void testIsEmpty() {
        assertTrue(stack.isEmpty());
        stack.push(1);
        assertFalse(stack.isEmpty());
    }

    @Test
    public void testSize() {
        assertEquals(0, stack.size());
        stack.push(1);
        assertEquals(1, stack.size());
        stack.push(2);
        assertEquals(2, stack.size());
    }
}