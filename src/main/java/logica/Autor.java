package logica;

public class Autor {
    private static String codigoAutor;
    private static String primerNombreAutor;
    private static String segundoNombreAutor;
    private static String primerApelldoAutor;
    private static String segundoApelldoAutor;

    public static String getCodigoAutor() {
        return codigoAutor;
    }

    public static void setCodigoAutor(String codigoAutor) {
        Autor.codigoAutor = codigoAutor;
    }

    public static String getPrimerNombreAutor() {
        return primerNombreAutor;
    }

    public static void setPrimerNombreAutor(String primerNombreAutor) {
        Autor.primerNombreAutor = primerNombreAutor;
    }

    public static String getSegundoNombreAutor() {
        return segundoNombreAutor;
    }

    public static void setSegundoNombreAutor(String segundoNombreAutor) {
        Autor.segundoNombreAutor = segundoNombreAutor;
    }

    public static String getPrimerApelldoAutor() {
        return primerApelldoAutor;
    }

    public static void setPrimerApelldoAutor(String primerApelldoAutor) {
        Autor.primerApelldoAutor = primerApelldoAutor;
    }

    public static String getSegundoApelldoAutor() {
        return segundoApelldoAutor;
    }

    public static void setSegundoApelldoAutor(String segundoApelldoAutor) {
        Autor.segundoApelldoAutor = segundoApelldoAutor;
    }
}
