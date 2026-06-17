public class CalculadoraMotor {
    
    public double calcular(double numero1, double numero2, String operador) throws ArithmeticException {
        switch (operador) {
            case "+": return numero1 + numero2;
            case "-": return numero1 - numero2;
            case "*": return numero1 * numero2;
            case "/": 
                if (numero2 == 0) throw new ArithmeticException("División por cero");
                return numero1 / numero2;
            default: return 0;
        }
    }
}