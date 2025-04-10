[![](https://img.shields.io/badge/-Inicio-FFF?style=flat&logo=Emlakjet&logoColor=black)](/README.md) [![](https://img.shields.io/badge/-Entrega_1-FFF?style=flat&logo=openstreetmap&logoColor=black)](/documentos/entregas.d.md) [![](https://img.shields.io/badge/-Entrega_2-FFF?style=flat&logo=openstreetmap&logoColor=black)](/documentos/entregas.dM.md)  [![](https://img.shields.io/badge/-Entrega_3-FFF?style=flat&logo=openstreetmap&logoColor=black)](/documentos/entregas.dOO.md)  [![](https://img.shields.io/badge/-Entrega_4-FFF?style=flat&logo=openstreetmap&logoColor=black)]()


# 🧬 Diseño Orientado a Objetos (D.OO)

## 1. Principios Aplicados

| Principio | Aplicación en el Proyecto | Ejemplo |
|-----------|---------------------------|---------|
| **Abstracción** | `ComponenteHoja` como clase abstracta | Define métodos comunes para todas las componentes |
| **Encapsulación** | Atributos privados con métodos accesores | `Celda` oculta implementación de formato interno |
| **Herencia** | Jerarquía de clases base y especializadas | `ComponenteHoja` → Clases concretas |
| **Polimorfismo** | Métodos con implementaciones específicas | `mostrarContenido()` en diferentes contextos |



| Diseño orientado a objetos|
|-|
|![Jerarquizacion](/images/modelosUML/DiseñoObjetos.svg)

## 3. 🔗 Relaciones entre Clases

| Tipo | Clases Involucradas | Diagrama |
|------|---------------------|----------|
| **Herencia** | `ComponenteHoja` → Clases hijas | ![Herencia](/images/modelosUML/HerenciaOO.svg) |
| **Composición** | `Matriz` → `Celda` | ![Composicion](/images/modelosUML/ComposicionOO.svg) |
| **Agregación** | `HojaCalculo` → `Matriz` | ![Agregacion](/images/modelosUML/AgregacionOO.svg) |

## 4. 🛠️ Patrones de Diseño

| Patrón | Aplicación | Beneficio |
|--------|------------|-----------|
| **Singleton** | `Teclado` (una única instancia) | Control centralizado de entrada |
| **Observer** | Actualización de la vista al modificar celdas | Sincronización modelo-vista |
| **Factory** | Creación de celdas con diferentes formatos | Extensibilidad de tipos |

## 5. ✅ Cumplimiento de Principios 

| Principio | Cumplimiento | Ejemplo |
|-----------|--------------|---------|
| **SOLID** | 🟢 85% | S: Clases con única responsabilidad |
| **DRY** | 🟡 70% | Algo de código repetido en validaciones |
| **Ley de Demeter** | 🟢 90% | Bajo acoplamiento entre componentes |

<div align=center>

[![Arriba](https://img.shields.io/badge/-Volver_Arriba-5D5D5D?style=flat)](#diseño-orientado-a-objetos-doo)

</div>