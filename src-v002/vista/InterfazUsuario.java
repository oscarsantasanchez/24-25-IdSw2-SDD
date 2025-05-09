package vista;

import controlador.Teclado;
import modelo.Matriz;
import modelo.Posicion;
public class InterfazUsuario {
    private Teclado teclado;
    private VisualizadorHoja visualizador;
    
    public InterfazUsuario(Matriz matriz, Posicion posicion) {
        this.matriz = matriz;
        this.posicion = posicion;
        this.teclado = new Teclado();
        this.visualizador = new VisualizadorHoja();
    }

    public Teclado getTeclado() {
        return teclado;
    }


    public void actualizarVista() {
        visualizador.mostrarHoja();
        visualizador.mostrarInfoCelda();
        visualizador.mostrarInstrucciones();
    }
}