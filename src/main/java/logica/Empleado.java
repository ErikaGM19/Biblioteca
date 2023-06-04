package logica;

public class Empleado {
    private static String idEmpleado;
    private static String passwordEmpleado;
    private static String nombreEmpleado;
    private static String cargoEmpleado;

    public static String getIdEmpleado() {
        return idEmpleado;
    }

    public static void setIdEmpleado(String idEmpleado) {
        Empleado.idEmpleado = idEmpleado;
    }

    public static String getPasswordEmpleado() {
        return passwordEmpleado;
    }

    public static void setPasswordEmpleado(String passwordEmpleado) {
        Empleado.passwordEmpleado = passwordEmpleado;
    }

    public static String getNombreEmpleado() {
        return nombreEmpleado;
    }

    public static void setNombreEmpleado(String nombreEmpleado) {
        Empleado.nombreEmpleado = nombreEmpleado;
    }

    public static String getCargoEmpleado() {
        return cargoEmpleado;
    }

    public static void setCargoEmpleado(String cargoEmpleado) {
        Empleado.cargoEmpleado = cargoEmpleado;
    }
}
