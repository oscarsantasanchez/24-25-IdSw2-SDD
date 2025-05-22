package modelo;

public class CeldaTexto extends Celda {
    
    public CeldaTexto(String contenido) {
        super(contenido);
    }
    
    @Override
    public String getValor() {
        return contenido;
    }
}