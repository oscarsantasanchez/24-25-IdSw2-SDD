package controlador;

import modelo.Celda;
import modelo.Matriz;
import modelo.Posicion;
import util.Constantes;


public class ControladorHoja {
    private Matriz matriz;
    private Posicion posicion;
    private boolean expresionComando;
    

    public ControladorHoja(Matriz matriz, Posicion posicion) {
        this.matriz = matriz;
        this.posicion = posicion;
    }
    

    public boolean procesarComando(char comando, Teclado teclado) {
        expresionComando = switch (comando) {
            case Constantes.COMANDO_ARRIBA -> {
                posicion.moverArriba();
                yield true;
            }
            case Constantes.COMANDO_ABAJO -> {
                posicion.moverAbajo();
                yield true;
            }
            case Constantes.COMANDO_IZQUIERDA -> {
                posicion.moverIzquierda();
                yield true;
            }
            case Constantes.COMANDO_DERECHA -> {
                posicion.moverDerecha();
                yield true;
            }
            case Constantes.COMANDO_EDITAR -> {
                Celda celdaActual = matriz.getCelda(posicion.getFila(), posicion.getColumna());
                teclado.editarCelda(celdaActual);
                yield true;
            }
            case Constantes.COMANDO_SALIR -> false;
            default -> true;
        };

        return expresionComando;
    }
    

    public Matriz getMatriz() {
        return matriz;
    }
    

    public Posicion getPosicion() {
        return posicion;
    }
}