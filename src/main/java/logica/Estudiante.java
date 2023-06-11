package logica;

public class Estudiante {
    private static String idUsuario;
    private static String carreraEstudiante;
    private static String universidadEstudiante;

    public static String getIdUsuario() {
        return idUsuario;
    }

    public static void setIdUsuario(String idUsuario) {
        Estudiante.idUsuario = idUsuario;
    }

    public static String getCarreraEstudiante() {
        return carreraEstudiante;
    }

    public static void setCarreraEstudiante(String carreraEstudiante) {
        Estudiante.carreraEstudiante = carreraEstudiante;
    }

    public static String getUniversidadEstudiante() {
        return universidadEstudiante;
    }

    public static void setUniversidadEstudiante(String universidadEstudiante) {
        Estudiante.universidadEstudiante = universidadEstudiante;
    }
}
