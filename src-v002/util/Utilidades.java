package util;
public class Utilidades {
    

    public static String formatearContenido(String contenido) {
        return (contenido.length() > Constantes.ANCHO_CELDA) 
            ? contenido.substring(0, Constantes.ANCHO_CELDA) 
            : String.format("%-" + Constantes.ANCHO_CELDA + "s", contenido);
    }
    

    public static void limpiarPantalla() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    

    public static String columnaALetra(int columna) {
        return String.valueOf((char) ('A' + columna));
    }
    
    private Utilidades() {
    }
}