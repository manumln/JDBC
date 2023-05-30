package modelo.modelo.dao;



import modelo.conexion.ConexionSingleton;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAOImp implements UsuarioDAO{
    private static final Connection conexion;

    static {
        try {
            conexion = ConexionSingleton.getConexionSingleton().getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean insertarUsuario(Usuario usuario) throws SQLException {
        String sql = " INSERT INTO usuario (nombre , dni, direccion, telefono, email, rol, contrasenna) VALUES ( ?, ?, ?, ?, ?, ?, ?);";
        PreparedStatement sentencia = conexion.prepareStatement(sql);
        sentencia.setString(1, usuario.getNombre());
        sentencia.setString(2, usuario.getDni());
        sentencia.setString(3, usuario.getDireccion());
        sentencia.setString(4, usuario.getTelefono());
        sentencia.setString(5, usuario.getEmail());
        sentencia.setString(6, usuario.getRol());
        sentencia.setString(7, usuario.getContrasenna());

        int exito = sentencia.executeUpdate();
        if (sentencia != null)
            sentencia.close();
        return exito == 1;
    }

    @Override
    public boolean eliminarUsuarioPorId(int idUsuario) throws SQLException {
        String sql = " DELETE FROM usuario WHERE id = ?;";
        PreparedStatement sentencia = conexion.prepareStatement(sql);
        sentencia.setInt(1, idUsuario);
        int exito = sentencia.executeUpdate();
        if (sentencia != null)
            sentencia.close();
        return exito == 1;
    }

    @Override
    public boolean actualizarUsuarioPorId(Usuario newUsuario, int id) throws SQLException {
       String sql = "UPDATE usuario SET nombre = ?, dni = ?, direccion = ?, telefono = ?, email = ?, rol= ?, contrasenna = ? WHERE id_usuario = ?;";
       PreparedStatement sentencia = conexion.prepareStatement(sql);
        sentencia.setString(1, newUsuario.getNombre());
        sentencia.setString(2, newUsuario.getDni());
        sentencia.setString(3, newUsuario.getDireccion());
        sentencia.setString(4, newUsuario.getTelefono());
        sentencia.setString(5, newUsuario.getEmail());
        sentencia.setString(6, newUsuario.getRol());
        sentencia.setString(7, newUsuario.getContrasenna());
        sentencia.setInt(8, id);
       int exito = sentencia.executeUpdate();
       if (sentencia != null)
           sentencia.close();
       return exito == 1;
    }

    @Override
    public Usuario obtenerUsuarioPorId(int idUsuario) throws SQLException {
        Usuario usuario = null;
        String sql = "select * from usuario  where id = ?;";
        PreparedStatement sentencia = conexion.prepareStatement(sql);
        sentencia.setInt(1, idUsuario);
        ResultSet resultado = sentencia.executeQuery();
        while (resultado.next()){
            int id_usuario        = resultado.getInt("id_usuario");
            String nombre = resultado.getString("nombre");
            String dni    = resultado.getString("dni");
            String direccion = resultado.getString("direccion");
            String telefono = resultado.getString("telefono");
            String email = resultado.getString("email");
            String rol = resultado.getString("rol");
            String contrasenna = resultado.getString("contrasenna");
            usuario = new Usuario(id_usuario, nombre, dni, direccion, telefono, email, rol,contrasenna);
        }
        if (resultado != null)
            resultado.close();
        if (sentencia != null)
            sentencia.close();
        return usuario;
    }

    @Override
    public List<Usuario> obtenerTodosLosUsuario() throws SQLException {
        List<Usuario> usuarios = new ArrayList<>();
        String sql = "select * from usuario;";
        Statement sentencia = conexion.createStatement();
        ResultSet resultado = sentencia.executeQuery(sql);
        while (resultado.next()){
            int id_usuario        = resultado.getInt("id_usuario");
            String nombre = resultado.getString("nombre");
            String dni    = resultado.getString("dni");
            String direccion = resultado.getString("direccion");
            String telefono = resultado.getString("telefono");
            String email = resultado.getString("email");
            String rol = resultado.getString("rol");
            String contrasenna = resultado.getString("contrasenna");
            Usuario usuario = new Usuario(id_usuario, nombre, dni, direccion, telefono, email, rol, contrasenna);
            usuarios.add(usuario);
        }
        if (resultado != null)
            resultado.close();
        if (sentencia != null)
            sentencia.close();
        return usuarios;
    }

    @Override
    public List<String[]> obtenerTodosLosUsuariosParaLaTabla() throws SQLException {
        List<String[]> data = new ArrayList<>();
        List<Usuario> usuarios = obtenerTodosLosUsuario();
        for(Usuario usuario : usuarios){
            data.add(usuario.toString().split(","));
        }
        return data;
    }
}
