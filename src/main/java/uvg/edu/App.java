package uvg.edu;
import java.io.*;
import java.nio.file.*;
import java.util.*;

public class App {
    public static void main(String[] args) {
        Pila<Integer> pila = new Pila<>();
        CalculadoraADT calculadora = new CalculadoraADT(pila);
        String ruta = "src/main/java/uvg/edu/datos.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                System.out.println("Contenido leído: " + linea);
                int resultado = calculadora.evaluarPostfix(linea);
                System.out.println("Resultado: " + resultado);
            }
        } catch (IOException e) {
            System.out.println("Error leyendo el archivo: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error en la evaluación de la expresión: " + e.getMessage());
        }
    }
}
