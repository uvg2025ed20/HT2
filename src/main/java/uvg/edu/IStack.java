package uvg.edu;

    import java.util.EmptyStackException;

    /**
     * Interface for a generic stack.
     * @param <T> The type of elements stored in the stack.
     * Integrantes:
     *  * - Pablo Vásquez
     *  * - Carlos López
     *  * - Angel Sanabria
     */
    public interface IStack<T> {

        /**
         * Adds an element to the top of the stack.
         * @param element The element to add.
         */
        void push(T element);

        /**
         * Removes and returns the element at the top of the stack.
         * @return The element removed from the top of the stack.
         * @throws EmptyStackException If the stack is empty.
         */
        T pop() throws EmptyStackException;

        /**
         * Returns the element at the top of the stack without removing it.
         * @return The element at the top of the stack.
         * @throws EmptyStackException If the stack is empty.
         */
        T peek() throws EmptyStackException;

        /**
         * Checks if the stack is empty.
         * @return true if the stack is empty, false otherwise.
         */
        boolean isEmpty();

        /**
         * Returns the number of elements in the stack.
         * @return The number of elements in the stack.
         */
        int size();
    }