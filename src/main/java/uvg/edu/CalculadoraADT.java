package uvg.edu;

import java.io.*;
import java.util.Stack;

/**
 * The CalculadoraADT class provides methods to evaluate postfix expressions.
 * Implements the IPostfixCalculator interface.
 */
public class CalculadoraADT implements IPostfixCalculator {
    private Stack<Double> pila;
    private String expresion; // Store the current postfix expression

    /**
     * Constructs a new CalculadoraADT with the specified stack.
     */
    public CalculadoraADT() {
        this.pila = new Stack<>();
    }

    /**
     * Reads postfix expressions from a file and evaluates them.
     *
     * @param path The path to the file containing postfix expressions.
     * @throws IOException If an error occurs while reading the file.
     */
    @Override
    public void readFromFile(String path) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String linea;
            // Read the first line from the file to set the expression
            if ((linea = br.readLine()) != null) {
                this.expresion = linea;
                System.out.println("Contenido leído: " + this.expresion);
            }
        } catch (IOException e) {
            throw new IOException("Error leyendo el archivo: " + e.getMessage());
        }
    }

    /**
     * Evaluates the stored postfix expression and returns the result.
     *
     * @return The result of the evaluation.
     * @throws IllegalArgumentException If an unknown operator is encountered.
     * @throws ArithmeticException If a division by zero occurs.
     */
    @Override
    public double evaluateExpression() throws IllegalArgumentException {
        if (expresion == null || expresion.isEmpty()) {
            throw new IllegalStateException("No hay expresión para evaluar");
        }

        String[] tokens = expresion.split(" ");
        for (String token : tokens) {
            if (esOperando(token)) {
                pila.push(Double.parseDouble(token));
            } else if (esOperador(token)) {
                double operandoB = pila.pop();
                double operandoA = pila.pop();
                double resultado = realizarOperacion(operandoA, operandoB, token);
                pila.push(resultado);
            }
        }
        return pila.pop();
    }

    /**
     * Checks if the given token is an operand.
     *
     * @param token The token to check.
     * @return True if the token is an operand, false otherwise.
     */
    private boolean esOperando(String token) {
        return token.matches("\\d+(\\.\\d+)?"); // Matches integers and decimals
    }

    /**
     * Checks if the given token is an operator.
     *
     * @param token The token to check.
     * @return True if the token is an operator, false otherwise.
     */
    private boolean esOperador(String token) {
        return "+-*/%".contains(token);
    }

    /**
     * Performs the specified operation on two operands.
     *
     * @param operandoA The first operand.
     * @param operandoB The second operand.
     * @param operador The operator to apply.
     * @return The result of the operation.
     * @throws IllegalArgumentException If an unknown operator is encountered.
     * @throws ArithmeticException If a division by zero occurs.
     */
    private double realizarOperacion(double operandoA, double operandoB, String operador) {
        switch (operador) {
            case "+":
                return operandoA + operandoB;
            case "-":
                return operandoA - operandoB;
            case "*":
                return operandoA * operandoB;
            case "/":
                if (operandoB == 0) {
                    throw new ArithmeticException("División por cero");
                }
                return operandoA / operandoB;
            case "%":
                return operandoA % operandoB;
            default:
                throw new IllegalArgumentException("Operador desconocido: " + operador);
        }
    }
}
