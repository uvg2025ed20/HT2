package uvg.edu;

public class CalculadoraADT {
    private Pila<Integer> pila;

    public CalculadoraADT(Pila<Integer> pila) {
        this.pila = pila;
    }

    public int evaluarPostfix(String expresion) {
        String[] tokens = expresion.split(" ");
        for (String token : tokens) {
            if (esOperando(token)) {
                pila.push(Integer.parseInt(token));
            } else if (esOperador(token)) {
                int operandoB = pila.pop();
                int operandoA = pila.pop();
                int resultado = realizarOperacion(operandoA, operandoB, token);
                pila.push(resultado);
            }
        }
        return pila.pop();
    }

    private boolean esOperando(String token) {
        return token.matches("\\d+");
    }

    private boolean esOperador(String token) {
        return "+-*/%".contains(token);
    }

    private int realizarOperacion(int operandoA, int operandoB, String operador) {
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
