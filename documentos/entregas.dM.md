[![](https://img.shields.io/badge/-Inicio-FFF?style=flat&logo=Emlakjet&logoColor=black)](/README.md) [![](https://img.shields.io/badge/-Entrega_1-FFF?style=flat&logo=openstreetmap&logoColor=black)](/documentos/entregas.d.md) [![](https://img.shields.io/badge/-Entrega_2-FFF?style=flat&logo=openstreetmap&logoColor=black)](/documentos/entregas.dM.md)  [![](https://img.shields.io/badge/-Entrega_3-FFF?style=flat&logo=openstreetmap&logoColor=black)](/documentos/entregas.dOO.md)  [![](https://img.shields.io/badge/-Entrega_4-FFF?style=flat&logo=openstreetmap&logoColor=black)]()


# Diseño modular

## 1. **Jerarquización del Proyecto**

<div align=center>

| Diagrama de Clases|
|-|
|![Jerarquizacion](/images/modelosUML/DiseñoModular.svg)| !

</div>

El proyecto de la hoja de cálculo presenta una jerarquización **botton-up (ascendente)**, ya que se empiezan por los componentes más básicos (Celda, Posición, Teclado) y posteriormente se combinan para formar estructuras más complejas como (Matriz, interfazUsuario y HojaCalculo). Cumple con los principios de jerarquización de ser un proyecto acíclico, direccional, estable y encapsulado.


- ✅ Alta cohesión  
- ✅ Baja dependencia entre capas  
- ✅ Separación clara de responsabilidades

---

## 🧱 Clases por Nivel

### **Nivel Básico**

| Clase     | Usa / Relación | Descripción                                                       |
|-----------|----------------|-------------------------------------------------------------------|
| `Celda`   | -              | Unidad mínima de datos de la hoja.                               |
| `Posicion`| -              | Controla la ubicación del cursor en la hoja.                     |
| `Teclado` | -              | Gestiona entrada de usuario desde consola.                       |

---

### **Nivel Medio**

| Clase             | Usa / Relación                      | Descripción                                                       |
|------------------|--------------------------------------|-------------------------------------------------------------------|
| `Matriz`         | Usa `Celda`                          | Estructura principal que contiene las celdas.                     |
| `InterfazUsuario`| Usa `Teclado`, `Matriz`, `Posicion`  | Interfaz de entrada/salida y visualización.                      |

---

### **Nivel Alto**

| Clase              | Usa / Relación                                      | Descripción                                                       |
|--------------------|------------------------------------------------------|-------------------------------------------------------------------|
| `HojaCalculo`      | Contiene `Matriz`, `Posicion`, `InterfazUsuario`    | Clase orquestadora de toda la ejecución de la hoja.              |
| `VisualizadorHoja` | Usa `Matriz`                                        | Encargada exclusivamente de mostrar visualmente la hoja.         |
| `ControladorHoja`  | Usa `Teclado`, `InterfazUsuario`, `VisualizadorHoja`| Controlador principal del flujo y lógica de operaciones.         |

---

### **Utilidades**

| Clase         | Función                          | Uso                          |
|---------------|----------------------------------|------------------------------|
| `Utilidades`  | Métodos auxiliares comunes       | Usados por múltiples clases |
| `Constantes`  | Almacén central de constantes    | Referenciado globalmente    |

---

## 🧬 Diagrama de Clases

> A continuación se muestra la arquitectura visual con sus relaciones:

|![Diagrama](/images/modelosUML/DiagramaClasesSrc2.svg)| !

---

## 📈 Cumplimiento de Principios

| Principio           | Cumplimiento | Observaciones                                             |
|---------------------|--------------|-----------------------------------------------------------|
| **Alta Cohesión**   | ✅ Bueno     | Cada clase tiene responsabilidades claras y únicas       |
| **Bajo Acoplamiento**| ✅ Bueno    | Interacción bien definida, dependencias controladas       |
| **Tamaño Adecuado** | ⚠️ Aceptable | Algunas clases podrían dividirse o simplificarse aún más  |

---

## 🔍 Análisis del Acoplamiento

- El proyecto mantiene un acoplamiento **directo y por mensaje**, explícito y necesario.
- La clase `InterfazUsuario` tiene un nivel de dependencia **alto**, pero está justificado por su rol integrador.
- `HojaCalculo`, como clase principal, depende de varios módulos, lo cual es esperado.

---

## 🧪 Análisis Detallado por Clase

| Clase              | Cohesión       | Acoplamiento | Tamaño | Fortalezas                                                                 |
|--------------------|----------------|--------------|--------|----------------------------------------------------------------------------|
| `Celda`            | ✅ Funcional   | ✅ Bajo       | ✅     | Unidad clara, bien encapsulada                                             |
| `Posicion`         | ✅ Funcional   | ✅ Bajo       | ✅     | Control preciso de posición y validación                                  |
| `Teclado`          | ✅ Funcional   | 〽️ Medio     | 〽️    | Entrada robusta, manejo de recursos                                        |
| `Matriz`           | ✅ Funcional   | 〽️ Medio     | 〽️    | Estructura organizada, composición adecuada                                |
| `InterfazUsuario`  | 〽️ Comunicacional | ❌ Alto | ❌     | Función crítica, pero mejora posible dividiendo responsabilidades         |
| `VisualizadorHoja` | ✅ Funcional   | ✅ Bajo       | ✅     | Separa claramente la visualización                                         |
| `HojaCalculo`      | ✅ Funcional   | 〽️ Medio     | 〽️    | Orquestación efectiva, buen manejo del ciclo de vida                      |
| `ControladorHoja`  | ✅ Funcional   | ✅ Bajo       | ✅     | Control central, bajo acoplamiento, composición clara                     |

<sup>✅ Excelente</sup>  
<sup>〽️ Aceptable</sup>  
<sup>❌ Mejorable</sup>

---

</div>
