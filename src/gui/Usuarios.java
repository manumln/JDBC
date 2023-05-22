package gui;

import javax.swing.*;
import java.awt.*;

public class Usuarios extends JFrame {
    private static Font FONT = new Font("Serif", Font.BOLD, 20);
    private static int widthFrame  = 650;
    private static int heigthFrame = 350;
    public Usuarios() {
      //  super();
        setVentana();
        Container contenedor = getContentPane();
        JPanel panelCentral  = setPanelCentral();
        JPanel panelInferior = setPanelInferior();
        BorderLayout layout = new BorderLayout(10, 10);
        contenedor.setLayout(layout);
        contenedor.add(panelCentral, BorderLayout.CENTER);
        contenedor.add(panelInferior, BorderLayout.SOUTH);
    }

    private JPanel setPanelInferior() {
        JPanel panel = new JPanel();
        FlowLayout layout = new FlowLayout();
        layout.setHgap(500);
        panel.setLayout(layout);
        JButton botonAceptar  = new JButton("ACEPTAR");
        JButton botonCancelar = new JButton("CANCELAR");
        panel.add(botonAceptar);
        panel.add(botonCancelar);
        return panel;
    }

    private JPanel setPanelCentral() {
        JPanel panel = new JPanel();
        GridLayout layout = new GridLayout(4, 4, 20, 10);
        panel.setLayout(layout);
        JLabel id_usuario = new JLabel("ID_USUARIO");
        id_usuario.setFont(FONT);
        JTextField idTexto = new JTextField(10);
        JLabel nombre = new JLabel("NOMBRE");
        nombre.setFont(FONT);
        JTextField nombreTexto = new JTextField(10);
        JLabel dni = new JLabel("DNI");
        dni.setFont(FONT);
        JTextField dniTexto = new JTextField(10);
        JLabel direccion = new JLabel("DIRECCION");
        direccion.setFont(FONT);
        JTextField direccionTexto = new JTextField(10);
        JLabel telefono = new JLabel("TELEFONO");
        telefono.setFont(FONT);
        JTextField telefonoTexto = new JTextField(10);
        JLabel email = new JLabel("EMAIL");
        email.setFont(FONT);
        JTextField emailTexto = new JTextField(10);
        JLabel rol = new JLabel("ROL");
        rol.setFont(FONT);
        JTextField rolTexto = new JTextField(10);
        JLabel contrasenna = new JLabel("CONTRASEÑA");
        contrasenna.setFont(FONT);
        JPanel panelFecha = getPanelFecha();
        panel.add(id_usuario);
        panel.add(idTexto);
        panel.add(nombre);
        panel.add(nombreTexto);
        panel.add(dni);
        panel.add(dniTexto);
        panel.add(direccion);
        panel.add(direccionTexto);
        panel.add(telefono);
        panel.add(telefonoTexto);
        panel.add(email);
        panel.add(emailTexto);
        panel.add(rol);
        panel.add(rolTexto);
        return panel;
    }

    private JPanel getPanelFecha() {

        JPanel panel = new JPanel();
        FlowLayout layout = new FlowLayout();
        layout.setHgap(15);
        JTextField textoDia = new JTextField(2);
        JLabel barra1 = new JLabel("/");

        JLabel barra2 = new JLabel("/");
        JTextField textoMes = new JTextField(2);
        JTextField textoAnno = new JTextField(4);
        panel.add(textoDia);
        panel.add(barra1);
        panel.add(textoMes);
        panel.add(barra2);
        panel.add(textoAnno);
        return panel;

    }

    private void setVentana() {
        setTitle("Añadir usuario");
        setSize(widthFrame, heigthFrame);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
     //   setResizable(false);
    }
}
