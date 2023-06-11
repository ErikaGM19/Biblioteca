package logica;

public class Escrito {
        private static String ISBN;
        private static String codigoAutor;

    public static String getISBN() {
        return ISBN;
    }

    public static void setISBN(String ISBN) {
        Escrito.ISBN = ISBN;
    }

    public static String getCodigoAutor() {
        return codigoAutor;
    }

    public static void setCodigoAutor(String codigoAutor) {
        Escrito.codigoAutor = codigoAutor;
    }
}
