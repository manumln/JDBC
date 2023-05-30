package vista.app1;

import controlador.ModeloTabla;
import javax.swing.*;
import java.awt.*;

public class App1 extends JFrame {

    private JPanel mainPanel;
    private JTextField textoEmail;
    private JTextField textoDNI;
    private JTextField textoID;
    private JButton botonInsertar;
    private JButton botonBorrar;
    private JButton botonActualizar;
    private JTable tablaDatos;
    private JTextField textoNombre;
    private JTextField textoDireccion;
    private JTextField textoTelefono;
    private JTextField textoRol;
    private JTextField textoContrasenna;


    public App1() {
        tablaDatos.setModel(new ModeloTabla());
        Container container = getContentPane();
        container.add(mainPanel);
        setTitle("Ejemplo de tabla");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(700,700);
        setResizable(false);
        setLocationRelativeTo(null);

    }

    public JTextField getTextoContrasenna() {
        return textoContrasenna;
    }

    public JTextField getTextoEmail() {
        return textoEmail;
    }

    public JTextField getTextoDNI() {
        return textoDNI;
    }

    public JTextField getTextoID() {
        return textoID;
    }

    public JTextField getTextoNombre() {
        return textoNombre;
    }

    public JTextField getTextoDireccion() {
        return textoDireccion;
    }

    public JTextField getTextoTelefono() {
        return textoTelefono;
    }

    public JTextField getTextoRol() {
        return textoRol;
    }

    public JButton getBotonBorrar() {
        return botonBorrar;
    }

    public JTable getTablaDatos() {
        return tablaDatos;
    }

    public static void main(String[] args) {
        (new App1()).setVisible(true);
    }

    public JButton getBotonActualizar() {
        return botonActualizar;
    }

    public JButton getBotonInsertar() {
        return botonInsertar;
    }


}
