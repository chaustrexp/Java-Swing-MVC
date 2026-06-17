import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        
        // Aseguramos que la interfaz inicie en el hilo correcto (EDT)
        SwingUtilities.invokeLater(() -> {
            
            // 1. Instanciar el Modelo
            CalculadoraMotor motor = new CalculadoraMotor();
            
            // 2. Instanciar la Vista
            CalculadoraVista vista = new CalculadoraVista();
            
            // 3. Instanciar el Controlador (le pasamos la vista y el motor)
            CalculadoraControlador controlador = new CalculadoraControlador(vista, motor);
            
            // 4. Mostrar la interfaz
            vista.setVisible(true);
        });
    }
}