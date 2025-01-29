package uvg.edu;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.io.IOException;

/**
 * Unit tests for the {@link CalculadoraADT} class.
 * This test class ensures that the calculator correctly evaluates postfix expressions,
 * handles file reading properly, and manages exceptions correctly.
 *
 * Integrantes:
 *  * - Pablo Vásquez
 *  * - Carlos López
 *  * - Angel Sanabria
 */
public class CalculadoraADTTest {
    private CalculadoraADT calculadora;
    String ruta = "src/main/java/uvg/edu/datos.txt";

    /**
     * Initializes a new instance of {@link CalculadoraADT} before each test.
     */
    @Before
    public void setUp() {
        calculadora = new CalculadoraADT();
    }

    /**
     * Tests whether the calculator correctly evaluates a postfix expression from a file.
     *
     * @throws IOException If there is an error reading the file.
     */
    @Test
    public void testEvaluateExpression() throws IOException {
        calculadora.readFromFile(ruta);
        int result = calculadora.evaluateExpression();
        assertEquals(41, result); // Assuming the expression in datos.txt evaluates to 41
    }

    /**
     * Tests if an exception is thrown when evaluating an expression without loading one first.
     *
     * @throws IllegalStateException Expected if no expression is set.
     */
    @Test(expected = IllegalStateException.class)
    public void testEvaluateExpressionNoExpression() {
        calculadora.evaluateExpression();
    }

    /**
     * Tests if the calculator correctly reads an expression from a file.
     *
     * @throws IOException If there is an error reading the file.
     */
    @Test
    public void testReadFromFile() throws IOException {
        calculadora.readFromFile(ruta);
        assertNotNull(calculadora.getExpresion()); // Ensures the expression was successfully loaded
    }

    /**
     * Tests if an {@link IOException} is thrown when trying to read a non-existent file.
     *
     * @throws IOException Expected if the file is not found.
     */
    @Test(expected = IOException.class)
    public void testReadFromFileIOException() throws IOException {
        calculadora.readFromFile("datos.txt");
    }
}
