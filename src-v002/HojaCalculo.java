import modelo.Matriz;
import modelo.Posicion;
import vista.InterfazUsuario;
import controlador.ControladorHoja;
import controlador.Teclado;

public class HojaCalculo {
    private Matriz matriz;
    private Posicion posicion;
    private InterfazUsuario interfaz;
    private ControladorHoja controlador;

    public HojaCalculo() {
        this.matriz = new Matriz();
        this.posicion = new Posicion();
        this.controlador = new ControladorHoja(matriz, posicion);
        this.interfaz = new InterfazUsuario();
    }

    public void iniciar() {
        Teclado teclado = interfaz.getTeclado();
        boolean ejecutando = true;

        while (ejecutando) {
            interfaz.actualizarVista(matriz, posicion);
            char comando = teclado.leerComando();
            ejecutando = controlador.procesarComando(comando, teclado);
        }

        teclado.cerrar();
        System.out.println("Programa finalizado.");
    }

    public static void main(String[] args) {
        HojaCalculo hoja = new HojaCalculo();
        hoja.interfaz.iniciarPrograma(hoja); 
    }
}
