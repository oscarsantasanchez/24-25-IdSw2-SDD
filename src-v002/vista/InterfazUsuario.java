package vista;

import controlador.Teclado;
import modelo.Matriz;
import modelo.Posicion;
public class InterfazUsuario {
    private Teclado teclado;
    private VisualizadorHoja visualizador;
    
    public InterfazUsuario() {
        this.teclado = new Teclado();
        this.visualizador = new VisualizadorHoja();
    }

    public Teclado getTeclado() {
        return teclado;
    }


    public void actualizarVista(Matriz matriz, Posicion posicion) {
        visualizador.mostrarHoja(matriz, posicion);
        visualizador.mostrarInfoCelda(matriz, posicion);
        visualizador.mostrarInstrucciones();
    }
}