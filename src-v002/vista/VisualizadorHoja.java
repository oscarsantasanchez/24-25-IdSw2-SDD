package vista;

import modelo.Matriz;
import modelo.Posicion;
import modelo.Celda;
import util.Constantes;
import util.Utilidades;
public class VisualizadorHoja {
    

    public void mostrarHoja(Matriz matriz, Posicion posicion) {
        Utilidades.limpiarPantalla();
        
        int filaActual = posicion.getFila();
        int columnaActual = posicion.getColumna();
        

        mostrarEncabezadosColumnas(columnaActual, matriz.getTotalColumnas());
        

        mostrarFilas(matriz, filaActual, columnaActual);
    }
    

    public void mostrarInfoCelda(Matriz matriz, Posicion posicion) {
        Celda celdaActual = matriz.getCelda(posicion.getFila(), posicion.getColumna());
        System.out.println("\nContenido completo de la celda seleccionada: " + 
            celdaActual.getContenidoCompleto());
    }
    

    public void mostrarInstrucciones() {
        System.out.println("Usa W/A/S/D para mover, 'e' para editar, 'q' para salir:");
    }
    

    private void mostrarEncabezadosColumnas(int columnaInicial, int totalColumnas) {
        System.out.print("      ");
        for (int j = columnaInicial; j < columnaInicial + Constantes.VISIBLE_COLUMNAS && j < totalColumnas; j++) {
            System.out.printf(" %-7s ", Utilidades.columnaALetra(j));
        }
        System.out.println();
    }
    

    private void mostrarFilas(Matriz matriz, int filaInicial, int columnaInicial) {
        for (int i = filaInicial; i < filaInicial + Constantes.VISIBLE_FILAS && i < matriz.getTotalFilas(); i++) {

            System.out.printf("%4d  ", i + 1);
            

            for (int j = columnaInicial; j < columnaInicial + Constantes.VISIBLE_COLUMNAS && j < matriz.getTotalColumnas(); j++) {
                String contenidoVisible = matriz.getCelda(i, j).getContenidoVisible();
                if (i == filaInicial && j == columnaInicial) {
                    System.out.print("[" + contenidoVisible + "] ");
                } else {
                    System.out.print(" " + contenidoVisible + "  ");
                }
            }
            System.out.println();
        }
    }
}