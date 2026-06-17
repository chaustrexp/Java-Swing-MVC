import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.FlowLayout;

public class ventana {
    public static void main(String[] args) {
        Ventana miVentana = new Ventana();
        miVentana.setVisible(true);
    }
}

class Ventana extends JFrame {
    public Ventana() {
        inicializar();
    }

    private void inicializar() {
        this.setSize(800, 600);
    }
}
