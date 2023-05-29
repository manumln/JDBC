package controlador;

import modelo.modelo.dao.Usuario;
import modelo.modelo.dao.UsuarioDAO;
import modelo.modelo.dao.UsuarioDAOImp;
import vista.app1.App1;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.SQLException;
import java.util.List;

public class Controlador extends Component {
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
        vista.getBotonInsertar().addActionListener(actionEvent -> btnInsertarActionPerformed());
    }
    private void btnInsertarActionPerformed() {
        // Obtener los datos de los campos de texto
        String id_usuario = vista.getTextoID().getText();
        String nombre = vista.getTextoNombre().getText();
        String dni = vista.getTextoDNI().getText();
        String direccion = vista.getTextoDireccion().getText();
        String telefono = vista.getTextoTelefono().getText();
        String email = vista.getTextoEmail().getText();
        String rol = vista.getTextoRol().getText();
        String contrasenna = vista.getTextoContrasenna().getText(); // Corregido: obtener el texto del campo de contraseña

        // Crear un objeto Usuario con los datos
        int id = Integer.parseInt(id_usuario);
        Usuario usuario = new Usuario(id, nombre, dni, direccion, telefono, email, rol, contrasenna);

        // Insertar el usuario en la base de datos
        try {
            boolean exito = dao.insertarUsuario(usuario); // Corregido: utilizar la instancia existente de UsuarioDAO
            if (exito) {
                JOptionPane.showMessageDialog(vista, "Usuario insertado correctamente");
                // Actualizar la tabla después de la inserción
                actualizarFila();
            } else {
                JOptionPane.showMessageDialog(vista, "Error al insertar el usuario", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(vista, "Error al insertar el usuario: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }


    private void actualizarFila() {
        JOptionPane.showMessageDialog(null, "Cada vez que cambias ", "alert", JOptionPane.ERROR_MESSAGE);
        int row = vista.getTablaDatos().getSelectedRow();
        //System.out.println("fila: " + row);
        String id_usuario = ((ModeloTabla) vista.getTablaDatos().
                getModel()).getData().get(row)[0];
        String nombre = ((ModeloTabla) vista.getTablaDatos().
                getModel()).getData().get(row)[1];
        String dni = ((ModeloTabla) vista.getTablaDatos().
                getModel()).getData().get(row)[2];
        String direccion = ((ModeloTabla) vista.getTablaDatos().
                getModel()).getData().get(row)[3];
        String telefono = ((ModeloTabla) vista.getTablaDatos().
                getModel()).getData().get(row)[4];
        String email = ((ModeloTabla) vista.getTablaDatos().
                getModel()).getData().get(row)[5];
        String rol = ((ModeloTabla) vista.getTablaDatos().
                getModel()).getData().get(row)[6];
        String contrasenna = ((ModeloTabla) vista.getTablaDatos().
                getModel()).getData().get(row)[7];

        System.out.println(id_usuario + "-" + nombre + "-" + dni + "-" + direccion + "-" + telefono + "-" + email + "-" + rol + "-" + contrasenna );
        int id = Integer.parseInt(id_usuario);
        Usuario usuario = new Usuario(id, nombre,dni,direccion,telefono,email,rol,contrasenna);
        try {
            dao.actualizarUsuarioPorId(usuario, id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void borrarFila() {
        int row = vista.getTablaDatos().getSelectedRow(); //fila seleccionada
        String sID = ((ModeloTabla) vista.getTablaDatos().
                getModel()).getData().get(row)[0]; //obtener la celda del ID
        int id = Integer.parseInt(sID); //convierto el id de String a int
        ((ModeloTabla) vista.getTablaDatos().getModel()).getData().remove(row); //elimino la fila de data
        ((ModeloTabla) vista.getTablaDatos().getModel()).fireTableDataChanged(); //repinta la tabla
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
