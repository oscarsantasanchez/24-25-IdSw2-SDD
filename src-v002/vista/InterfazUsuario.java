package vista;

import modelo.Matriz;
import modelo.Posicion;
import controlador.Teclado;
import controlador.ControladorHoja;

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
    
    public void iniciar(Matriz matriz, Posicion posicion, ControladorHoja controlador) {
        Teclado teclado = this.getTeclado();
        boolean ejecutando = true;
        
        while (ejecutando) {
            this.actualizarVista(matriz, posicion);
            
            char comando = teclado.leerComando();
            
            ejecutando = controlador.procesarComando(comando, teclado);
        }
        
        teclado.cerrar();
        System.out.println("Programa finalizado.");
    }
}