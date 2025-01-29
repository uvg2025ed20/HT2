package uvg.edu;

            /**
             * The CalculadoraADT class provides methods to evaluate postfix expressions.
             */
            public class CalculadoraADT {
                private Pila<Integer> pila;

                /**
                 * Constructs a new CalculadoraADT with the specified stack.
                 *
                 * @param pila The stack to be used for evaluation.
                 */
                public CalculadoraADT(Pila<Integer> pila) {
                    this.pila = pila;
                }

                /**
                 * Evaluates a postfix expression.
                 *
                 * @param expresion The postfix expression to evaluate.
                 * @return The result of the evaluation.
                 * @throws IllegalArgumentException If an unknown operator is encountered.
                 * @throws ArithmeticException If a division by zero occurs.
                 */
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

                /**
                 * Checks if the given token is an operand.
                 *
                 * @param token The token to check.
                 * @return True if the token is an operand, false otherwise.
                 */
                private boolean esOperando(String token) {
                    return token.matches("\\d+");
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