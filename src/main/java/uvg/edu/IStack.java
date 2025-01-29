package uvg.edu;

import java.util.EmptyStackException;

/**
 * Interfaz para una pila genérica.
 * @param <T> Tipo de elementos almacenados en la pila.
 */
public interface IStack<T> {
    
    /**
     * Agrega un elemento a la cima de la pila.
     * @param element Elemento a agregar.
     */
    void push(T element);
    
    /**
     * Elimina y devuelve el elemento en la cima de la pila.
     * @return Elemento eliminado.
     * @throws EmptyStackException Si la pila está vacía.
     */
    T pop() throws EmptyStackException;

    /**
     * Devuelve el elemento en la cima de la pila sin eliminarlo.
     * @return Elemento en la cima.
     * @throws EmptyStackException Si la pila está vacía.
     */
    T peek() throws EmptyStackException;
    
    /**
     * Verifica si la pila está vacía.
     * @return true si la pila está vacía, false en caso contrario.
     */
    boolean isEmpty();
    
    /**
     * Devuelve el número de elementos en la pila.
     * @return Cantidad de elementos en la pila.
     */
    int size();
}
