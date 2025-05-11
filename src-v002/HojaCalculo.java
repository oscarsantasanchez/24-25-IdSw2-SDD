import modelo.Matriz;
import modelo.Posicion;
import vista.InterfazUsuario;
import controlador.ControladorHoja;

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
        interfaz.iniciar(matriz, posicion, controlador);
    }

    public static void main(String[] args) {
        HojaCalculo hoja = new HojaCalculo();
        hoja.iniciar();
    }
}