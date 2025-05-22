package modelo;

import java.util.Stack;

public class CeldaFormula extends Celda {
    
    public CeldaFormula(String contenido, Matriz matriz) {
        super(contenido);
    }
    
    @Override
    public String getValor() {
        try {
            String formula = contenido.substring(1).trim(); // Elimina el signo =
            return calcularFormula(formula);
        } catch (Exception e) {
            return "#ERROR";
        }
    }
    
    private String calcularFormula(String formula) {
        try {
            String[] caracteresFormula = formula.split("(?<=[-+*/()])|(?=[-+*/()])");
            
            for (int i = 0; i < caracteresFormula.length; i++) { // Elimina espacios en blanco
                caracteresFormula[i] = caracteresFormula[i].trim();
            }
            
            double resultado = evaluarExpresion(caracteresFormula);
            
            if (resultado == (int) resultado) {
                return String.valueOf((int) resultado);
            } else {
                return String.valueOf(resultado);
            }
        } catch (Exception e) {
            return "#ERROR";
        }
    }
    
    private double evaluarExpresion(String[] caracteresFormula) {
        Stack<Double> valores = new Stack<>();
        Stack<String> operadores = new Stack<>();
        
        for (String token : caracteresFormula) {
            if (token.isEmpty()) continue;
            
            if (esNumero(token)) {
                valores.push(Double.parseDouble(token));
            } else if (token.equals("(")) {
                operadores.push(token);
            } else if (token.equals(")")) {
                while (!operadores.isEmpty() && !operadores.peek().equals("(")) {
                    calcularOperacion(valores, operadores);
                }
                if (!operadores.isEmpty() && operadores.peek().equals("(")) {
                    operadores.pop(); // Elimina paréntesis izquierdo
                }
            } else if (esOperador(token)) {
                while (!operadores.isEmpty() && precedencia(operadores.peek()) >= precedencia(token)) {
                    calcularOperacion(valores, operadores);
                }
                operadores.push(token);
            }
        }
        
        while (!operadores.isEmpty()) {
            calcularOperacion(valores, operadores);
        }
        
        return valores.pop();
    }
    
    private boolean esNumero(String token) {
        try {
            Double.parseDouble(token);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
    private boolean esOperador(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    }
    
    private int precedencia(String operador) {
        if (operador.equals("+") || operador.equals("-")) {
            return 1;
        } else if (operador.equals("*") || operador.equals("/")) {
            return 2;
        } else {
            return 0;
        }
    }
    
    private void calcularOperacion(Stack<Double> valores, Stack<String> operadores) {
        String operador = operadores.pop();
        double b = valores.pop();
        double a = valores.pop();
        
        switch (operador) {
            case "+":
                valores.push(a + b);
                break;
            case "-":
                valores.push(a - b);
                break;
            case "*":
                valores.push(a * b);
                break;
            case "/":
                if (b == 0) {
                    throw new ArithmeticException("División por cero");
                }
                valores.push(a / b);
                break;
        }
    }
}