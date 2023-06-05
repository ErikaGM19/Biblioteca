package dataAccess;

import logica.Usuario;

import java.sql.*;

import static Util.Constantes.*;

public class DaoUsuario {

    public static int guardarUsuario(Usuario usuario){
        String sql_guardar;
        sql_guardar="INSERT INTO " +
                "usuario (id_usuario, password_usuario, nombre_usuario, tel_usuario, dir_usuario, email_usuario) " +
                "VALUES (?, ?, ?, ?, ?, ?)";;

        int filasAfectadas = 0;

        // Obtener la conexión
        ConexionBD conexion = new ConexionBD();
        conexion.openConnection();
        Connection connection = conexion.getConnection();
        if (connection != null) {
            try(PreparedStatement statement = connection.prepareStatement(sql_guardar)){
                // Establecer los valores de los parámetros en la sentencia SQL
                statement.setString(1, usuario.getIdUsuario());
                statement.setString(2, usuario.getPasswordUsuario());
                statement.setString(3, usuario.getNombreUsuario());
                statement.setString(4, usuario.getTelUsuario());
                statement.setString(5, usuario.getDirUsuario());
                statement.setString(6, usuario.getEmailUsuario());

                // Ejecutar la sentencia SQL
                filasAfectadas = statement.executeUpdate();

            }
            catch (SQLException e){System.err.println(ERROR_SENTENCIA_SQL + e.getMessage());}
            catch(Exception e){ System.out.println(e); }
            finally {
                // Cerrar la conexión
                conexion.closeConnection();
            }
        }
        return filasAfectadas;
    }

    public static String obtenerNombreUsuarioPorID(String idUsuario) {
        String nombreUsuario = null;
        String sql_consulta = "SELECT nombre_usuario FROM usuario WHERE id_usuario = ?";

        // Obtener la conexión
        ConexionBD conexion = new ConexionBD();
        conexion.openConnection();
        Connection connection = conexion.getConnection();

        if (connection != null) {
            try (PreparedStatement statement = connection.prepareStatement(sql_consulta)) {
                // Establecer el valor del parámetro en la sentencia SQL
                statement.setString(1, idUsuario);

                // Ejecutar la consulta
                ResultSet resultSet = statement.executeQuery();

                if (resultSet.next()) {
                    // Obtener el valor del campo "nombre_usuario"
                    nombreUsuario = resultSet.getString("nombre_usuario");
                } else {
                    System.out.println(NO_SE_ENCONTRO_USUARIO + idUsuario);
                }

                resultSet.close();
            } catch (SQLException e) {
                System.err.println(ERROR_DE_CONSULTA + e.getMessage());
            } finally {
                // Cerrar la conexión
                conexion.closeConnection();
            }
        }

        return nombreUsuario;
    }

    public static Boolean existeUsuario(String idUsuario) {
        Boolean existe = false;
        String sql_consulta = "SELECT COUNT(*) AS total FROM usuario WHERE id_usuario = ?";

        // Obtener la conexión
        ConexionBD conexion = new ConexionBD();
        conexion.openConnection();
        Connection connection = conexion.getConnection();

        if (connection != null) {
            try (PreparedStatement statement = connection.prepareStatement(sql_consulta)) {
                // Establecer el valor del parámetro en la sentencia SQL
                statement.setString(1, idUsuario);

                // Ejecutar la consulta
                ResultSet resultSet = statement.executeQuery();

                if (resultSet.next()) {
                    // Obtener el valor del campo "total"
                    int total = resultSet.getInt("total");

                    // Verificar si existe el usuario
                    if (total > 0) {
                        existe = true;
                    }
                }

                resultSet.close();
            } catch (SQLException e) {
                System.err.println(ERROR_DE_CONSULTA + e.getMessage());
            } finally {
                // Cerrar la conexión
                conexion.closeConnection();
            }
        }

        return existe;
    }

    public Usuario obtenerUsuarioPorID(String idUsuario) {
        Usuario usuario = new Usuario();
        String sql_consulta = "SELECT * FROM usuario WHERE id_usuario = ?";

        // Obtener la conexión
        ConexionBD conexion = new ConexionBD();
        conexion.openConnection();
        Connection connection = conexion.getConnection();

        if (connection != null) {
            try (PreparedStatement statement = connection.prepareStatement(sql_consulta)) {
                // Establecer el valor del parámetro en la sentencia SQL
                statement.setString(1, idUsuario);

                // Ejecutar la consulta
                ResultSet resultSet = statement.executeQuery();

                if (resultSet.next()) {
                    // Obtener los valores de las columnas y asignarlos al objeto Usuario
                    usuario.setIdUsuario(resultSet.getString("id_usuario"));
                    usuario.setPasswordUsuario(resultSet.getString("password_usuario"));
                    usuario.setNombreUsuario(resultSet.getString("nombre_usuario"));
                    usuario.setTelUsuario(resultSet.getString("tel_usuario"));
                    usuario.setDirUsuario(resultSet.getString("dir_usuario"));
                    usuario.setEmailUsuario(resultSet.getString("email_usuario"));

                }

                resultSet.close();
            } catch (SQLException e) {
                System.err.println("Error al ejecutar la consulta: " + e.getMessage());
            } finally {
                // Cerrar la conexión
                conexion.closeConnection();
            }
        }

        return usuario;
    }
}
