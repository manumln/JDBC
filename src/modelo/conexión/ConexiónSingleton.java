package modelo.conexión;

import org.sqlite.SQLiteConfig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexiónSingleton {
    private static ConexiónSingleton ConexiónSingleton;
    private Connection connection;
    private ConexiónSingleton() throws SQLException {
        Runtime.getRuntime().addShutdownHook(new MyShutdownHook());
        SQLiteConfig config = new SQLiteConfig();
        config.enforceForeignKeys(true);
        connection = DriverManager.getConnection(
                "jdbc:sqlite:DBs/usuario.db", config.toProperties());
    }

    public static ConexiónSingleton getConexiónSingleton() throws SQLException {

        if (ConexiónSingleton == null) {
            ConexiónSingleton = new ConexiónSingleton();
        }
        return ConexiónSingleton;
    }

    public Connection getConnection() {
        return connection;
    }

    static class MyShutdownHook extends Thread {
        @Override
        public void run() {
            try {
                Connection Conexión = getConexiónSingleton().getConnection();
                if (Conexión != null)
                    Conexión.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }

    }
}