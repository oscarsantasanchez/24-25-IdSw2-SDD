[![](https://img.shields.io/badge/-Inicio-FFF?style=flat&logo=Emlakjet&logoColor=black)](/README.md) [![](https://img.shields.io/badge/-Entrega_1-FFF?style=flat&logo=openstreetmap&logoColor=black)](https://github.com/oscarsantasanchez/24-25-IdSw2-SDD/blob/main/documentos/entregas.d.md) [![](https://img.shields.io/badge/-Entrega_2-FFF?style=flat&logo=openstreetmap&logoColor=black)](https://github.com/oscarsantasanchez/24-25-IdSw2-SDD/blob/main/documentos/entregas.dM.md)  [![](https://img.shields.io/badge/-Entrega_3-FFF?style=flat&logo=openstreetmap&logoColor=black)](https://github.com/oscarsantasanchez/24-25-IdSw2-SDD/blob/main/documentos/entrega3.md)  [![](https://img.shields.io/badge/-Entrega_4-FFF?style=flat&logo=openstreetmap&logoColor=black)](https://github.com/oscarsantasanchez/24-25-IdSw2-SDD/blob/main/documentos/entregaFinal.md)


# 🧩 Diseño (D)

## 1. 🎯 Introducción  
Principales objetivos del diseño:

| Característica | Descripción |  
|----------------|-------------|  
| 🚀 **Flexibilidad** | Adaptable a mejoras futuras |  
| 📈 **Escalabilidad** | Manejo eficiente de datos |  
| 🖥️ **Intuitividad** | Comandos simples (`W/A/S/D`, `E`, `Q`) |  
| 🏗️ **Estructura** | Representación clara con encabezados |  

## 2. 📐 Modelo del Dominio

<div align=center>

| Diagrama de Clases |
|-|
| ![Clases](/images/modelosUML/DiagramaClases-v001.svg) |

| Diagrama de Estado Matriz | Diagrama de Estado Celda | Diagrama de Estado InterfazUsuario |  
|---------------------|----------------|---------------------|
| ![Matriz](/images/modelosUML/DiagramaEstadosMatriz.svg) | ![Celda](/images/modelosUML/DiagramaEstadosCelda.svg) | ![Interfaz](/images/modelosUML/DiagramaEstadosInterfazUsuario.svg) | 

</div>

## 3. 💻 Código

| Clase | 🧬 Composición |  
|-------|----------------|  
| [**ComponenteHoja**](/src-v001/ComponenteHoja.java) | Clase base abstracta |  
| [**Matriz**](/src-v001/Matriz.java) | Contiene múltiples `Celda` |  
| [**Celda**](/src-v001/Celda.java) | Parte de `Matriz` |  
| [**Posicion**](/src-v001/Posicion.java) | Navegación en matriz |  
| [**Teclado**](/src-v001/Teclado.java) | Modifica `Celda` |  
| [**InterfazUsuario**](/src-v001/InterfazUsuario.java) | Contiene `Teclado` |  
| [**HojaCalculo**](/src-v001/HojaCalculo.java) | Coordina todos los componentes |  

## 4. 📖 Legibilidad

| Aspecto | ✅ Cumplimiento |  
|---------|----------------|  
| **Nombres claros** | 🟢 Excelente (`Matriz`, `Celda`) |  
| **Estructura** | 🟢 Diagramas UML detallados |  
| **Modularidad** | 🟡 Mejorable (Alguna clase podría dividirse) |  

<div align=center>


</div>
