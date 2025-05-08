[![](https://img.shields.io/badge/-Inicio-FFF?style=flat&logo=Emlakjet&logoColor=black)](/README.md) [![](https://img.shields.io/badge/-Entrega_1-FFF?style=flat&logo=openstreetmap&logoColor=black)](https://github.com/oscarsantasanchez/24-25-IdSw2-SDD/blob/main/documentos/entregas.d.md) [![](https://img.shields.io/badge/-Entrega_2-FFF?style=flat&logo=openstreetmap&logoColor=black)](https://github.com/oscarsantasanchez/24-25-IdSw2-SDD/blob/main/documentos/entregas.dM.md)  [![](https://img.shields.io/badge/-Entrega_3-FFF?style=flat&logo=openstreetmap&logoColor=black)](https://github.com/oscarsantasanchez/24-25-IdSw2-SDD/blob/entrega3/documentos/entregas.dOO.md)  [![](https://img.shields.io/badge/-Entrega_4-FFF?style=flat&logo=openstreetmap&logoColor=black)]()

# 🧬 Diseño Orientado a Objetos (DOO)

## 1. Principios Aplicados en src-v002

| Principio | Aplicación en el Proyecto | Ejemplo en src-v002 |
|-----------|---------------------------|---------------------|
| Abstracción | Clases que representan conceptos del dominio | `Celda` abstrae el concepto de una celda en una hoja de cálculo |
| Encapsulación | Atributos privados con métodos accesores | `Celda` encapsula su contenido con getters y setters |
| Herencia | Jerarquía de clases base y especializadas | Reemplazada por composición en esta versión |
| Polimorfismo | Métodos con implementaciones específicas | Diferentes implementaciones de visualización |

## 2. 🔍 Principios SOLID en src-v002

### S - Principio de Responsabilidad Única (SRP)

Cada clase tiene una única responsabilidad bien definida:

| Clase | Responsabilidad Única |
|-------|------------------------|
| `Celda` | Gestionar el contenido de una celda individual |
| `Matriz` | Administrar la estructura bidimensional de celdas |
| `Posicion` | Controlar la ubicación del cursor en la matriz |
| `InterfazUsuario` | Manejar la interacción con el usuario |

**Ejemplo de código:**
```java
// En Celda.java
public void setContenido(String contenido) {
    this.contenidoCompleto = contenido;
    this.contenidoVisible = Utilidades.formatearContenido(contenido);
}
````
### O - Principio de Abierto/Cerrado (OCP)

El diseño permite extender funcionalidades sin modificar el código existente:

| Componente | Extensibilidad |
|------------|----------------|
| Modelo | Nuevos tipos de celdas pueden añadirse sin modificar la estructura base |
| Vista | Nuevas visualizaciones pueden implementarse sin alterar el modelo |
| Controlador | Nuevos comandos pueden agregarse sin cambiar la lógica principal |

### L - Principio de Sustitución de Liskov (LSP)

Las clases derivadas pueden sustituir a sus clases base sin alterar el comportamiento:

| Relación | Cumplimiento LSP |
|----------|------------------|
| Componentes MVC | Cada componente puede ser reemplazado por una implementación alternativa |

### I - Principio de Segregación de Interfaces (ISP)

Las interfaces son específicas para cada cliente, evitando dependencias innecesarias:

| Interfaz/Clase | Segregación |
|----------------|-------------|
| Controladores | Exponen solo los métodos necesarios para sus clientes |
| Visualizadores | Implementan solo las funcionalidades que necesitan |

### D - Principio de Inversión de Dependencias (DIP)

Las dependencias se establecen hacia abstracciones, no implementaciones concretas:

| Componente | Inversión de Dependencias |
|------------|---------------------------|
| Controladores | Dependen de interfaces abstractas, no de implementaciones específicas |
| Modelo | Proporciona interfaces para que las vistas accedan a los datos |

## 3. 🔗 Relaciones entre Clases en src-v002

| Tipo | Clases Involucradas | Descripción |
|------|---------------------|-------------|
| Composición | `Matriz` → `Celda` | La matriz contiene y es responsable del ciclo de vida de las celdas |
| Agregación | `HojaCalculo` → `Matriz` | La hoja de cálculo utiliza una matriz pero no controla su ciclo de vida |
| Asociación | `InterfazUsuario` ↔ `Teclado` | La interfaz de usuario utiliza el teclado para la entrada |

**Ejemplo de código:**
```java
// En Matriz.java
public Celda getCelda(int fila, int columna) {
    return celdas[fila][columna];
}
```

## 4. 🛠️ Patrones de Diseño Implementados

| Patrón | Aplicación | Beneficio |
|--------|------------|-----------|
| Singleton | `Teclado` (una única instancia) | Control centralizado de entrada |
| Observer | Actualización de la vista al modificar celdas | Sincronización modelo-vista |
| Factory | Creación de celdas con diferentes formatos | Extensibilidad de tipos |
| MVC | Separación en Modelo, Vista y Controlador | Mantenibilidad y extensibilidad |

## 5. ✅ Cumplimiento de Principios SOLID

| Principio | Cumplimiento | Ejemplo |
|-----------|--------------|---------|
| SRP | 🟢 90% | Cada clase tiene una única responsabilidad bien definida |
| OCP | 🟢 85% | Estructura que permite extensiones sin modificar código existente |
| LSP | 🟢 80% | Componentes sustituibles dentro de su jerarquía |
| ISP | 🟡 75% | Algunas interfaces podrían ser más específicas |
| DIP | 🟢 85% | Dependencias principalmente hacia abstracciones |

## 6. 📊 Comparativa con Versión Anterior

| Aspecto | src-v001 | src-v002 |
|---------|----------|----------|
| Principios SOLID | 🟡 Parcial | 🟢 Mejorado |
| Patrones de Diseño | 🔴 Limitados | 🟢 Implementados |
| Relaciones | 🟡 Herencia excesiva | 🟢 Composición y agregación |
| Cohesión | 🟡 Media | 🟢 Alta |
| Acoplamiento | 🔴 Alto | 🟢 Bajo |

## 7. 🚀 Mejoras en Diseño Orientado a Objetos

1. **Eliminación de herencia innecesaria** a favor de composición
2. **Mayor cohesión** en cada clase con responsabilidades bien definidas
3. **Menor acoplamiento** entre componentes
4. **Implementación de patrones de diseño** que mejoran la estructura
5. **Mejor aplicación de principios SOLID** en toda la arquitectura

<div align="center">

![Diagrama de Clases](/images/modelosUML/DiagramaClasesSrc2.svg)

</div>