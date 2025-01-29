package uvg.edu;

import java.util.Vector;
import java.util.EmptyStackException;

public class Pila<T> implements IStack<T> {
    private Vector<T> elementos;

    public Pila() {
        elementos = new Vector<>();
    }

    @Override
    public void push(T item) {
        elementos.add(item);
    }

    @Override
    public T pop() throws EmptyStackException {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return elementos.remove(elementos.size() - 1);
    }

    @Override
    public T peek() throws EmptyStackException {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return elementos.get(elementos.size() - 1);
    }

    @Override
    public boolean isEmpty() {
        return elementos.isEmpty();
    }

    @Override
    public int size() {
        return elementos.size();
    }
}
