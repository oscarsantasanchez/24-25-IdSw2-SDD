# Diseño

- Proyecto desarrollado siguiendo las directrices de lo visto en el apartado de [Diseño](https://github.com/mmasias/IdSw2/blob/main/temario/01-dise%C3%B1o/README.md).

El proyecto abordado el es de la [hoja de cálculo](https://github.com/puntoReflex/pyHojaDeCalculo/blob/main/enunciado.md) que tiene las siguientes indicaciones:

| *ID* | *Indicación* |
|-|-|
| 1 | La hoja de cálculo debe mostrar 15 filas por 9 columnas. |
| 2 | Debe tener, además, 28 columnas y 100 filas |
| 3 | La navegación mediante w/a/s/d |
| 4 | Para ingresar un valor, se debe utilizar el comando e |
| 5 | Para terminar, utilizar el comando q |
| 6 | Las celdas deben tener un ancho de 7 caracteres. |
| 7 | En caso que el usuario ingrese contenido de más de 7 caracteres, se deben mostrar los 7 primeros caracteres |

En base a estas reglas se ha generado un modelo del dominio de forma muy simple que sería el que se muestra a continuación
<div align=center>

![Modelo del Dominio](/images/modelosUML/ModeloDominio.svg)

</div>


- **HojaCalculo:** Representa la hoja de cálculo, tiene una matriz de Celda y métodos para navegar, editar y terminar la aplicación.
- **Celda:** Almacena contenido con una restricción de 7 caracteres y proporciona métodos para acceder o modificar su contenido.
- **InterfazUsuario:** Se encarga de mostrar la hoja de cálculo y capturar la entrada del usuario.
- **Teclado:** Simula la captura de teclas como w/a/s/d, e y q para interactuar con la hoja de cálculo.