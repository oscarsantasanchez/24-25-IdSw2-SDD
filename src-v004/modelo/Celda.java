package modelo;

public abstract class Celda {
    protected String contenido;
    
    public Celda() {
        this.contenido = "";
    }
    
    public Celda(String contenido) {
        this.contenido = contenido;
    }
    
    public String getContenido() {
        return contenido;
    }
    
    public void setContenido(String contenido) {
        this.contenido = contenido;
    }
    
    public abstract String getValor();

    public static Celda crearCelda(String contenido, Matriz matriz) {
        if (contenido == null || contenido.isEmpty()) {
            return new CeldaTexto("");
        } else if (contenido.startsWith("=")) {
            return new CeldaFormula(contenido, matriz);
        } else if (contenido.matches("^[A-Z][0-9]+$")) {
            return new CeldaReferencia(contenido, matriz);
        } else {
            return new CeldaTexto(contenido);
        }
    }
}