package modelo;

public class Matriz {
    private Celda[][] celdas;
    private int filas;
    private int columnas;
    
    public Matriz(int filas, int columnas) {
        this.filas = filas;
        this.columnas = columnas;
        this.celdas = new Celda[filas][columnas];
        
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                celdas[i][j] = new CeldaTexto("");
            }
        }
    }
    
    public Celda getCelda(int fila, int columna) {
        if (fila >= 0 && fila < filas && columna >= 0 && columna < columnas) {
            return celdas[fila][columna];
        }
        return null;
    }
    
    public void setCelda(int fila, int columna, String contenido) {
        if (fila >= 0 && fila < filas && columna >= 0 && columna < columnas) {
            celdas[fila][columna] = Celda.crearCelda(contenido, this);
        }
    }
    
    public int getFilas() {
        return filas;
    }
    
    public int getColumnas() {
        return columnas;
    }
}