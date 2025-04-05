[![](https://img.shields.io/badge/-Inicio-FFF?style=flat&logo=Emlakjet&logoColor=black)](/README.md) [![](https://img.shields.io/badge/-Entrega_1-FFF?style=flat&logo=openstreetmap&logoColor=black)](/documentos/entregas.d.md) [![](https://img.shields.io/badge/-Entrega_2-FFF?style=flat&logo=openstreetmap&logoColor=black)](/documentos/entregas.dM.md)  [![](https://img.shields.io/badge/-Entrega_3-FFF?style=flat&logo=openstreetmap&logoColor=black)](/documentos/entregas.dOO.md)  [![](https://img.shields.io/badge/-Entrega_4-FFF?style=flat&logo=openstreetmap&logoColor=black)]()


# Diseño modular

## 1. **Jerarquización del Proyecto**

| Diagrama de Clases|
|-|
|![Jerarquizacion](/images/modelosUML/DiseñoModular.svg)| !

El proyecto de la hoja de cálculo presenta una jerarquización **botton-up (ascendente)**, ya que se empiezan por los componentes más básicos (Celda, Posición, Teclado) y posteriormente se combinan para formar estructuras más complejas como (Matriz, interfazUsuario y HojaCalculo).

| Nivel         | Clase             | Depende de / Usa                  | Descripción                                                                 |
|---------------|------------------|-----------------------------------|-----------------------------------------------------------------------------|
| 🧱 Básico      | [Celda](/src/Celda.java)          | -                                 | Representa una celda individual con contenido completo y visible.          |
|               | [Posicion](/src/Posicion.java)       | -                                 | Controla la fila y columna actual del cursor en la hoja.                   |
|               | [Teclado](/src/Teclado.java)        | -                                 | Gestiona la entrada del usuario desde consola.                             |
| 🧩 Medio       | [Matriz](/src/Matriz.java)         | `Celda`                           | Composición de celdas, estructura completa de la hoja.                     |
|               | [InterfazUsuario](/src/InterfazUsuario.java)| `Teclado`, `Matriz`, `Posicion`   | Controla la visualización de la hoja y la interacción con el usuario.      |
| 🧠 Alto        | [HojaCalculo](/src/HojaCalculo.java)    | `Matriz`, `Posicion`, `InterfazUsuario` | Clase principal que coordina toda la aplicación y su ciclo de ejecución.   |
| 🧬 Herencia    | [ComponenteHoja](/src/ComponenteHoja.java) | -                                 | Clase base abstracta que provee constantes y utilidades a las demás clases.|


## 2. **Módulos y Clases**

### 2.1 **ComponenteHoja (Clase Base)**
- Clase abstracta que contiene constantes y métodos comunes.
- Define el tamaño de la hoja de cálculo y el formato de las celdas.
- Métodos:
  - `formatearContenido(String contenido)`: Ajusta el tamaño del contenido a una celda.
  - `limpiarPantalla()`: Borra la pantalla de la consola.

```java
public abstract class ComponenteHoja {
    protected static final int TOTAL_FILAS = 100;
    protected static final int TOTAL_COLUMNAS = 28;
    protected static final int VISIBLE_FILAS = 15;
    protected static final int VISIBLE_COLUMNAS = 9;
    protected static final int ANCHO_CELDA = 7;
    protected static final String VACIO = "       ";
    
    protected String formatearContenido(String contenido) {
        return (contenido.length() > ANCHO_CELDA) 
            ? contenido.substring(0, ANCHO_CELDA) 
            : String.format("%-" + ANCHO_CELDA + "s", contenido);
    }
    
    protected void limpiarPantalla() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
```

---
### 2.2 **Matriz (Gestor de Celdas)**
- Contiene una matriz bidimensional de `Celda`.
- Métodos:
  - `getCelda(int fila, int columna)`: Obtiene una celda específica.
  - `getTotalFilas()` y `getTotalColumnas()`: Devuelven las dimensiones de la hoja.

```java
public class Matriz extends ComponenteHoja {
    private Celda[][] celdas;
    
    public Matriz() {
        celdas = new Celda[TOTAL_FILAS][TOTAL_COLUMNAS];
        inicializarHoja();
    }
    
    private void inicializarHoja() {
        for (int i = 0; i < TOTAL_FILAS; i++) {
            for (int j = 0; j < TOTAL_COLUMNAS; j++) {
                celdas[i][j] = new Celda();
            }
        }
    }
    
    public Celda getCelda(int fila, int columna) {
        return celdas[fila][columna];
    }
}
```

---
### 2.3 **Celda (Representación de una Celda)**
- Almacena el contenido completo y su versión visible.
- Métodos:
  - `setContenido(String contenido)`: Asigna un valor a la celda.
  - `getContenidoCompleto()` y `getContenidoVisible()`.

```java
public class Celda extends ComponenteHoja {
    private String contenidoCompleto;
    private String contenidoVisible;
    
    public Celda() {
        this.contenidoCompleto = "";
        this.contenidoVisible = VACIO;
    }
    
    public void setContenido(String contenido) {
        this.contenidoCompleto = contenido;
        this.contenidoVisible = formatearContenido(contenido);
    }
}
```

---
### 2.4 **Posicion (Control de Navegación)**
- Almacena la fila y columna actuales.
- Métodos para mover la posición dentro de los límites de la hoja.

```java
public class Posicion extends ComponenteHoja {
    private int fila;
    private int columna;
    
    public Posicion() {
        this.fila = 0;
        this.columna = 0;
    }
    
    public void moverArriba() { if (fila > 0) fila--; }
    public void moverAbajo() { if (fila < TOTAL_FILAS - 1) fila++; }
    public void moverIzquierda() { if (columna > 0) columna--; }
    public void moverDerecha() { if (columna < TOTAL_COLUMNAS - 1) columna++; }
}
```

---
### 2.5 **Teclado (Manejo de Entrada del Usuario)**
- Captura comandos y valores ingresados.

```java
import java.util.Scanner;

public class Teclado extends ComponenteHoja {
    private Scanner scanner;
    
    public Teclado() {
        this.scanner = new Scanner(System.in);
    }
    
    public char leerComando() {
        return scanner.next().charAt(0);
    }
    
    public String leerEntrada(String mensaje) {
        System.out.print(mensaje);
        scanner.nextLine();
        return scanner.nextLine();
    }
}
```

---
### 2.6 **InterfazUsuario (Gestión de la Visualización)**
- Muestra la hoja de cálculo y la celda seleccionada.
- Imprime instrucciones en pantalla.

```java
public class InterfazUsuario extends ComponenteHoja {
    private Teclado teclado;
    
    public InterfazUsuario() {
        this.teclado = new Teclado();
    }
    
    public void mostrarHoja(Matriz matriz, Posicion posicion) {
        limpiarPantalla();
        
    int filaActual = posicion.getFila();
        int columnaActual = posicion.getColumna();
        
        System.out.print("      ");
        for (int j = columnaActual; j < columnaActual + VISIBLE_COLUMNAS && j < matriz.getTotalColumnas(); j++) {
            System.out.printf(" %-7s ", (char) ('A' + j));
        }
        System.out.println();
        
        for (int i = filaActual; i < filaActual + VISIBLE_FILAS && i < matriz.getTotalFilas(); i++) {
            System.out.printf("%4d  ", i + 1);
            for (int j = columnaActual; j < columnaActual + VISIBLE_COLUMNAS && j < matriz.getTotalColumnas(); j++) {
                String contenidoVisible = matriz.getCelda(i, j).getContenidoVisible();
                if (i == filaActual && j == columnaActual) {
                    System.out.print("[" + contenidoVisible + "] ");
                } else {
                    System.out.print(" " + contenidoVisible + "  ");
                }
            }
            System.out.println();
        }
    }
    
    public void mostrarInfoCelda(Matriz matriz, Posicion posicion) {
        System.out.println("\nContenido completo de la celda seleccionada: " + 
            matriz.getCelda(posicion.getFila(), posicion.getColumna()).getContenidoCompleto());
        System.out.println("Usa W/A/S/D para mover, 'e' para editar, 'q' para salir:");
    }
}
```

---
### 2.7 **HojaCalculo (Controlador Principal)**
- Contiene el `main` y ejecuta el programa.
- Controla la interacción usuario-hoja.

```java
public class HojaCalculo extends ComponenteHoja {
    private Matriz matriz;
    private Posicion posicion;
    private InterfazUsuario interfaz;
    
    public HojaCalculo() {
        this.matriz = new Matriz();
        this.posicion = new Posicion();
        this.interfaz = new InterfazUsuario();
    }
    
    public static void main(String[] args) {
        HojaCalculo hoja = new HojaCalculo();
        hoja.iniciar();
    }
    
    public void iniciar() {
        boolean ejecutando = true;
        while (ejecutando) {
            interfaz.mostrarHoja(matriz, posicion);
            char comando = interfaz.getTeclado().leerComando();
            
            switch (comando) {
                case 'w': posicion.moverArriba(); break;
                case 's': posicion.moverAbajo(); break;
                case 'a': posicion.moverIzquierda(); break;
                case 'd': posicion.moverDerecha(); break;
                case 'e': 
                    Celda celda = matriz.getCelda(posicion.getFila(), posicion.getColumna());
                    interfaz.getTeclado().editarCelda(celda);
                    break;
                case 'q': ejecutando = false; break;
            }
        }
    }
}

```
