package uvg.edu;

            import java.io.*;
            import java.nio.file.*;
            import java.util.*;

            /**
             * The App class is the entry point of the application.
             * It reads a file containing postfix expressions and evaluates them using a calculator.
             */
            public class App {
                /**
                 * The main method of the application.
                 *
                 * @param args Command line arguments (not used).
                 */
                public static void main(String[] args) {
                    // Create a new stack for integers
                    Pila<Integer> pila = new Pila<>();

                    // Create a new calculator with the stack
                    CalculadoraADT calculadora = new CalculadoraADT(pila);

                    // Path to the file containing postfix expressions
                    String ruta = "src/main/java/uvg/edu/datos.txt";

                    // Try-with-resources to ensure the BufferedReader is closed after use
                    try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
                        String linea;
                        // Read each line from the file
                        while ((linea = br.readLine()) != null) {
                            System.out.println("Contenido leído: " + linea);
                            // Evaluate the postfix expression and print the result
                            int resultado = calculadora.evaluarPostfix(linea);
                            System.out.println("Resultado: " + resultado);
                        }
                    } catch (IOException e) {
                        // Handle file reading errors
                        System.out.println("Error leyendo el archivo: " + e.getMessage());
                    } catch (Exception e) {
                        // Handle errors in expression evaluation
                        System.out.println("Error en la evaluación de la expresión: " + e.getMessage());
                    }
                }
            }