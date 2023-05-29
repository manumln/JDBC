package controlador;

import modelo.modelo.dao.Usuario;
import modelo.modelo.dao.UsuarioDAO;
import vista.app1.App1;

import javax.swing.*;
import java.sql.SQLException;

public class Controlador {
    private UsuarioDAO dao;
    private App1 vista;

    public Controlador(UsuarioDAO dao, App1 vista) {
        this.dao = dao;
        this.vista = vista;
        iniciarApp();
        registrarEventosBoton();
    }

    private void registrarEventosBoton() {
        vista.getBotonBorrar().addActionListener(actionEvent -> borrarFila());
        vista.getBotonActualizar().addActionListener(actionEvent -> actualizarFila());
    }
    private void actualizarFila() {
        JOptionPane.showMessageDialog(null, "Cada vez que cambias ", "alert", JOptionPane.ERROR_MESSAGE);
        int row = vista.getTabla().getSelectedRow();
        //System.out.println("fila: " + row);
        String sID = ((ModeloTabla) vista.getTabla().
                getModel()).getData().get(row)[0];
        String nombre = ((ModeloTabla) vista.getTabla().
                getModel()).getData().get(row)[1];
        String dni = ((ModeloTabla) vista.getTabla().
                getModel()).getData().get(row)[2];
        String direccion = ((ModeloTabla) vista.getTabla().
                getModel()).getData().get(row)[3];
        String telefono = ((ModeloTabla) vista.getTabla().
                getModel()).getData().get(row)[4];
        String email = ((ModeloTabla) vista.getTabla().
                getModel()).getData().get(row)[5];
        String rol = ((ModeloTabla) vista.getTabla().
                getModel()).getData().get(row)[6];
        String contrasenna = ((ModeloTabla) vista.getTabla().
                getModel()).getData().get(row)[7];

        System.out.println(sID + "-" + nombre + "-" + dni);
        int id = Integer.parseInt(sID);
        Usuario usuario = new Usuario(nombre,dni,direccion,telefono,email,rol,contrasenna);
        try {
            dao.actualizarUsuarioPorId(usuario, id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    private void borrarFila() {
        int row = vista.getTabla().getSelectedRow(); //fila seleccionada
        String sID = ((ModeloTabla) vista.getTabla().
                getModel()).getData().get(row)[0]; //obtener la celda del ID
        int id = Integer.parseInt(sID); //convierto el id de String a int
        ((ModeloTabla) vista.getTabla().getModel()).getData().remove(row); //elimino la fila de data
        ((ModeloTabla) vista.getTabla().getModel()).fireTableDataChanged(); //repinta la tabla
        try {
            dao.eliminarUsuarioPorId(id); //eliminación usuario de la BD
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    private void iniciarApp() {
        vista.setVisible(true);
    }
}
