[![](https://img.shields.io/badge/-Inicio-FFF?style=flat&logo=Emlakjet&logoColor=black)](/README.md) [![](https://img.shields.io/badge/-Entrega_1-FFF?style=flat&logo=openstreetmap&logoColor=black)](/documentos/entregas.d.md) [![](https://img.shields.io/badge/-Entrega_2-FFF?style=flat&logo=openstreetmap&logoColor=black)](/documentos/entregas.dM.md)  [![](https://img.shields.io/badge/-Entrega_3-FFF?style=flat&logo=openstreetmap&logoColor=black)](/documentos/entregas.dOO.md)  [![](https://img.shields.io/badge/-Entrega_4-FFF?style=flat&logo=openstreetmap&logoColor=black)]()


# Diseño modular

## 1. **Jerarquización del Proyecto**

<div align=center>

| Diagrama de Clases|
|-|
|![Jerarquizacion](/images/modelosUML/DiseñoModular.svg)| !

</div>

El proyecto de la hoja de cálculo presenta una jerarquización **botton-up (ascendente)**, ya que se empiezan por los componentes más básicos (Celda, Posición, Teclado) y posteriormente se combinan para formar estructuras más complejas como (Matriz, interfazUsuario y HojaCalculo). Cumple con los principios de jerarquización de ser un proyecto acíclico, direccional, estable y encapsulado.

### Clases

**🧱 Nivel Básico**

| Clase                          | Depende de / Usa | Descripción                                                       |
|--------------------------------|------------------|-------------------------------------------------------------------|
| [Celda](/src/Celda.java)       | -                | Representa una celda individual con contenido completo y visible. |
| [Posicion](/src/Posicion.java) | -                | Controla la fila y columna actual del cursor en la hoja.          |
| [Teclado](/src/Teclado.java)   | -                | Gestiona la entrada del usuario desde consola.                    |

**🧩 Nivel Medio**

| Clase                                        | Depende de / Usa                | Descripción                                                           |
|----------------------------------------------|---------------------------------|-----------------------------------------------------------------------|
| [Matriz](/src/Matriz.java)                   | `Celda`                         | Composición de celdas, estructura completa de la hoja.                |
| [InterfazUsuario](/src/InterfazUsuario.java) | `Teclado`, `Matriz`, `Posicion` | Controla la visualización de la hoja y la interacción con el usuario. |

**🧠 Nivel Alto**

| Clase                                | Depende de / Usa                        | Descripción                                                            |
|--------------------------------------|-----------------------------------------|------------------------------------------------------------------------|
| [HojaCalculo](/src/HojaCalculo.java) | `Matriz`, `Posicion`, `InterfazUsuario` | Clase principal que coordina todo el proyecto y su ciclo de ejecución. |

**🧬 Herencia**

| Clase                                      | Depende de / Usa | Descripción                                                                 |
|--------------------------------------------|------------------|-----------------------------------------------------------------------------|
| [ComponenteHoja](/src/ComponenteHoja.java) | -                | Clase base abstracta que provee constantes y utilidades a las demás clases. |

---

### Cumplimiento de Principios fundamentales

<div align=center>

|Principio|Cumplimiento|Observaciones|
|-|-|-|
|Alta Cohesión|✅ Bueno|Las clases tienen responsabilidades bien definidas|
|Bajo Acoplamiento|✅ Bueno|Dependencias claras y limitadas|
|Tamaño Adecuado|⚠️ Aceptable|Alguna clase podría dividirse|

</div>

---

### Análisis del acoplamiento
El acoplamiento es bastante bajo pero en la clase `InterfazUsuario` tiene un acoplamiento relativamente alto ya que depende de 3 clases y la clase `HojaCalculo` depende de varios componentes pero es normal debido a ser la clase principal que coordina todo el proyecto. 

Los tipos de acoplamiento que hay en el proyecto son **directo**, ya que todas las dependencias son explícitas y necesarias y **por mensaje**, mediante la llamada a métodos.


## 2. **Análisis detallado por clases**

> [!NOTE]  
> Cohesión: ✅ Alta; 〽️ Moderada; ❌ Baja<br>
>  Acoplamiento: ✅ Bajo; 〽️ Moderado; ❌ Alto<br>
> Tamaño: ✅ Excelente; 〽️ Adecuado; ❌ Grande


<div align=center>

| Clase    | Cohesión       | Acoplamiento | Tamaño     | Fortalezas     |
|--------------------|----------------|--------------|------------|----------|
| **ComponenteHoja** | ✅ (funcional) | ✅         | 〽️   | - Base común para todas<br>- Encapsula constantes<br>- Métodos utilitarios |
| **Celda**          | ✅ (funcional) | ✅         | ✅  | - Responsabilidad única clara<br>- Buen encapsulamiento<br>- Métodos cohesivos |
| **Posicion**       | ✅ (funcional) | ✅         | ✅  | - Manejo perfecto de posición<br>- Validación de límites<br>- Movimiento claro |
| **Teclado**        | ✅ (funcional) | 〽️     | 〽️   | - Encapsula interacción<br>- Tipos de entrada definidos<br>- Cierre recursos |
| **Matriz**         | ✅ (funcional) | 〽️     | 〽️   | - Gestión bidimensional<br>- Inicialización adecuada<br>- Acceso controlado  |
| **InterfazUsuario**| 〽️ (comunicacional) | ❌ | ❌     | - Encapsula visualización<br>- Formato claro<br>- Separa modelo-vista       |
| **HojaCalculo**    | ✅ (funcional) | 〽️     | 〽️   | - Punto de entrada claro<br>- Ciclo de vida definido<br>- Delega bien       |

</div>
