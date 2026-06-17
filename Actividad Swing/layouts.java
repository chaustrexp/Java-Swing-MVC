import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

public class layouts {
    public static void main(String[] args) {
        // 1. Necesitas una ventana (JFrame) para poder aplicarle los layouts
        JFrame frame = new JFrame("Ejemplos de Layouts");
        frame.setSize(500, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 2. Creamos los botones una sola vez
        JButton btn1 = new JButton("btn1");
        JButton btn2 = new JButton("btn2");
        JButton btn3 = new JButton("btn3"); // btn3 y btn4 faltaban
        JButton btn4 = new JButton("btn4");

        // A continuación tienes los 3 ejemplos que pegaste. 
        // He dejado el GroupLayout activo y los otros dos comentados para que no choquen.
        // Puedes comentar uno y descomentar otro para ir probándolos.

        // ==========================================
        // EJEMPLO 1: BorderLayout
        // ==========================================
        /*
        frame.setLayout(new BorderLayout());
        frame.add(btn1, BorderLayout.NORTH);
        frame.add(btn2, BorderLayout.SOUTH);
        */


        // ==========================================
        // EJEMPLO 2: BoxLayout
        // ==========================================
        // BoxLayout.PAGE_AXIS coloca los elementos verticalmente, de arriba a abajo
        /*
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.PAGE_AXIS));
        frame.add(btn1);
        frame.add(btn2);
        */


        // ==========================================
        // EJEMPLO 3: GroupLayout (Activo)
        // ==========================================
        GroupLayout layout = new GroupLayout(frame.getContentPane());
        frame.setLayout(layout); // Se asigna el layout a la ventana
        layout.setAutoCreateContainerGaps(true);
        layout.setAutoCreateGaps(true);

        layout.setHorizontalGroup(
            layout.createSequentialGroup()
                .addComponent(btn1)
                .addComponent(btn2)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(btn3)
                    .addComponent(btn4))
        );

        layout.setVerticalGroup(
            layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(btn1)
                    .addComponent(btn2)
                    .addComponent(btn3))
                .addComponent(btn4)
        );

        // 3. Hacer la ventana visible al final
        frame.setVisible(true);
    }
}
