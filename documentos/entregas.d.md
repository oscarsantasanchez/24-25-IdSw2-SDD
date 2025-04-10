[![](https://img.shields.io/badge/-Inicio-FFF?style=flat&logo=Emlakjet&logoColor=black)](/README.md) [![](https://img.shields.io/badge/-Entrega_1-FFF?style=flat&logo=openstreetmap&logoColor=black)](/documentos/entregas.d.md) [![](https://img.shields.io/badge/-Entrega_2-FFF?style=flat&logo=openstreetmap&logoColor=black)](/documentos/entregas.dM.md)  [![](https://img.shields.io/badge/-Entrega_3-FFF?style=flat&logo=openstreetmap&logoColor=black)](/documentos/entregas.dOO.md)  [![](https://img.shields.io/badge/-Entrega_4-FFF?style=flat&logo=openstreetmap&logoColor=black)]()

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

| Diagrama de Clases | Diagramas de Estado |  
|--------------------|---------------------|  
| ![Clases](/images/modelosUML/DiagramaClases1.svg) | ![Matriz](/images/modelosUML/DiagramaEstadosMatriz.svg)<br>![Celda](/images/modelosUML/DiagramaEstadosCelda.svg)<br>![Interfaz](/images/modelosUML/DiagramaEstadosInterfazUsuario.svg) | 

</div>

## 3. 💻 Código

| Clase | 🔗 Enlace | 🧬 Composición |  
|-------|----------|----------------|  
| **ComponenteHoja** | [📁](/src/ComponenteHoja.java) | Clase base abstracta |  
| **Matriz** | [📁](/src/Matriz.java) | Contiene múltiples `Celda` |  
| **Celda** | [📁](/src/Celda.java) | Parte de `Matriz` |  
| **Posicion** | [📁](/src/Posicion.java) | Navegación en matriz |  
| **Teclado** | [📁](/src/Teclado.java) | Modifica `Celda` |  
| **InterfazUsuario** | [📁](/src/InterfazUsuario.java) | Contiene `Teclado` |  
| **HojaCalculo** | [📁](/src/HojaCalculo.java) | Coordina todos los componentes |  

## 4. 📖 Legibilidad

| Aspecto | ✅ Cumplimiento |  
|---------|----------------|  
| **Nombres claros** | 🟢 Excelente (`Matriz`, `Celda`) |  
| **Estructura** | 🟢 Diagramas UML detallados |  
| **Modularidad** | 🟡 Mejorable (Alguna clase podría dividirse) |  

<div align=center>


</div>
