[![](https://img.shields.io/badge/-Inicio-FFF?style=flat&logo=Emlakjet&logoColor=black)](/README.md) [![](https://img.shields.io/badge/-Entrega_1-FFF?style=flat&logo=openstreetmap&logoColor=black)](/documentos/entregas.d.md) [![](https://img.shields.io/badge/-Entrega_2-FFF?style=flat&logo=openstreetmap&logoColor=black)](/documentos/entregas.dM.md)  [![](https://img.shields.io/badge/-Entrega_3-FFF?style=flat&logo=openstreetmap&logoColor=black)](/documentos/entregas.dOO.md)  [![](https://img.shields.io/badge/-Entrega_4-FFF?style=flat&logo=openstreetmap&logoColor=black)]()


# Diseño modular - Versión 2 (src-v002)

## 1. *Jerarquización del Proyecto*

<div align=center>

| Diagrama de Clases|
|-|
|![Diagrama](/images/modelosUML/DiagramaClasesSrc2.svg)| !

</div>

## 📦 Estructura

| Paquete        | Propósito                                                              |
|----------------|------------------------------------------------------------------------|
| `modelo`       | Contiene las clases que representan los datos de la aplicación         |
| `vista`        | Agrupa las clases responsables de la presentación visual               |
| `controlador`  | Incluye las clases que gestionan la lógica y el flujo de la aplicación |
| `util`         | Proporciona utilidades y constantes compartidas                        |

---

## 🧱 Clases por Módulo

### Modelo

| Clase                                         | Depende de / Usa | Descripción                                                       |
|----------------------------------------------|------------------|-------------------------------------------------------------------|
| [`Celda`](src-v002/modelo/Celda.java)        | -                | Representa una celda individual con contenido completo y visible. |
| [`Posicion`](src-v002/modelo/Posicion.java)  | -                | Controla la fila y columna actual del cursor en la hoja.          |
| [`Matriz`](src-v002/modelo/Matriz.java)      | `Celda`          | Composición de celdas, estructura completa de la hoja.            |

---

### Vista

| Clase                                                           | Depende de / Usa             | Descripción                                                                 |
|------------------------------------------------------------------|------------------------------|-----------------------------------------------------------------------------|
| [`InterfazUsuario`](src-v002/vista/InterfazUsuario.java)        | `Teclado`, `VisualizadorHoja` | Coordina los componentes visuales y la interacción con el usuario.         |
| [`VisualizadorHoja`](src-v002/vista/VisualizadorHoja.java)      | `Matriz`, `Posicion`, `Utilidades` | Muestra la hoja de cálculo y los datos en pantalla.                  |

---

### Controlador

| Clase                                                               | Depende de / Usa                  | Descripción                                                              |
|---------------------------------------------------------------------|-----------------------------------|--------------------------------------------------------------------------|
| [`ControladorHoja`](src-v002/controlador/ControladorHoja.java)     | `Matriz`, `Posicion`, `Constantes`| Gestiona la lógica de negocio y comandos del usuario.                    |
| [`Teclado`](src-v002/controlador/Teclado.java)                     | -                                 | Maneja la entrada del usuario desde consola.                             |

---

### Util

| Clase                                           | Depende de / Usa | Descripción                                                              |
|--------------------------------------------------|------------------|--------------------------------------------------------------------------|
| [`Constantes`](src-v002/util/Constantes.java)   | -                | Centraliza las constantes utilizadas por toda la aplicación.             |
| [`Utilidades`](src-v002/util/Utilidades.java)   | `Constantes`     | Métodos de utilidad comunes para diferentes componentes del proyecto.    |

---

### 🧠 Clase Principal

| Clase                                     | Depende de/ Usa                                             | Descripción                                                               |
|------------------------------------------|--------------------------------------------------------------|---------------------------------------------------------------------------|
| [`HojaCalculo`](src-v002/HojaCalculo.java) | `Matriz`, `Posicion`, `InterfazUsuario`, `ControladorHoja`  | Clase principal que coordina los componentes MVC y el ciclo de ejecución.|

---

## ✅ Cumplimiento de Principios Fundamentales

| Principio         | Cumplimiento   | Observaciones                                                              |
|------------------|----------------|-----------------------------------------------------------------------------|
| Alta Cohesión     | ✅ Excelente    | Responsabilidades claramente separadas por paquetes.                        |
| Bajo Acoplamiento | ✅ Excelente    | Dependencias minimizadas gracias a la arquitectura MVC.                     |
| Tamaño Adecuado   | ✅ Excelente    | Clases enfocadas en una única responsabilidad.                              |

---

## 🔍 Análisis del Acoplamiento

- **Acoplamiento por datos**: Comunicación entre clases a través de estructuras bien definidas.
- **Acoplamiento por interfaz**: Interacción mediante métodos públicos, sin dependencia en implementaciones internas.
- **Separación de responsabilidades**: Cada clase pertenece a una capa específica (modelo, vista o controlador).
- **Utilidades externas**: Centralización de constantes y funciones reutilizables en clases utilitarias.

---

## 🧪 Análisis Detallado

| Componente     | Cohesión       | Acoplamiento | Tamaño  | Fortalezas                                                                 |
|----------------|----------------|--------------|---------|----------------------------------------------------------------------------|
| **Modelo**     | ✅ Funcional    | ✅ Bajo       | ✅ Adecuado | Datos encapsulados, sin lógica de presentación ni control.                 |
| **Vista**      | ✅ Funcional    | ✅ Bajo       | ✅ Adecuado | Solo presentación e interacción, sin lógica de negocio.                    |
| **Controlador**| ✅ Funcional    | ✅ Bajo       | ✅ Adecuado | Orquesta el flujo de la app, mantiene modelo y vista desacoplados.        |
| **Util** | ✅ Funcional    | ✅ Bajo       | ✅ Adecuado | Reutilización y centralización de lógica común.                            |

---

## ⚖ Comparativa de Versiones

| Aspecto              | Versión 1 (src-v001)     | Versión 2 (src-v002)         |
|----------------------|--------------------------|-------------------------------|
| Arquitectura         | Jerárquica monolítica     | Patrón MVC                   |
| Cohesión             | Aceptable                | Excelente                     |
| Acoplamiento         | Moderado/Alto            | Bajo                          |
| Mantenibilidad       | Media                    | Alta                          |
| Extensibilidad       | Limitada                 | Mejorada                      |
| Reutilización        | Baja                     | Alta                          |

---

## Mejoras `src-v002`

1. **Separación clara de responsabilidades** mediante Modelo, Vista y Controlador.
2. **Modularización con paquetes** que favorecen la navegación y mantenibilidad.
3. **Menor acoplamiento** entre componentes.
4. **Centralización de constantes y utilidades** para evitar duplicación.
5. **Clases especializadas** en tareas concretas y bien acotadas.
6. **Mayor cohesión**: cada clase cumple un único propósito definido.

