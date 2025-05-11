package modelo;

import util.Constantes;
import util.Utilidades;
public class Celda {
    private String contenidoCompleto;
    private String contenidoVisible;
    

    public Celda() {
        this.contenidoCompleto = "";
        this.contenidoVisible = Constantes.CELDA_VACIA;
    }
    

    public String getContenidoCompleto() {
        return contenidoCompleto;
    }
    

    public String getContenidoVisible() {
        return contenidoVisible;
    }
    

    public void setContenido(String contenido) {
        this.contenidoCompleto = contenido;
        this.contenidoVisible = Utilidades.formatearContenido(contenido);
    }
}