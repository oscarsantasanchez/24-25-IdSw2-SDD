package controlador;

import modelo.Celda;
import modelo.Matriz;
import modelo.Posicion;
import util.Constantes;


public class ControladorHoja {
    private Matriz matriz;
    private Posicion posicion;
    

    public ControladorHoja(Matriz matriz, Posicion posicion) {
        this.matriz = matriz;
        this.posicion = posicion;
    }
    

    public boolean procesarComando(char comando, Teclado teclado) {
        switch (comando) {
            case Constantes.COMANDO_ARRIBA -> posicion.moverArriba();
            case Constantes.COMANDO_ABAJO -> posicion.moverAbajo();
            case Constantes.COMANDO_IZQUIERDA -> posicion.moverIzquierda();
            case Constantes.COMANDO_DERECHA -> posicion.moverDerecha();
            case Constantes.COMANDO_SALIR -> return false;  
            case Constantes.COMANDO_EDITAR {
                Celda celdaActual = matriz.getCelda(posicion.getFila(), posicion.getColumna());
                teclado.editarCelda(celdaActual);
            }
           
        }
        return true;
    }
    

    public Matriz getMatriz() {
        return matriz;
    }
    

    public Posicion getPosicion() {
        return posicion;
    }
}