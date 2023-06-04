package dataAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {
    private Connection connection;
    private final String url = "jdbc:postgresql://localhost:5432/BIBLIOTECA"; // Cambia "nombre_basedatos" por el nombre de tu base de datos
    private final String username = "postgres"; // Cambia "usuario" por el nombre de usuario de tu base de datos
    private final String password = "123456"; // Cambia "contraseña" por la contraseña de tu base de datos

    public void openConnection() {
        try {
            // Carga el controlador JDBC de PostgreSQL
            Class.forName("org.postgresql.Driver");

            // Establece la conexión con la base de datos
            connection = DriverManager.getConnection(url, username, password);

            System.out.println("Conexión establecida correctamente");
        } catch (ClassNotFoundException e) {
            System.err.println("Error al cargar el controlador JDBC: " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("Error al establecer la conexión: " + e.getMessage());
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Conexión cerrada correctamente");
            }
        } catch (SQLException e) {
            System.err.println("Error al cerrar la conexión: " + e.getMessage());
        }
    }

}
