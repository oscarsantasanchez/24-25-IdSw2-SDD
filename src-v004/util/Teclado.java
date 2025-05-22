package util;

import java.util.Scanner;
import modelo.Celda;

public class Teclado {
    private Scanner scanner;
    
    public Teclado() {
        scanner = new Scanner(System.in);
    }
    
    public char leerComando() {
        String linea = scanner.nextLine().trim().toLowerCase();
        if (linea.isEmpty()) {
            return ' ';
        }
        return linea.charAt(0);
    }
    
    public String editarCelda(Celda celda) {
        System.out.print("Editar [" + celda.getContenido() + "]: ");
        String nuevoContenido = scanner.nextLine();
        
        if (nuevoContenido.isEmpty()) {
            return celda.getContenido();
        }
        
        return nuevoContenido;
    }
    
    public void cerrar() {
        scanner.close();
    }
}