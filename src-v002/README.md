# Hoja de Cálculo - Versión 2

| Diagrama de Clases|
|-|
|![Diagrama](/images/modelosUML/DiagramaClasesSrc2.svg)| !

- El sistema `HojaDeCalculo` se estructura en paquetes MVC más utilitarios, centralizando la lógica en `ControladorHoja`.

- La clase principal `HojaCalculo` coordina `vista`, `modelo` y `control`, mientras que `ComponenteHoja` unifica la jerarquía de clases.

## Diferencias con la versión anterior (src-v001)

### Cambios en la arquitectura

1. **Implementación del patrón MVC (Modelo-Vista-Controlador)**:
   - **Modelo**: Clases que representan los datos (Celda, Matriz, Posicion)
   - **Vista**: Clases que muestran la información al usuario (InterfazUsuario, VisualizadorHoja)
   - **Controlador**: Clases que gestionan la lógica y las interacciones (ControladorHoja, Teclado)

2. **Estructura de paquetes**:
   - Organización en paquetes según responsabilidades (modelo, vista, controlador, util)
   - Mejor organización del código y separación de responsabilidades

### Mejoras en cohesión

1. **Eliminación de la clase ComponenteHoja**:
   - En la versión anterior, todas las clases heredaban de ComponenteHoja
   - Ahora cada clase tiene una única responsabilidad bien definida

2. **Separación de responsabilidades**:
   - Clase VisualizadorHoja: Encargada exclusivamente de mostrar la hoja en pantalla
   - Clase ControladorHoja: Gestiona la lógica de procesamiento de comandos
   - Clase Utilidades: Centraliza funciones de utilidad comunes
   - Clase Constantes: Centraliza todas las constantes de la aplicación

### Reducción del acoplamiento

1. **Eliminación de la herencia**:
   - Se eliminó la herencia de ComponenteHoja que creaba un acoplamiento fuerte
   - Se reemplazó por composición e importación de utilidades

2. **Uso de interfaces bien definidas**:
   - Cada clase expone solo los métodos necesarios para su uso
   - Las dependencias entre clases están claramente definidas

### Mejoras en el tamaño de los módulos

1. **Módulos más pequeños y especializados**:
   - Cada clase tiene menos responsabilidades y por tanto menos código
   - Mayor facilidad de mantenimiento y comprensión

2. **Distribución equilibrada de responsabilidades**:
   - La clase HojaCalculo ya no contiene toda la lógica
   - Las responsabilidades están distribuidas entre múltiples clases

### Otras mejoras

1. **Mayor extensibilidad**:
   - Facilidad para añadir nuevas funcionalidades sin modificar código existente
   - Estructura preparada para futuras ampliaciones

2. **Mejor mantenibilidad**:
   - Código más limpio y organizado
   - Más fácil de entender y modificar
