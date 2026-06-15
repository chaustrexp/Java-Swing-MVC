import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class CalculadoraVista extends JFrame {
    
    private JTextField pantalla;
    private JButton[] botones;
    private String[] etiquetasBotones = {
        "sin", "cos", "tan", "π",
        "log", "ln", "e^x", "10^x",
        "1/x", "x²", "x^y", "√",
        "(", ")", "%", "n!",
        "7", "8", "9", "/",
        "4", "5", "6", "*",
        "1", "2", "3", "-",
        "C", "0", "=", "+"
    };

    public CalculadoraVista() {
        // Configuración básica de la ventana
        setTitle("Calculadora MVC");
        setSize(360, 650); // Un poco más ancha y alta para que quepan todos cómodamente
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout()); // Sin márgenes globales para un diseño limpio
        getContentPane().setBackground(new Color(30, 30, 30)); // Fondo oscuro

        // 1. Crear y configurar la pantalla (NORTE)
        pantalla = new JTextField();
        pantalla.setFont(new Font("Segoe UI", Font.BOLD, 36));
        pantalla.setHorizontalAlignment(JTextField.RIGHT);
        pantalla.setEditable(false); // El usuario no debe escribir con el teclado
        pantalla.setBackground(new Color(30, 30, 30));
        pantalla.setForeground(Color.WHITE);
        pantalla.setBorder(new EmptyBorder(30, 20, 30, 20)); // Márgenes internos
        pantalla.setCaretColor(new Color(30, 30, 30)); // Ocultar el cursor
        add(pantalla, BorderLayout.NORTH);

        // 2. Crear el panel de botones (CENTRO)
        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new GridLayout(8, 4, 4, 4)); // 8 filas, 4 columnas
        panelBotones.setBackground(new Color(30, 30, 30));
        panelBotones.setBorder(new EmptyBorder(10, 10, 10, 10));
        
        botones = new JButton[32];
        for (int i = 0; i < 32; i++) {
            botones[i] = new JButton(etiquetasBotones[i]);
            botones[i].setFont(new Font("Segoe UI", Font.BOLD, 22));
            botones[i].setFocusPainted(false);
            botones[i].setBorderPainted(false); // Estilo plano sin borde
            
            // Colores base para los números
            botones[i].setBackground(new Color(60, 60, 60));
            botones[i].setForeground(Color.WHITE);

            // Colores especiales para los operadores y 'C'
            String texto = etiquetasBotones[i];
            if (texto.matches("[/*\\-+=]")) {
                botones[i].setBackground(new Color(255, 149, 0)); // Naranja vibrante
                botones[i].setForeground(Color.WHITE);
            } else if (texto.equals("C")) {
                botones[i].setBackground(new Color(165, 165, 165)); // Gris claro
                botones[i].setForeground(Color.BLACK);
            }

            panelBotones.add(botones[i]);
        }
        add(panelBotones, BorderLayout.CENTER);
    }

    // Métodos para que el Controlador interactúe con la Vista
    
    public void setTextoPantalla(String texto) {
        pantalla.setText(texto);
    }

    public String getTextoPantalla() {
        return pantalla.getText();
    }

    // Permite al controlador registrarse para escuchar los clics de todos los botones
    public void agregarListener(ActionListener listener) {
        for (JButton boton : botones) {
            boton.addActionListener(listener);
        }
    }
}