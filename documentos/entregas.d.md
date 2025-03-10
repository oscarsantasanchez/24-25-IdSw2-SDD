[![](https://img.shields.io/badge/-Inicio-FFF?style=flat&logo=Emlakjet&logoColor=black)](/README.md) [![](https://img.shields.io/badge/-Entrega_1-FFF?style=flat&logo=openstreetmap&logoColor=black)](/documentos/entregas.d.md) [![](https://img.shields.io/badge/-Entrega_2-FFF?style=flat&logo=openstreetmap&logoColor=black)](/documentos/entregas.dM.md)  [![](https://img.shields.io/badge/-Entrega_3-FFF?style=flat&logo=openstreetmap&logoColor=black)](/documentos/entregas.dOO.md)  [![](https://img.shields.io/badge/-Entrega_4-FFF?style=flat&logo=openstreetmap&logoColor=black)]()


# Diseño

## 1. Introducción
El diseño de este proyecto es fundamental para estructurar adecuadamente la solución, facilitando su mantenimiento y evolución.  
Al tratarse de una hoja de cálculo en consola, es esencial definir un diseño que permita:  

- Navegación fluida.  
- Almacenamiento eficiente de los datos.  
- Interfaz de usuario intuitiva dentro de una terminal.  

## 2. Análisis vs. Diseño

| **Análisis** | **Diseño** |
|-------------|----------|
| Refinamiento y estructura de requisitos para su comprensión y mantenimiento. | Desarrollo enfocado en requisitos no funcionales y dominio de la solución. |
| Especificación más precisa de los requisitos. | Consideración de aspectos técnicos como lenguajes de programación, reutilización de componentes y tecnologías involucradas. |
| Uso del lenguaje de los desarrolladores para estructurar el sistema. | Aplicación de conceptos como concurrencia, bases de datos, interfaz de usuario y gestión de transacciones. |
| Diseño suficiente (Just Enough Design Upfront vs. Big Design Upfront). | Implementación con vistas de diseño/lógica y despliegue. |

## 3. Objetivo del Diseño
El diseño busca garantizar que el sistema sea:  

- **Flexible**: Capaz de adaptarse a futuras mejoras.  
- **Escalable**: Manejo eficiente de filas y columnas.  
- **Intuitivo**: Navegación clara mediante comandos (`W/A/S/D` para moverse, `E` para editar, `Q` para salir).  
- **Estructurado**: Representación clara de la hoja de cálculo con encabezados de filas y columnas.  

## 4. Modelo del Dominio

![Modelo del Dominio](/images/modelosUML/ModeloDominio.svg)

## 5. Diagrama de estados de la hoja del cálculo

![Diagrama de Estados](/images/modelosUML/DiagramaEstados.svg)

## 6. Principios de Diseño
- Uso de **composición sobre herencia** para facilitar la reutilización.  
- **Legibilidad del código** mediante nombres descriptivos y convenciones claras.  
- **Mantenimiento y extensibilidad**, asegurando que nuevas funcionalidades puedan incorporarse sin afectar el sistema base.  
