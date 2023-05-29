package modelo.conexión;

import java.sql.Connection;
import java.sql.SQLException;

public class TestConexión {
    public static void main(String[] args) {
        try {
            ConexiónSingleton ConexiónSingleton1 = ConexiónSingleton.getConexiónSingleton();
            Connection conexion1 = ConexiónSingleton1.getConnection();
            Connection conexion2 = ConexiónSingleton1.getConnection();
            ConexiónSingleton ConexionSingleton2 = ConexiónSingleton.getConexiónSingleton();
            Connection conexion3 = ConexionSingleton2.getConnection();
            System.out.println(conexion1);
            System.out.println(conexion2);
            System.out.println(conexion3);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}