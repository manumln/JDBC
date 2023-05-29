package modelo;

import modelo.modelo.dao.Usuario;
import modelo.modelo.dao.UsuarioDAO;
import modelo.modelo.dao.UsuarioDAOImp;

import java.sql.SQLException;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        UsuarioDAO dao = new UsuarioDAOImp();
        try {
            List<Usuario> lista = dao.obtenerTodosLosUsuario();
            lista.forEach(System.out::println);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
