package uvg.edu;

import java.io.*;

/**
 * The App class is the entry point of the application.
 * It reads a file containing postfix expressions and evaluates them using a calculator.
 * Integrantes:
 *  * - Pablo Vásquez
 *  * - Carlos López
 *  * - Angel Sanabria
 */
public class App {
    /**
     * The main method of the application.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        // Create a new calculator instance (implements IPostfixCalculator)
        IPostfixCalculator calculadora = new CalculadoraADT();

        // Path to the file containing postfix expressions
        String ruta = "src/main/java/uvg/edu/datos.txt";

        try {
            calculadora.readFromFile(ruta);

        } catch (IOException e) {
            // Handle file reading errors
            System.out.println("Error leyendo el archivo: " + e.getMessage());
        } catch (IllegalArgumentException | ArithmeticException e) {
            // Handle errors in expression evaluation
            System.out.println("Error en la evaluación de la expresión: " + e.getMessage());
        }
    }
}
