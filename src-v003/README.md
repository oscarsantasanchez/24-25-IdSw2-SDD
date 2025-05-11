
# 📊 Hoja de Cálculo - Versión 2

<div align="center">
  <img src="/images/modelosUML/DiagramaClasesSrc2.svg" alt="Diagrama de Clases">
</div>

## ⚙️ Estructura General

- El sistema `HojaDeCalculo` está organizado en una arquitectura **MVC** con apoyo de paquetes utilitarios.
- La clase principal `HojaCalculo` coordina `modelo`, `vista` y `controlador`, aunque la inicialización de la interfaz se ha movido a `InterfazUsuario`.

---

## 🔄 Cambios Clave respecto a `src-v001`

###  Refactorización de Arquitectura

| Cambio | Descripción |
|--------|-------------|
| **Patrón MVC aplicado** | Separación clara entre datos (`modelo`), interfaz (`vista`) y lógica (`controlador`) |
| **Organización modular** | Uso de paquetes: `modelo`, `vista`, `controlador`, `util` |
| **Inicialización movida** | El método `iniciarHojaCalculo` se trasladó a `InterfazUsuario` |

---

###  Mejora en Nomenclatura y Sintaxis

| Cambio | Descripción |
|--------|-------------|
| ✅ Renombrado de métodos | `inicializarHoja` → `inicializarMatriz` para una mejor semántica |
| ✅ Modernización del código | Reemplazo del `switch` tradicional por expresión `switch` en Java |

---

###  Cohesión y Acoplamiento

| Mejora | Resultado |
|--------|----------|
| Eliminación de `ComponenteHoja` | Se abandona la herencia forzada y se favorece la composición |
| Clases más específicas | Cada clase cumple una función única, lo que mejora la cohesión |
| Reducción del acoplamiento | Interfaces bien definidas, dependencias explícitas y claras |

---

## 💡 Diseño Orientado a Objetos

| Aspecto | src-v001 | src-v002 |
|--------|----------|----------|
| Cohesión | ⚠️ Baja | ✅ Alta |
| Acoplamiento | 🔴 Fuerte | ✅ Débil |
| SOLID | ⚠️ Parcial | ✅ Cumplido en mayor medida |
| Patrón MVC | ❌ No implementado | ✅ Completamente implementado |
| Flexibilidad | 🔴 Limitada | ✅ Extensible y mantenible |

---

## 🛠️ Principales Clases y Responsabilidades

| Clase | Rol |
|-------|-----|
| `Celda` | Representa y gestiona el contenido de una celda |
| `Matriz` | Estructura que contiene las celdas |
| `Posicion` | Controla la ubicación actual del cursor |
| `ControladorHoja` | Procesa los comandos del usuario |
| `VisualizadorHoja` | Muestra el contenido de la hoja |
| `InterfazUsuario` | Inicializa e interactúa con el usuario |

---

## 📌 Mejoras Técnicas

-  Código más legible y organizado
-  Métodos con nombres más intuitivos
-  Uso de estructuras modernas de Java (como `switch expression`)
-  Preparado para nuevas funcionalidades sin romper la arquitectura existente

---

## 🚀 Conclusión

La versión 2 del sistema de hoja de cálculo representa una evolución significativa hacia un diseño profesional y mantenible. Los cambios introducidos en nomenclatura, arquitectura, y aplicación de patrones facilitan su escalabilidad y claridad. Además, la adopción de MVC y el cumplimiento de principios SOLID fortalecen la robustez del software.


