package modelo;

import util.Constantes;
public class Matriz {
    private Celda[][] celdas;
    

    public Matriz() {
        celdas = new Celda[Constantes.TOTAL_FILAS][Constantes.TOTAL_COLUMNAS];
        inicializarMatriz();
    }
    

    private void inicializarMatriz() {
        for (int i = 0; i < Constantes.TOTAL_FILAS; i++) {
            for (int j = 0; j < Constantes.TOTAL_COLUMNAS; j++) {
                celdas[i][j] = new Celda();
            }
        }
    }
    

    public Celda getCelda(int fila, int columna) {
        return celdas[fila][columna];
    }
    

    public int getTotalFilas() {
        return Constantes.TOTAL_FILAS;
    }
    

    public int getTotalColumnas() {
        return Constantes.TOTAL_COLUMNAS;
    }
}