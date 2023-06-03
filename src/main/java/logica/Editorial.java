package logica;

public class Editorial {
    private static String codigoEditorial;
    private static String nombreEditorial;
    private static String paginaWebEditorial;
    private static String paisEditorial;

    public static String getCodigoEditorial() {
        return codigoEditorial;
    }

    public static void setCodigoEditorial(String codigoEditorial) {
        Editorial.codigoEditorial = codigoEditorial;
    }

    public static String getNombreEditorial() {
        return nombreEditorial;
    }

    public static void setNombreEditorial(String nombreEditorial) {
        Editorial.nombreEditorial = nombreEditorial;
    }

    public static String getPaginaWebEditorial() {
        return paginaWebEditorial;
    }

    public static void setPaginaWebEditorial(String paginaWebEditorial) {
        Editorial.paginaWebEditorial = paginaWebEditorial;
    }

    public static String getPaisEditorial() {
        return paisEditorial;
    }

    public static void setPaisEditorial(String paisEditorial) {
        Editorial.paisEditorial = paisEditorial;
    }
}
