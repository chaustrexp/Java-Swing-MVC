import javax.swing.*;
import java.awt.FlowLayout;

public class Inicio {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Nombre de la ventana"); // Creamos la ventana con un titulo
        frame.setSize(800,600); // le asignamos un tamaño
        //frame.setLocation(0,0); // Definimos el origen de coordenadas de la ventana
        frame.setLocationRelativeTo(null); // Centra la ventana en la pantalla
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // definimos que pasará cuando pulsemos el botón de cerrar
        
        frame.setLayout(new FlowLayout()); // Es mejor definir el layout antes de agregar componentes

        JButton button = new JButton("Texto boton");
        frame.add(button);

        JTextArea ciclosTextArea = new JTextArea(15,20);
        frame.add(ciclosTextArea); // Agregamos el área de texto para que se vea

        // Muestra un mensaje no editable
        JLabel label = new JLabel("nombre");
        frame.add(label); // Agregamos el label para que se vea

        frame.setVisible(true); // La hacemos visible al final, después de agregar los componentes

        // Muestra un cuadro de diálogo con un mensaje
        JOptionPane.showMessageDialog(frame, "Eggs are not supposed to be green.");
    }
}