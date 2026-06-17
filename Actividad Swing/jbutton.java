import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.FlowLayout;

public class jbutton {
    public static void main(String[] args) {
        // 1. Crear el marco (ventana) para poder ver el botón
        JFrame frame = new JFrame("Ejemplo de Botón");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        // 2. Crear el botón
        JButton btn = new JButton("Boton");

        // 3. Agregar la acción (ActionListener) al botón correctamente
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Aquí va el código de lo que quieres que haga el botón al hacer clic
                System.out.println("¡Has hecho clic en el botón!");
                
                // (Código que tenías antes, comentado porque las variables no existen en este archivo)
                // int row = tabla.getSelectedRow();
                // listadoCursos.remove(row);
                // alimentarTabla();
                // System.out.println(row);
            }
        });

        // 4. Agregar el botón a la ventana y hacerla visible
        frame.add(btn);
        frame.setVisible(true);
    }
}
