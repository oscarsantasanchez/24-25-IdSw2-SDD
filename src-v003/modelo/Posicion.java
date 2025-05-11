package modelo;

import util.Constantes;
public class Posicion {
    private int fila;
    private int columna;
    

    public Posicion() {
        this.fila = 0;
        this.columna = 0;
    }
    

    public int getFila() {
        return fila;
    }
    

    public int getColumna() {
        return columna;
    }
    

    public void moverArriba() {
        if (fila > 0) {
            fila--;
        }
    }
    

    public void moverAbajo() {
        if (fila < Constantes.TOTAL_FILAS - 1) {
            fila++;
        }
    }
    

    public void moverIzquierda() {
        if (columna > 0) {
            columna--;
        }
    }
    

    public void moverDerecha() {
        if (columna < Constantes.TOTAL_COLUMNAS - 1) {
            columna++;
        }
    }
}