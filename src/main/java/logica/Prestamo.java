package logica;

import java.sql.Date;

public class Prestamo {
    private static String nPrestamo;
    private static Date fechaR;
    private static Date fechaD;
    private static String idUsuario;
    private static String idEmpleado;
    private static String ISBN;
    private static String numero;

    public static String getnPrestamo() {
        return nPrestamo;
    }

    public static void setnPrestamo(String nPrestamo) {
        Prestamo.nPrestamo = nPrestamo;
    }

    public static Date getFechaR() {
        return fechaR;
    }

    public static void setFechaR(Date fechaR) {
        Prestamo.fechaR = fechaR;
    }

    public static Date getFechaD() {
        return fechaD;
    }

    public static void setFechaD(Date fechaD) {
        Prestamo.fechaD = fechaD;
    }

    public static String getIdUsuario() {
        return idUsuario;
    }

    public static void setIdUsuario(String idUsuario) {
        Prestamo.idUsuario = idUsuario;
    }

    public static String getIdEmpleado() {
        return idEmpleado;
    }

    public static void setIdEmpleado(String idEmpleado) {
        Prestamo.idEmpleado = idEmpleado;
    }

    public static String getISBN() {
        return ISBN;
    }

    public static void setISBN(String ISBN) {
        Prestamo.ISBN = ISBN;
    }

    public static String getNumero() {
        return numero;
    }

    public static void setNumero(String numero) {
        Prestamo.numero = numero;
    }
}
