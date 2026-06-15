public class CalculadoraMotor {
    
    // Operaciones binarias (dos números)
    public double calcular(double numero1, double numero2, String operador) throws ArithmeticException {
        switch (operador) {
            case "+": return numero1 + numero2;
            case "-": return numero1 - numero2;
            case "*": return numero1 * numero2;
            case "/":
                if (numero2 == 0) throw new ArithmeticException("División por cero");
                return numero1 / numero2;
            case "%": return numero1 * (numero2 / 100.0);
            case "x^y": return Math.pow(numero1, numero2); // Nueva potencia libre
            default: return 0;
        }
    }

    // Operaciones unarias (un solo número)
    public double calcularUnario(double numero, String operador) {
        switch (operador) {
            case "√": return Math.sqrt(numero);
            case "sin": return Math.sin(Math.toRadians(numero));
            case "cos": return Math.cos(Math.toRadians(numero));
            case "tan": return Math.tan(Math.toRadians(numero));
            case "x²": return Math.pow(numero, 2);
            case "log": return Math.log10(numero); // Logaritmo base 10
            case "ln": return Math.log(numero); // Logaritmo natural
            case "e^x": return Math.exp(numero); // Exponencial e
            case "10^x": return Math.pow(10, Math.max(numero, 1)); // Potencia base 10
            case "1/x": 
                if (numero == 0) throw new ArithmeticException("División por cero");
                return 1 / numero; // Inverso multiplicativo
            case "n!": return calcularFactorial((int) numero); // Factorial
            case "π": return Math.PI; // Pi (ignora el número en pantalla y muestra Pi)
            default: return numero;
        }
    }

    // Método privado auxiliar para el factorial
    private double calcularFactorial(int n) {
        if (n < 0) return 0; // Por simplicidad, no calculamos factorial negativo
        double resultado = 1;
        for (int i = 1; i <= n; i++) {
            resultado *= i;
        }
        return resultado;
    }
}
