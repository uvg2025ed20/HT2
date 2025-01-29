package uvg.edu;
import java.io.IOException;

/**
 * Interface for a Postfix Calculator.
 */
public interface IPostfixCalculator {

    /**
     * Reads a postfix expression from a file.
     *
     * @param path The path to the file containing the postfix expression.
     * @throws IOException If an I/O error occurs while reading the file.
     */
    void readFromFile(String path) throws IOException;

    /**
     * Evaluates the postfix expression.
     *
     * @return The result of the evaluation.
     * @throws IllegalArgumentException If the expression is invalid.
     */
    int evaluateExpression() throws IllegalArgumentException;
}