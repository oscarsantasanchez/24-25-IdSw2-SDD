package modelo;

public class CeldaReferencia extends Celda {
    private Matriz matriz;
    
    public CeldaReferencia(String contenido, Matriz matriz) {
        super(contenido);
        this.matriz = matriz;
    }
    
    @Override
    public String getValor() {
        try {
            int fila = Integer.parseInt(contenido.substring(1)) - 1;
            int columna = contenido.charAt(0) - 'A';
            
            if (fila < 0 || columna < 0 || fila >= matriz.getFilas() || columna >= matriz.getColumnas()) { 
                return "#REF!";
            }
            
            Celda celdaReferenciada = matriz.getCelda(fila, columna);
            if (celdaReferenciada == null) {
                return "";
            }
            
            if (celdaReferenciada instanceof CeldaReferencia && 
                ((CeldaReferencia) celdaReferenciada).getContenido().equals(this.contenido)) {
                return "#CIRCULAR!";
            }
            
            return celdaReferenciada.getValor();
        } catch (Exception e) {
            return "#ERROR";
        }
    }
}