[![](https://img.shields.io/badge/-Inicio-FFF?style=flat&logo=Emlakjet&logoColor=black)](/README.md) [![](https://img.shields.io/badge/-Entrega_1-FFF?style=flat&logo=openstreetmap&logoColor=black)](https://github.com/oscarsantasanchez/24-25-IdSw2-SDD/blob/main/documentos/entregas.d.md) [![](https://img.shields.io/badge/-Entrega_2-FFF?style=flat&logo=openstreetmap&logoColor=black)](https://github.com/oscarsantasanchez/24-25-IdSw2-SDD/blob/main/documentos/entregas.dM.md)  [![](https://img.shields.io/badge/-Entrega_3-FFF?style=flat&logo=openstreetmap&logoColor=black)](https://github.com/oscarsantasanchez/24-25-IdSw2-SDD/blob/entrega3/documentos/entregas.dOO.md)  [![](https://img.shields.io/badge/-Entrega_4-FFF?style=flat&logo=openstreetmap&logoColor=black)]()


# 🧩 Diseño Modular (DM)

Este documento resume los cambios clave realizados respecto a la versión anterior (`src-v001`), presentando una arquitectura escalable y mantenible basada en el patrón **MVC (Modelo-Vista-Controlador)**.

## 🔄 0. Diferencias con la versión anterior (`src-v001`)

### Cambios arquitectónicos

- Aplicación del patrón **MVC**:
  - **Modelo:** `Celda`, `Matriz`, `Posicion`
  - **Vista:** `VisualizadorHoja`, `InterfazUsuario`
  - **Controlador:** `ControladorHoja`, `Teclado`

- Organización por paquetes:
  - `modelo`, `vista`, `controlador`, `util`
  - Mejora en la separación de responsabilidades

---

### Eliminación de herencia innecesaria

- Se elimina `ComponenteHoja` como clase base universal
- Se reemplaza por composición, interfaces y utilidades compartidas

---

### Módulos más pequeños y especializados

- Cada clase tiene una única responsabilidad
- Código más limpio, mantenible y preparado para ampliaciones

## 🧠 1. Diseño Modular y Estructura MVC

### Objetivo

Adoptar una arquitectura que favorezca la **extensibilidad**, **mantenibilidad** y **claridad funcional**.

| Capa        | Clases Principales                                   | Descripción                                                             |
|-------------|-------------------------------------------------------|-------------------------------------------------------------------------|
| **Modelo**  | `Celda`, `Matriz`, `Posicion`                         | Representan los datos y su lógica interna                              |
| **Vista**   | `InterfazUsuario`, `VisualizadorHoja`                | Encargadas de mostrar la hoja y gestionar la interacción visual        |
| **Controlador**| `ControladorHoja`, `Teclado`                      | Controlan el flujo y la lógica del programa                            |
| **Utilidades**| `Utilidades`, `Constantes`                         | Funciones auxiliares y constantes de uso común                         |

## 🧱 2. Jerarquía de Clases

### Nivel Básico

| Clase       | Usa / Depende de | Descripción                                  |
|-------------|------------------|----------------------------------------------|
| `Celda`     | -                | Unidad mínima de datos en la hoja            |
| `Posicion`  | -                | Controla la ubicación del cursor             |
| `Teclado`   | -                | Entrada del usuario desde consola            |

---

### Nivel Medio

| Clase             | Usa                                 | Descripción                                 |
|------------------|--------------------------------------|---------------------------------------------|
| `Matriz`         | `Celda`                              | Estructura bidimensional de celdas          |
| `InterfazUsuario`| `Teclado`, `Matriz`, `Posicion`      | Visualiza la hoja e interactúa con el usuario |

---

### Nivel Alto

| Clase              | Usa                                                       | Descripción                                     |
|--------------------|-----------------------------------------------------------|-------------------------------------------------|
| `HojaCalculo`      | `Matriz`, `Posicion`, `InterfazUsuario`                   | Orquesta el ciclo de vida de la aplicación     |
| `VisualizadorHoja` | `Matriz`                                                  | Encargada de mostrar la hoja en pantalla       |
| `ControladorHoja`  | `Teclado`, `InterfazUsuario`, `VisualizadorHoja`          | Gestiona los comandos e interacciones principales |

---

### Utilidades

| Clase        | Función                     | Uso principal                  |
|--------------|-----------------------------|--------------------------------|
| `Utilidades` | Métodos auxiliares comunes  | Reutilizados por varias clases |
| `Constantes` | Valores constantes globales | Refiere a tamaños, caracteres, etc. |

## 🧬 3. Diagrama de Clases

> ![Diagrama de clases UML](/images/modelosUML/DiagramaClasesSrc2.svg)

---

## ✅ 4. Cumplimiento de Principios Fundamentales

| Principio         | Cumplimiento   | Observaciones                                                              |
|------------------|----------------|-----------------------------------------------------------------------------|
| Alta Cohesión     | ✅ Excelente    | Responsabilidades claramente separadas por paquetes.                        |
| Bajo Acoplamiento | ✅ Excelente    | Dependencias minimizadas gracias a la arquitectura MVC.                     |
| Tamaño Adecuado   | ✅ Excelente    | Clases enfocadas en una única responsabilidad.                              |

## 🔍 5.  Análisis del Acoplamiento

- **Acoplamiento por datos**: Comunicación entre clases a través de estructuras bien definidas.
- **Acoplamiento por interfaz**: Interacción mediante métodos públicos, sin dependencia en implementaciones internas.
- **Separación de responsabilidades**: Cada clase pertenece a una capa específica (modelo, vista o controlador).
- **Utilidades externas**: Centralización de constantes y funciones reutilizables en clases utilitarias.

## 🧪 6. Análisis Detallado

| Componente     | Cohesión       | Acoplamiento | Tamaño  | Fortalezas                                                                 |
|----------------|----------------|--------------|---------|----------------------------------------------------------------------------|
| **Modelo**     | ✅ Funcional    | ✅ Bajo       | ✅ Adecuado | Datos encapsulados, sin lógica de presentación ni control.                 |
| **Vista**      | ✅ Funcional    | ✅ Bajo       | ✅ Adecuado | Solo presentación e interacción, sin lógica de negocio.                    |
| **Controlador**| ✅ Funcional    | ✅ Bajo       | ✅ Adecuado | Orquesta el flujo de la app, mantiene modelo y vista desacoplados.        |
| **Util** | ✅ Funcional    | ✅ Bajo       | ✅ Adecuado | Reutilización y centralización de lógica común.                            |

## ⚖ 7. Comparativa de Versiones

| Aspecto              | Versión 1 (src-v001)     | Versión 2 (src-v002)         |
|----------------------|--------------------------|-------------------------------|
| Arquitectura         | Jerárquica monolítica     | Patrón MVC                   |
| Cohesión             | Aceptable                | Excelente                     |
| Acoplamiento         | Moderado/Alto            | Bajo                          |
| Mantenibilidad       | Media                    | Alta                          |
| Extensibilidad       | Limitada                 | Mejorada                      |
| Reutilización        | Baja                     | Alta                          |

## 📈 8. Mejoras `src-v002`

1. **Separación clara de responsabilidades** mediante Modelo, Vista y Controlador.
2. **Modularización con paquetes** que favorecen la navegación y mantenibilidad.
3. **Menor acoplamiento** entre componentes.
4. **Centralización de constantes y utilidades** para evitar duplicación.
5. **Clases especializadas** en tareas concretas y bien acotadas.
6. **Mayor cohesión**: cada clase cumple un único propósito definido.



