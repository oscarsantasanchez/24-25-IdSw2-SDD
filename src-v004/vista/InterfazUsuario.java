package vista;

import modelo.Matriz;
import modelo.Posicion;
import util.Teclado;
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
    
    public void iniciar(ControladorHoja controlador) {
        Teclado teclado = this.getTeclado();
        boolean ejecutando = true;
        
        while (ejecutando) {
            this.actualizarVista(controlador.getMatriz(), controlador.getPosicion());
            
            char comando = teclado.leerComando();
            
            ejecutando = controlador.procesarComando(comando, teclado);
        }
        
        teclado.cerrar();
        System.out.println("Programa finalizado.");
    }
}