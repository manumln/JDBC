package vista.app5;

import controlador.ModeloTabla;
import javax.swing.*;
import java.awt.*;

public class App extends JFrame {

    private JPanel mainPanel;
    private JTextField textField6;
    private JTextField textField7;
    private JTextField textField1;
    private JButton botonInsertar;
    private JButton botonBorrar;
    private JButton botonAtras;
    private JButton botonActualizar;
    private JTable tabla;
    private JButton botonAvanzar;

    public App() {
        tabla.setModel(new ModeloTabla());
        Container container = getContentPane();
        container.add(mainPanel);
        setTitle("Ejemplo de tabla");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(700,700);
        setResizable(false);
        setLocationRelativeTo(null);

    }

    public JButton getBotonBorrar() {
        return botonBorrar;
    }

    public JTable getTabla() {
        return tabla;
    }

    public static void main(String[] args) {
        (new App()).setVisible(true);
    }
}