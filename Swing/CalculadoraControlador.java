import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class CalculadoraControlador implements ActionListener {
    
    private CalculadoraVista vista;
    private CalculadoraMotor motor;
    
    // Variables para mantener el estado de la calculadora
    private double numero1 = 0;
    private String operador = "";
    private boolean nuevaOperacion = true;

    public CalculadoraControlador(CalculadoraVista vista, CalculadoraMotor motor) {
        this.vista = vista;
        this.motor = motor;
        
        // El controlador se suscribe a los eventos de la vista
        this.vista.agregarListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Averiguar qué botón se presionó
        JButton botonPresionado = (JButton) e.getSource();
        String comando = botonPresionado.getText();

        // Lógica de ruteo según el botón
        if (comando.matches("[0-9]")) { // Si es un número (Expresión Regular)
            manejarNumero(comando);
        } else if (comando.equals("C")) {
            manejarLimpiar();
        } else if (comando.equals("=")) {
            manejarIgual();
        } else if (comando.equals("π")) {
            // Caso especial para Pi: borra la pantalla y escribe el valor de Pi
            vista.setTextoPantalla(String.valueOf(Math.PI));
            nuevaOperacion = true;
        } else if (comando.matches("√|sin|cos|tan|x²|log|ln|e\\^x|10\\^x|1/x|n!")) { 
            // Operadores unarios (de cálculo inmediato)
            manejarOperadorUnario(comando);
        } else if (comando.matches("\\+|-|\\*|/|%|x\\^y")) { 
            // Operadores binarios (requieren dos números y darle al "=")
            manejarOperador(comando);
        }
    }

    private void manejarNumero(String num) {
        if (nuevaOperacion) {
            vista.setTextoPantalla(num);
            nuevaOperacion = false;
        } else {
            vista.setTextoPantalla(vista.getTextoPantalla() + num);
        }
    }

    private void manejarOperador(String op) {
        try {
            numero1 = Double.parseDouble(vista.getTextoPantalla());
            operador = op;
            nuevaOperacion = true;
        } catch (NumberFormatException ex) {
            // Ignorar si la pantalla está vacía
        }
    }

    private void manejarOperadorUnario(String op) {
        try {
            double numeroActual = Double.parseDouble(vista.getTextoPantalla());
            double resultado = motor.calcularUnario(numeroActual, op);
            
            // Formatear para no mostrar .0 si es entero
            if (resultado == (long) resultado) {
                vista.setTextoPantalla(String.format("%d", (long) resultado));
            } else {
                vista.setTextoPantalla(String.valueOf(resultado));
            }
            nuevaOperacion = true;
        } catch (NumberFormatException ex) {
            vista.setTextoPantalla("Error");
        }
    }

    private void manejarIgual() {
        if (!operador.isEmpty() && !nuevaOperacion) {
            try {
                double numero2 = Double.parseDouble(vista.getTextoPantalla());
                // Delegamos el cálculo al Modelo
                double resultado = motor.calcular(numero1, numero2, operador);
                
                // Formatear para no mostrar .0 si es entero
                if(resultado == (long) resultado) {
                    vista.setTextoPantalla(String.format("%d", (long)resultado));
                } else {
                    vista.setTextoPantalla(String.valueOf(resultado));
                }
                
            } catch (ArithmeticException ex) {
                vista.setTextoPantalla("Error");
            }
            nuevaOperacion = true;
            operador = ""; // Reiniciar operador
        }
    }

    private void manejarLimpiar() {
        vista.setTextoPantalla("");
        numero1 = 0;
        operador = "";
        nuevaOperacion = true;
    }
}