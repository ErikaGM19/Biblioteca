package logica;

public class ProfesorArea {
    private static String idUsuario;
    private static String codigoArea;

    public static String getIdUsuario() {
        return idUsuario;
    }

    public static void setIdUsuario(String idUsuario) {
        ProfesorArea.idUsuario = idUsuario;
    }

    public static String getCodigoArea() {
        return codigoArea;
    }

    public static void setCodigoArea(String codigoArea) {
        ProfesorArea.codigoArea = codigoArea;
    }
}
