package modelo.conexion;

import org.sqlite.SQLiteConfig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionSingleton {
    private static ConexionSingleton conexionSingleton;
    private Connection connection;
    private ConexionSingleton() throws SQLException {
        Runtime.getRuntime().addShutdownHook(new MyShutdownHook());
        SQLiteConfig config = new SQLiteConfig();
        config.enforceForeignKeys(true);
        connection = DriverManager.getConnection(
                "jdbc:sqlite:DBs/usuarios.db", config.toProperties());
    }

    public static ConexionSingleton getConexionSingleton() throws SQLException {

        if (conexionSingleton == null) {
            conexionSingleton = new ConexionSingleton();
        }
        return conexionSingleton;
    }

    public Connection getConnection() {
        return connection;
    }

    static class MyShutdownHook extends Thread {
        @Override
        public void run() {
            try {
                Connection conexion = getConexionSingleton().getConnection();
                if (conexion != null)
                    conexion.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
