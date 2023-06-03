package logica;

public class Libro {
    private static String ISBN;
    private static String codArea;
    private static String codigoEditorial;
    private static String idEmpleado;
    private static String tituloLibro;
    private static int anioPublicacion;
    private static int numeroPaginas;
    private static String idioma;

    public static String getISBN() {
        return ISBN;
    }

    public static void setISBN(String ISBN) {
        Libro.ISBN = ISBN;
    }

    public static String getCodArea() {
        return codArea;
    }

    public static void setCodArea(String codArea) {
        Libro.codArea = codArea;
    }

    public static String getCodigoEditorial() {
        return codigoEditorial;
    }

    public static void setCodigoEditorial(String codigoEditorial) {
        Libro.codigoEditorial = codigoEditorial;
    }

    public static String getIdEmpleado() {
        return idEmpleado;
    }

    public static void setIdEmpleado(String idEmpleado) {
        Libro.idEmpleado = idEmpleado;
    }

    public static String getTituloLibro() {
        return tituloLibro;
    }

    public static void setTituloLibro(String tituloLibro) {
        Libro.tituloLibro = tituloLibro;
    }

    public static int getAnioPublicacion() {
        return anioPublicacion;
    }

    public static void setAnioPublicacion(int anioPublicacion) {
        Libro.anioPublicacion = anioPublicacion;
    }

    public static int getNumeroPaginas() {
        return numeroPaginas;
    }

    public static void setNumeroPaginas(int numeroPaginas) {
        Libro.numeroPaginas = numeroPaginas;
    }

    public static String getIdioma() {
        return idioma;
    }

    public static void setIdioma(String idioma) {
        Libro.idioma = idioma;
    }
}
