import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MiPrimeraAppSwing {

    public static void main(String[] args) {
        // BUENA PRÁCTICA: Iniciar la interfaz en el Event Dispatch Thread (EDT)
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                crearYMostrarGUI();
            }
        });
        
        // Con expresiones Lambda (Java 8+), lo anterior se resume a:
        // SwingUtilities.invokeLater(() -> crearYMostrarGUI());
    }

    private static void crearYMostrarGUI() {
        // 1. Crear el Contenedor Principal
        JFrame frame = new JFrame("Mi Primera Ventana Swing");
        
        // Qué pasa cuando el usuario cierra la ventana (liberar memoria)
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200); // Ancho y alto inicial
        frame.setLocationRelativeTo(null); // Centrar en la pantalla

        // 2. Crear un Panel con un Layout
        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new BorderLayout(10, 10)); // BorderLayout con márgenes

        // 3. Crear Componentes
        JLabel etiqueta = new JLabel("¡Hola, futuro experto en Java!", SwingConstants.CENTER);
        JButton boton = new JButton("Haz clic aquí");

        // 4. Manejo de Eventos (Asignar acción al botón)
        boton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Este código se ejecuta cuando se hace clic
                etiqueta.setText("¡Excelente trabajo! Has manejado un evento.");
                boton.setEnabled(false); // Desactiva el botón después del clic
            }
        });

        // 5. Ensamblar: Añadir componentes al panel
        panelPrincipal.add(etiqueta, BorderLayout.CENTER);
        panelPrincipal.add(boton, BorderLayout.SOUTH);

        // 6. Añadir el panel a la ventana y hacerla visible
        frame.add(panelPrincipal);
        frame.setVisible(true);
    }
}