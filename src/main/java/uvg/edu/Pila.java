package uvg.edu;

import java.util.Vector;
import java.util.EmptyStackException;

/**
 * The Pila class implements a generic stack using a Vector.
 *
 * @param <T> The type of elements stored in the stack.
 */
public class Pila<T> implements IStack<T> {
    private Vector<T> elementos;

    /**
     * Constructs an empty stack.
     */
    public Pila() {
        elementos = new Vector<>();
    }

    /**
     * Adds an element to the top of the stack.
     *
     * @param item The element to add.
     */
    @Override
    public void push(T item) {
        elementos.add(item);
    }

    /**
     * Removes and returns the element at the top of the stack.
     *
     * @return The element removed from the top of the stack.
     * @throws EmptyStackException If the stack is empty.
     */
    @Override
    public T pop() throws EmptyStackException {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return elementos.remove(elementos.size() - 1);
    }

    /**
     * Checks if the stack is empty.
     *
     * @return true if the stack is empty, false otherwise.
     */
    @Override
    public boolean isEmpty() {
        return elementos.isEmpty();
    }

    /**
     * Returns the number of elements in the stack.
     *
     * @return The number of elements in the stack.
     */
    @Override
    public int size() {
        return elementos.size();
    }
}