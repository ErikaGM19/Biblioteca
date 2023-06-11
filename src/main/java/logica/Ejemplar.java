package logica;

public class Ejemplar {
    private static String ISBN;
    private static String numero;
    private static String nCajon;
    private static String nPasillo;
    private static String nomSala;
    private static String estante;
    private static String estado;

    public static String getISBN() {
        return ISBN;
    }

    public static void setISBN(String ISBN) {
        Ejemplar.ISBN = ISBN;
    }

    public static String getNumero() {
        return numero;
    }

    public static void setNumero(String numero) {
        Ejemplar.numero = numero;
    }

    public static String getnCajon() {
        return nCajon;
    }

    public static void setnCajon(String nCajon) {
        Ejemplar.nCajon = nCajon;
    }

    public static String getnPasillo() {
        return nPasillo;
    }

    public static void setnPasillo(String nPasillo) {
        Ejemplar.nPasillo = nPasillo;
    }

    public static String getNomSala() {
        return nomSala;
    }

    public static void setNomSala(String nomSala) {
        Ejemplar.nomSala = nomSala;
    }

    public static String getEstante() {
        return estante;
    }

    public static void setEstante(String estante) {
        Ejemplar.estante = estante;
    }

    public static String getEstado() {
        return estado;
    }

    public static void setEstado(String estado) {
        Ejemplar.estado = estado;
    }
}
