import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.EmptyBorder;

public class CalculadoraVista extends JFrame {

    private JTextField pantalla;
    private JButton[] botones;
    private String[] etiquetasBotones = {
            "7", "8", "9", "C",
            "4", "5", "6", "+",
            "1", "2", "3", "*",
            "/", "=", "-", "0"
    };

    public CalculadoraVista() {
        // Configuración básica de la ventana
        setTitle("Calculadora MVC");
        setSize(380, 520);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        
        // Color oscuro de fondo principal
        Color colorFondo = new Color(28, 28, 30);
        getContentPane().setBackground(colorFondo);

        // 1. Crear y configurar la pantalla (NORTE)
        pantalla = new JTextField();
        pantalla.setFont(new Font("Segoe UI", Font.BOLD, 38));
        pantalla.setHorizontalAlignment(JTextField.RIGHT);
        pantalla.setEditable(false);
        pantalla.setBackground(colorFondo);
        pantalla.setForeground(Color.WHITE);
        pantalla.setCaretColor(colorFondo);
        // Margen interno para dar espacio visual elegante
        pantalla.setBorder(new EmptyBorder(35, 20, 25, 20));
        add(pantalla, BorderLayout.NORTH);

        // 2. Crear el panel de botones (CENTRO)
        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new GridLayout(4, 4, 8, 8)); // 4 filas, 4 columnas, 8px de separación
        panelBotones.setBackground(colorFondo);
        panelBotones.setBorder(new EmptyBorder(5, 20, 20, 20)); // Margen externo
        
        botones = new JButton[16];
        for (int i = 0; i < 16; i++) {
            String texto = etiquetasBotones[i];
            botones[i] = new BotonPersonalizado(texto, 16);
            botones[i].setFont(new Font("Segoe UI", Font.BOLD, 22));

            // Estilos de colores dinámicos según el tipo de botón
            if (texto.equals("C")) {
                botones[i].setBackground(new Color(255, 69, 58)); // Rojo moderno
                botones[i].setForeground(Color.WHITE);
            } else if (texto.matches("[/*\\-+=]")) {
                botones[i].setBackground(new Color(255, 159, 10)); // Naranja vibrante
                botones[i].setForeground(Color.WHITE);
            } else {
                botones[i].setBackground(new Color(58, 58, 60)); // Gris oscuro moderno para números
                botones[i].setForeground(Color.WHITE);
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

    // Clase interna para los botones redondeados y efectos interactivos
    private static class BotonPersonalizado extends JButton {
        private final int radio;
        private Color colorOriginal;

        public BotonPersonalizado(String texto, int radio) {
            super(texto);
            this.radio = radio;
            setContentAreaFilled(false);
            setFocusPainted(false);
            setBorderPainted(false);
            setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

            // Escuchar eventos de mouse para cambiar el brillo de fondo (Hover/Click)
            addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent evt) {
                    if (colorOriginal == null) colorOriginal = getBackground();
                    setBackground(ajustarBrillo(colorOriginal, 20));
                }

                @Override
                public void mouseExited(MouseEvent evt) {
                    if (colorOriginal != null) setBackground(colorOriginal);
                }

                @Override
                public void mousePressed(MouseEvent evt) {
                    if (colorOriginal == null) colorOriginal = getBackground();
                    setBackground(ajustarBrillo(colorOriginal, -20));
                }

                @Override
                public void mouseReleased(MouseEvent evt) {
                    if (colorOriginal != null) {
                        if (getBounds().contains(evt.getPoint())) {
                            setBackground(ajustarBrillo(colorOriginal, 20));
                        } else {
                            setBackground(colorOriginal);
                        }
                    }
                }
            });
        }

        private Color ajustarBrillo(Color color, int cantidad) {
            int r = Math.max(0, Math.min(255, color.getRed() + cantidad));
            int g = Math.max(0, Math.min(255, color.getGreen() + cantidad));
            int b = Math.max(0, Math.min(255, color.getBlue() + cantidad));
            return new Color(r, g, b);
        }

        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            
            // Pintar fondo redondeado
            g2.setColor(getBackground());
            g2.fillRoundRect(0, 0, getWidth(), getHeight(), radio, radio);
            
            g2.dispose();
            super.paintComponent(g);
        }
    }
}