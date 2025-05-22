[![](https://img.shields.io/badge/-Inicio-FFF?style=flat&logo=Emlakjet&logoColor=black)](/README.md) [![](https://img.shields.io/badge/-Entrega_1-FFF?style=flat&logo=openstreetmap&logoColor=black)](https://github.com/oscarsantasanchez/24-25-IdSw2-SDD/blob/main/documentos/entregas.d.md) [![](https://img.shields.io/badge/-Entrega_2-FFF?style=flat&logo=openstreetmap&logoColor=black)](https://github.com/oscarsantasanchez/24-25-IdSw2-SDD/blob/main/documentos/entregas.dM.md)  [![](https://img.shields.io/badge/-Entrega_3-FFF?style=flat&logo=openstreetmap&logoColor=black)](https://github.com/oscarsantasanchez/24-25-IdSw2-SDD/blob/entrega3/documentos/entrega3.md)  [![](https://img.shields.io/badge/-Entrega_4-FFF?style=flat&logo=openstreetmap&logoColor=black)](https://github.com/oscarsantasanchez/24-25-IdSw2-SDD/blob/entrega3/documentos/entregaFinal.md)

# Entrega Final

### Diagrama de Clases Final
![Diagrama de Clases](/images/modelosUML/DiagramaClases4.svg)


## 📁 Cambios Estructurales

| Elemento Modificado        | Cambio Realizado                                                                 |
|---------------------------|----------------------------------------------------------------------------------|
|  `Teclado`           | Se ha movido de la carpeta `controlador` a la carpeta `util`.                  |
| `InterfazUsuario`    | Ya no recibe `matriz` ni `posición` como parámetros, ahora se obtiene del `Controlador`. |
| `Posicion`| Métodos de movimiento ahora devuelven `boolean` en lugar de ser `void`. Esto mejora la claridad en expresiones `switch`. |

## ⚙️ Nuevas Funcionalidades

Se han añadido tres nuevos tipos de celdas que se seleccionan automáticamente al editar el contenido:

| Tipo de Celda     | Identificación Automática                     | Ejemplo de Contenido |
|-------------------|-----------------------------------------------|----------------------|
| CeldaFórmula     | El contenido comienza con `=`                 | `=SUMA(A1:B2)`       |
| CeldaReferencia  | Comienza con una letra seguida de un número   | `A1`, `B3`, `C10`    |
| CeldaTexto       | Cualquier otro contenido                      | `Hola mundo`         |

### 🧠 Lógica de Selección Automática

Al editar el contenido de una celda:
- Si comienza con `=`, se asigna como **Celda Fórmula**.
- Si coincide con el patrón de referencia (`[A-Za-z]+[0-9]+`), se asigna como **Celda Referencia**.
- En cualquier otro caso, se asigna como **Celda Texto**.

