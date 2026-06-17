import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class jmenu {
    public static void main(String[] args) {
        // 1. Crear la ventana (JFrame)
        JFrame frame = new JFrame("Ejemplo de JMenu y JFileChooser");
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 2. Crear la barra de menú y el menú
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("Archivo");

        JMenuItem importarMenuItem = new JMenuItem("Importar");
        JMenuItem exportarMenuItem = new JMenuItem("Exportar");

        fileMenu.add(importarMenuItem);
        fileMenu.add(exportarMenuItem);
        menuBar.add(fileMenu);

        // 3. Establecer la barra de menú en la ventana (cambio de 'this' por 'frame')
        frame.setJMenuBar(menuBar);

        // 4. Agregar acción a la opción "Importar" para que abra el JFileChooser
        importarMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // El código de JFileChooser va aquí adentro para que se abra 
                // SOLO cuando el usuario hace clic en "Importar"
                JFileChooser c = new JFileChooser();
                // Cambiamos 'Ventana.this' por 'frame'
                int rVal = c.showOpenDialog(frame); 
                
                if (rVal == JFileChooser.APPROVE_OPTION) {
                    System.out.println("Archivo seleccionado: " + c.getSelectedFile().getName());
                    System.out.println("Directorio: " + c.getCurrentDirectory().toString());
                }
                if (rVal == JFileChooser.CANCEL_OPTION) {
                    System.out.println("Pulsaste cancelar");
                }
            }
        });

        // 5. Hacer la ventana visible
        frame.setVisible(true);
    }
}
