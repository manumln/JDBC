package modelo.modelo.dao;

import java.sql.SQLException;
import java.util.List;

public interface UsuarioDAO {

    boolean insertarUsuario(Usuario usuario) throws SQLException;
    boolean eliminarUsuarioPorId(int id) throws SQLException;
    boolean actualizarUsuarioPorId(Usuario newUsuario, int id) throws SQLException;
    Usuario obtenerUsuarioPorId(int id) throws SQLException;
    List<Usuario> obtenerTodosLosUsuario() throws SQLException;
    List<String[]> obtenerTodosLosUsuariosParaLaTabla() throws SQLException;
}
