import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import java.awt.Color;

public class tabs {
    public static void main(String[] args) {
        // 1. Crear la ventana principal
        JFrame frame = new JFrame("Ejemplo de Pestañas (Tabs)");
        frame.setSize(500, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // 2. Crear el JTabbedPane (el contenedor de pestañas)
        JTabbedPane tabbedPane = new JTabbedPane();

        // 3. Crear algunos paneles de prueba para poner adentro de las pestañas
        JPanel panelColors = new JPanel();
        panelColors.setBackground(Color.PINK); // Le damos color para diferenciarlo
        panelColors.add(new JLabel("Contenido de Colores"));

        JPanel panelFruits = new JPanel();
        panelFruits.setBackground(Color.ORANGE);
        panelFruits.add(new JLabel("Contenido de Frutas"));

        JPanel panelVitamins = new JPanel();
        panelVitamins.setBackground(Color.CYAN);
        panelVitamins.add(new JLabel("Contenido de Vitaminas"));

        // 4. Agregar los paneles como pestañas
        tabbedPane.addTab("Colors", panelColors);
        tabbedPane.addTab("Fruits", panelFruits);
        tabbedPane.addTab("Vitamins", panelVitamins);

        // --- Código que tú tenías (arreglado) ---
        // 'panelGlobal' no existía, ahora lo agregamos directamente a la ventana (frame)
        frame.add(tabbedPane, BorderLayout.CENTER);

        // 'panelCursos' no existía. Si quieres cambiar el contenido de una pestaña existente (ej. la de índice 2),
        // tendrías que haber creado el panel primero. Aquí hay un ejemplo reemplazando la pestaña "Vitamins" (índice 2):
        JPanel panelCursos = new JPanel();
        panelCursos.setBackground(Color.GREEN);
        panelCursos.add(new JLabel("Ahora soy el panel de Cursos"));
        
        // Esto cambia el contenido de la pestaña índice 2 por el nuevo panelCursos
        tabbedPane.setComponentAt(2, panelCursos); 

        // 5. Hacer la ventana visible
        frame.setVisible(true);
    }
}