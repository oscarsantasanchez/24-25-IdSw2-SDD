[![](https://img.shields.io/badge/-Inicio-FFF?style=flat&logo=Emlakjet&logoColor=black)](/README.md) [![](https://img.shields.io/badge/-Entrega_1-FFF?style=flat&logo=openstreetmap&logoColor=black)](/documentos/entregas.d.md) [![](https://img.shields.io/badge/-Entrega_2-FFF?style=flat&logo=openstreetmap&logoColor=black)](/documentos/entregas.dM.md)  [![](https://img.shields.io/badge/-Entrega_3-FFF?style=flat&logo=openstreetmap&logoColor=black)](/documentos/entregas.dOO.md)  [![](https://img.shields.io/badge/-Entrega_4-FFF?style=flat&logo=openstreetmap&logoColor=black)]()

# 🧩 Hoja de Cálculo – Refactorización `src-v002`

Este documento resume los cambios clave realizados respecto a la versión anterior (`src-v001`), presentando una arquitectura escalable y mantenible basada en el patrón **MVC (Modelo-Vista-Controlador)**.

---

## 🔄 0. Diferencias con la versión anterior (`src-v001`)

### 🏗️ Cambios arquitectónicos

- ✅ Aplicación del patrón **MVC**:
  - **Modelo:** `Celda`, `Matriz`, `Posicion`
  - **Vista:** `VisualizadorHoja`, `InterfazUsuario`
  - **Controlador:** `ControladorHoja`, `Teclado`

- 📦 Organización por paquetes:
  - `modelo`, `vista`, `controlador`, `util`
  - Mejora en la separación de responsabilidades

### ❌ Eliminación de herencia innecesaria

- Se elimina `ComponenteHoja` como clase base universal
- Se reemplaza por composición, interfaces y utilidades compartidas

### 🧹 Módulos más pequeños y especializados

- Cada clase tiene una única responsabilidad
- Código más limpio, mantenible y preparado para ampliaciones

---

## 🧠 1. Diseño Modular y Estructura MVC

### 🎯 Objetivo

Adoptar una arquitectura que favorezca la **extensibilidad**, **mantenibilidad** y **claridad funcional**.

| Capa        | Clases Principales                                   | Descripción                                                             |
|-------------|-------------------------------------------------------|-------------------------------------------------------------------------|
| **Modelo**  | `Celda`, `Matriz`, `Posicion`                         | Representan los datos y su lógica interna                              |
| **Vista**   | `InterfazUsuario`, `VisualizadorHoja`                | Encargadas de mostrar la hoja y gestionar la interacción visual        |
| **Controlador**| `ControladorHoja`, `Teclado`                      | Controlan el flujo y la lógica del programa                            |
| **Utilidades**| `Utilidades`, `Constantes`                         | Funciones auxiliares y constantes de uso común                         |

---

## 🧱 2. Jerarquía de Clases

### 🔹 Nivel Básico

| Clase       | Usa / Depende de | Descripción                                  |
|-------------|------------------|----------------------------------------------|
| `Celda`     | -                | Unidad mínima de datos en la hoja            |
| `Posicion`  | -                | Controla la ubicación del cursor             |
| `Teclado`   | -                | Entrada del usuario desde consola            |

---

### 🔸 Nivel Medio

| Clase             | Usa                                 | Descripción                                 |
|------------------|--------------------------------------|---------------------------------------------|
| `Matriz`         | `Celda`                              | Estructura bidimensional de celdas          |
| `InterfazUsuario`| `Teclado`, `Matriz`, `Posicion`      | Visualiza la hoja e interactúa con el usuario |

---

### 🔺 Nivel Alto

| Clase              | Usa                                                       | Descripción                                     |
|--------------------|-----------------------------------------------------------|-------------------------------------------------|
| `HojaCalculo`      | `Matriz`, `Posicion`, `InterfazUsuario`                   | Orquesta el ciclo de vida de la aplicación     |
| `VisualizadorHoja` | `Matriz`                                                  | Encargada de mostrar la hoja en pantalla       |
| `ControladorHoja`  | `Teclado`, `InterfazUsuario`, `VisualizadorHoja`          | Gestiona los comandos e interacciones principales |

---

### ⚙️ Utilidades

| Clase        | Función                     | Uso principal                  |
|--------------|-----------------------------|--------------------------------|
| `Utilidades` | Métodos auxiliares comunes  | Reutilizados por varias clases |
| `Constantes` | Valores constantes globales | Refiere a tamaños, caracteres, etc. |

---

## 🧬 3. Diagrama de Clases

> ![Diagrama de clases UML](/images/modelosUML/DiagramaClasesSrc2.svg)

---

## 📊 4. Cumplimiento de Principios

| Principio             | Evaluación | Comentario                                          |
|-----------------------|------------|-----------------------------------------------------|
| **Alta Cohesión**     | ✅ Buena   | Clases con responsabilidades bien definidas         |
| **Bajo Acoplamiento** | ✅ Buena   | Dependencias claras, interfaces explícitas          |
| **Tamaño Adecuado**   | ⚠️ Aceptable | Algunas clases aún pueden refactorizarse más        |

---

## 🧪 5. Análisis por Clase

| Clase              | Cohesión       | Acoplamiento | Tamaño | Fortalezas                                                                    |
|--------------------|----------------|--------------|--------|-------------------------------------------------------------------------------|
| `Celda`            | ✅ Funcional   | ✅ Bajo       | ✅     | Unidad clara, bien encapsulada                                                |
| `Posicion`         | ✅ Funcional   | ✅ Bajo       | ✅     | Control preciso de posición y validación                                     |
| `Teclado`          | ✅ Funcional   | 〽️ Medio     | 〽️    | Entrada robusta, manejo de errores y recursos                                 |
| `Matriz`           | ✅ Funcional   | 〽️ Medio     | 〽️    | Gestión estructurada, acceso controlado                                       |
| `InterfazUsuario`  | 〽️ Comunicacional | 〽️ Medio | 〽️     | Puede refactorizarse para reducir dependencias                                |
| `VisualizadorHoja` | ✅ Funcional   | ✅ Bajo       | ✅     | Separa claramente la visualización de la lógica                               |
| `HojaCalculo`      | ✅ Funcional   | 〽️ Medio     | 〽️    | Buena delegación y estructura general                                         |
| `ControladorHoja`  | ✅ Funcional   | ✅ Bajo       | ✅     | Orquestador claro, buen uso de composición y control de flujo                 |

<sup>✅ Excelente</sup>  
<sup>〽️ Aceptable</sup>  
<sup>❌ Mejorable</sup>

---



