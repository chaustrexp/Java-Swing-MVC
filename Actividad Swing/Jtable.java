import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent; // Import correcto para eventos del ratón en Swing

public class Jtable {
    public static void main(String[] args) {
        // 1. Necesitas crear una ventana (JFrame) para mostrar tu tabla
        JFrame frame = new JFrame("Ejemplo de JTable con Menú");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 2. Datos de ejemplo y cabeceras (es posible usar HTML en las etiquetas)
        String[][] cursillos = { 
            { "101", "Amit", "670000" }, 
            { "102", "Jai", "780000" }, 
            { "101", "Sachin", "700000" } 
        };
        String[] columns = { "Ciclo", "Módulo", "<html>Unidad<br>Formativa</html>" };

        // 3. Crear el modelo de la tabla y luego la tabla
        DefaultTableModel tableModel = new DefaultTableModel(cursillos, columns);
        JTable tabla = new JTable(tableModel);

        // 4. Modificar el tamaño de la cabecera (JTableHeader)
        JTableHeader th = tabla.getTableHeader();
        Dimension d = th.getPreferredSize();
        d.height = 40; // Le damos altura para que quepa el texto en HTML
        th.setPreferredSize(d);

        // 5. Crear el menú desplegable (Popup Menu)
        JPopupMenu popup = new JPopupMenu();
        JMenuItem removeItem = new JMenuItem("Eliminar fila");
        popup.add(removeItem);

        // 6. Detectar clics en la tabla para mostrar el menú popup
        tabla.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                // Identificamos en qué fila se hizo clic
                int row = tabla.rowAtPoint(e.getPoint());
                if (row != -1) {
                    tabla.setRowSelectionInterval(row, row); // Seleccionamos visualmente la fila
                }
                
                // Si es un clic derecho (o el botón asignado a popups en tu SO)
                if (e.isPopupTrigger() || e.getButton() == MouseEvent.BUTTON3) {
                    popup.show(tabla, e.getX(), e.getY());
                }
            }
        });

        // 7. Acción de darle clic a "Eliminar fila" en el menú popup
        removeItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = tabla.getSelectedRow();
                if(row != -1) {
                    tableModel.removeRow(row); // Borramos la fila del modelo
                    System.out.println("Se eliminó la fila: " + row);
                }
            }
        });

        // 8. Meter la tabla en un JScrollPane (para tener barra de desplazamiento)
        JScrollPane sp = new JScrollPane(tabla);
        
        // 9. Añadir el JScrollPane a la ventana y hacerla visible
        frame.add(sp);
        frame.setVisible(true);
    }
    
    // =========================================================================
    // El método que tenías lo he dejado aquí fuera del main (donde debe ir). 
    // Está comentado porque la clase 'Curso' y 'ArrayList' no existen en este archivo.
    // =========================================================================
    /*
    private String[][] arrayListCursoToMultidimensionalStringArray(ArrayList<Curso> cursos){
        String[][] cursosArray= new String[cursos.size()][4];
        int i=0;
        for(Curso c : cursos) {
            String[] curso = {c.getCiclo(), c.getModulo(), c.getUf(), "X"};
            cursosArray[i] = curso; 
            i++;
        }
        return cursosArray; 
    }
    */
}
