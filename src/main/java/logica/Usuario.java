package logica;

public class Usuario {
    private static String idUsuario;
    private static String passwordUsuario;
    private static String nombreUsuario;
    private static String telUsuario;
    private static String dirUsuario;
    private static String emailUsuario;


    public static String getIdUsuario() {
        return idUsuario;
    }

    public static void setIdUsuario(String idUsuario) {
        Usuario.idUsuario = idUsuario;
    }

    public static String getPasswordUsuario() {
        return passwordUsuario;
    }

    public static void setPasswordUsuario(String passwordUsuario) {
        Usuario.passwordUsuario = passwordUsuario;
    }

    public static String getNombreUsuario() {
        return nombreUsuario;
    }

    public static void setNombreUsuario(String nombreUsuario) {
        Usuario.nombreUsuario = nombreUsuario;
    }

    public static String getTelUsuario() {
        return telUsuario;
    }

    public static void setTelUsuario(String telUsuario) {
        Usuario.telUsuario = telUsuario;
    }

    public static String getDirUsuario() {
        return dirUsuario;
    }

    public static void setDirUsuario(String dirUsuario) {
        Usuario.dirUsuario = dirUsuario;
    }

    public static String getEmailUsuario() {
        return emailUsuario;
    }

    public static void setEmailUsuario(String emailUsuario) {
        Usuario.emailUsuario = emailUsuario;
    }
}
