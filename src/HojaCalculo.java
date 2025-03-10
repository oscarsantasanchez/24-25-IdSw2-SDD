import java.util.Scanner;

public class HojaCalculo {
    private static final int TOTAL_FILAS = 100;
    private static final int TOTAL_COLUMNAS = 28;
    private static final int VISIBLE_FILAS = 15;
    private static final int VISIBLE_COLUMNAS = 9;
    private static final int ANCHO_CELDA = 7;
    private static final String VACIO = "       ";

    private static String[][] hoja = new String[TOTAL_FILAS][TOTAL_COLUMNAS];
    private static String[][] contenidoCompleto = new String[TOTAL_FILAS][TOTAL_COLUMNAS];
    private static int filaActual = 0;
    private static int columnaActual = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        inicializarHoja();

        boolean ejecutando = true;
        while (ejecutando) {
            mostrarHoja();
            System.out.println("\nContenido completo de la celda seleccionada: " + contenidoCompleto[filaActual][columnaActual]);
            System.out.println("Usa W/A/S/D para mover, 'e' para editar, 'q' para salir:");
            char comando = scanner.next().charAt(0);

            switch (comando) {
                case 'w': if (filaActual > 0) filaActual--; break;
                case 's': if (filaActual < TOTAL_FILAS - 1) filaActual++; break;
                case 'a': if (columnaActual > 0) columnaActual--; break;
                case 'd': if (columnaActual < TOTAL_COLUMNAS - 1) columnaActual++; break;
                case 'e': editarCelda(scanner); break;
                case 'q': ejecutando = false; break;
            }
        }
        scanner.close();
        System.out.println("Programa finalizado.");
    }

    private static void inicializarHoja() {
        for (int i = 0; i < TOTAL_FILAS; i++) {
            for (int j = 0; j < TOTAL_COLUMNAS; j++) {
                hoja[i][j] = VACIO;
                contenidoCompleto[i][j] = "";
            }
        }
    }

    private static void mostrarHoja() {
        System.out.println("\033[H\033[2J"); 
        System.out.flush();

        System.out.print("      ");
        for (int j = columnaActual; j < columnaActual + VISIBLE_COLUMNAS && j < TOTAL_COLUMNAS; j++) {
            System.out.printf(" %-7s ", (char) ('A' + j));
        }
        System.out.println();

        for (int i = filaActual; i < filaActual + VISIBLE_FILAS && i < TOTAL_FILAS; i++) {
            System.out.printf("%4d  ", i + 1);
            for (int j = columnaActual; j < columnaActual + VISIBLE_COLUMNAS && j < TOTAL_COLUMNAS; j++) {
                String contenidoVisible = hoja[i][j];
                if (i == filaActual && j == columnaActual) {
                    System.out.print("[" + contenidoVisible + "] ");
                } else {
                    System.out.print(" " + contenidoVisible + "  ");
                }
            }
            System.out.println();
        }
    }

    private static void editarCelda(Scanner scanner) {
        System.out.print("Ingrese valor para la celda: ");
        scanner.nextLine();
        String entrada = scanner.nextLine();

        contenidoCompleto[filaActual][columnaActual] = entrada;
        hoja[filaActual][columnaActual] = (entrada.length() > ANCHO_CELDA) ? entrada.substring(0, ANCHO_CELDA) : String.format("%-7s", entrada);
    }
}
