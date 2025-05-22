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
    

    public boolean moverArriba() {
        if (fila > 0) {
            fila--;
            return true;
        }
        return false;
    }
    

    public boolean moverAbajo() {
        if (fila < Constantes.TOTAL_FILAS - 1) {
            fila++;
            return true;
        }
        return false;
    }
    

    public boolean moverIzquierda() {
        if (columna > 0) {
            columna--;
            return true;
        }
        return false;
    }
    

    public boolean moverDerecha() {
        if (columna < Constantes.TOTAL_COLUMNAS - 1) {
            columna++;
            return true;
        }
        return false;
    }
}