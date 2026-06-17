import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class resultadofinal {

    public static void main(String[] args) {
        // 1. Configurar la ventana principal (JFrame)
        JFrame frame = new JFrame("Resultado Final - Integración Swing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 500);
        frame.setLocationRelativeTo(null); // Centrar en pantalla

        // ==========================================
        // SECCIÓN 1: MENÚ (Viene de jmenu.java)
        // ==========================================
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("Archivo");
        JMenuItem importarMenuItem = new JMenuItem("Importar");
        JMenuItem exportarMenuItem = new JMenuItem("Exportar");

        fileMenu.add(importarMenuItem);
        fileMenu.add(exportarMenuItem);
        menuBar.add(fileMenu);
        frame.setJMenuBar(menuBar); // Agregamos el menú a la ventana superior

        // Acción del menú Importar (Abre el JFileChooser)
        importarMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser c = new JFileChooser();
                int rVal = c.showOpenDialog(frame);
                if (rVal == JFileChooser.APPROVE_OPTION) {
                    JOptionPane.showMessageDialog(frame, "Archivo seleccionado: " + c.getSelectedFile().getName());
                }
            }
        });

        // ==========================================
        // SECCIÓN 2: CONTENEDOR DE PESTAÑAS (Viene de tabs.java)
        // ==========================================
        JTabbedPane tabbedPane = new JTabbedPane();

        // -----------------------------------------------------------------
        // Pestaña 1: Inicio y Botones (Viene de Inicio.java y jbutton.java)
        // -----------------------------------------------------------------
        JPanel panelInicio = new JPanel();
        panelInicio.setLayout(new FlowLayout()); // Usando FlowLayout de layouts.java
        panelInicio.setBackground(Color.PINK); // Color de tabs.java

        JButton btnAccion = new JButton("Haz clic aquí"); // jbutton.java
        JLabel label = new JLabel("Etiqueta de prueba:"); // Inicio.java
        JTextArea textArea = new JTextArea(5, 20); // Inicio.java
        textArea.setText("Escribe aquí...");

        // Acción del botón para mostrar un mensaje (Inicio.java)
        btnAccion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Eggs are not supposed to be green.");
            }
        });

        panelInicio.add(label);
        panelInicio.add(btnAccion);
        panelInicio.add(new JScrollPane(textArea)); // Área de texto con barra lateral

        // -----------------------------------------------------------------
        // Pestaña 2: Tabla de Cursos (Viene de Jtable.java)
        // -----------------------------------------------------------------
        JPanel panelTabla = new JPanel(new BorderLayout()); // Usando BorderLayout

        String[][] datosCursos = {
                { "101", "Amit", "670000" },
                { "102", "Jai", "780000" },
                { "101", "Sachin", "700000" }
        };
        String[] columnas = { "Ciclo", "Módulo", "Unidad Formativa" };

        DefaultTableModel tableModel = new DefaultTableModel(datosCursos, columnas);
        JTable tabla = new JTable(tableModel);

        // Aumentamos altura de la cabecera
        JTableHeader th = tabla.getTableHeader();
        Dimension d = th.getPreferredSize();
        d.height = 30;
        th.setPreferredSize(d);

        // Menú emergente de la tabla (Clic derecho)
        JPopupMenu popup = new JPopupMenu();
        JMenuItem removeItem = new JMenuItem("Eliminar fila");
        popup.add(removeItem);

        // Detectar clics derechos en la tabla para mostrar el popup
        tabla.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                int row = tabla.rowAtPoint(e.getPoint());
                if (row != -1) {
                    tabla.setRowSelectionInterval(row, row);
                }
                if (e.isPopupTrigger() || e.getButton() == MouseEvent.BUTTON3) {
                    popup.show(tabla, e.getX(), e.getY());
                }
            }
        });

        // Acción de eliminar fila del popup
        removeItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = tabla.getSelectedRow();
                if (row != -1) {
                    tableModel.removeRow(row);
                }
            }
        });

        JScrollPane scrollPane = new JScrollPane(tabla);
        panelTabla.add(scrollPane, BorderLayout.CENTER); // Agregamos la tabla al centro del panel

        // -----------------------------------------------------------------
        // Pestaña 3: Extras (Viene de tabs.java)
        // -----------------------------------------------------------------
        JPanel panelExtras = new JPanel();
        panelExtras.setBackground(Color.CYAN);
        panelExtras.add(new JLabel("Aquí podríamos poner un GroupLayout..."));

        // ==========================================
        // AGREGAR TODO Y MOSTRAR
        // ==========================================
        // Metemos los tres paneles al JTabbedPane
        tabbedPane.addTab("Inicio", panelInicio);
        tabbedPane.addTab("Tabla de Cursos", panelTabla);
        tabbedPane.addTab("Extras", panelExtras);

        // Metemos el JTabbedPane al centro de la ventana
        frame.add(tabbedPane, BorderLayout.CENTER);

        // ¡Mostrar la ventana!
        frame.setVisible(true);
    }
}
