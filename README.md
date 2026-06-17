<div align="center">

# 🧮 Java Swing & MVC — Calculadora Científica

<br>

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Swing](https://img.shields.io/badge/Swing_GUI-007396?style=for-the-badge&logo=java&logoColor=white)
![MVC](https://img.shields.io/badge/Patrón_MVC-6DB33F?style=for-the-badge&logo=spring&logoColor=white)
![Status](https://img.shields.io/badge/Estado-Completo-brightgreen?style=for-the-badge)

<br>

> **Proyecto académico** que explora la construcción de interfaces gráficas en Java con **Swing**,
> aplicando el patrón de diseño **Modelo-Vista-Controlador (MVC)** en una calculadora con dos versiones evolutivas
> y una colección de ejercicios prácticos sobre componentes Swing.

<br>

[📂 Ver Código](#-estructura-del-proyecto) · [🚀 Cómo Ejecutar](#-cómo-ejecutar) · [📝 Detalles](#-detalles-por-carpeta)

---

</div>

<br>

## 📁 Estructura del Proyecto

```
Java-Swing-MVC/
│
├── 📁 Swing - (Version Antigua)/     ← Calculadora básica (4 operaciones)
│   ├── Main.java
│   ├── CalculadoraVista.java
│   ├── CalculadoraControlador.java
│   ├── CalculadoraMotor.java
│   └── MiPrimeraAppSwing.java
│
├── 📁 MVC Swing - (Version Nueva)/   ← Calculadora científica completa
│   ├── Main.java
│   ├── CalculadoraVista.java
│   ├── CalculadoraControlador.java
│   ├── CalculadoraMotor.java
│   ├── MiPrimeraAppSwing.java
│   └── README.md
│
├── 📁 Actividad Swing/               ← Ejercicios individuales de componentes
│   ├── Inicio.java
│   ├── ventana.java
│   ├── jbutton.java
│   ├── jmenu.java
│   ├── Jtable.java
│   ├── layouts.java
│   ├── tabs.java
│   └── resultadofinal.java
│
└── README.md
```

<br>

---

## 📝 Detalles por Carpeta

<br>

### 🟡 `Swing - (Version Antigua)/` — Calculadora Básica MVC

<table>
  <tr>
    <td width="120"><b>🎯 Objetivo</b></td>
    <td>Implementar una calculadora con las 4 operaciones básicas usando el patrón MVC.</td>
  </tr>
  <tr>
    <td><b>🏗️ Patrón</b></td>
    <td><b>Modelo-Vista-Controlador (MVC)</b></td>
  </tr>
</table>

| Archivo | Rol | Descripción |
|---------|-----|-------------|
| `Main.java` | 🚀 Punto de entrada | Instancia el Modelo, la Vista y el Controlador usando `SwingUtilities.invokeLater()` |
| `CalculadoraMotor.java` | 📦 **Modelo** | Lógica de negocio: `+`, `-`, `*`, `/` con manejo de división por cero |
| `CalculadoraVista.java` | 🖥️ **Vista** | Interfaz dark-mode con botones redondeados personalizados (`BotonPersonalizado`), efectos hover y grid 4×4 |
| `CalculadoraControlador.java` | 🎮 **Controlador** | Implementa `ActionListener`, rutea eventos a métodos: `manejarNumero()`, `manejarOperador()`, `manejarIgual()`, `manejarLimpiar()` |
| `MiPrimeraAppSwing.java` | 📝 Ejemplo básico | Ventana introductoria con `JLabel`, `JButton` y manejo de eventos básico |

<details>
<summary>💡 <b>Operaciones soportadas</b></summary>
<br>

| Operación | Símbolo | Ejemplo |
|-----------|---------|---------|
| Suma | `+` | `5 + 3 = 8` |
| Resta | `-` | `9 - 4 = 5` |
| Multiplicación | `*` | `6 * 7 = 42` |
| División | `/` | `8 / 2 = 4` |

</details>

<br>

---

### 🟢 `MVC Swing - (Version Nueva)/` — Calculadora Científica MVC

<table>
  <tr>
    <td width="120"><b>🎯 Objetivo</b></td>
    <td>Evolución de la calculadora básica con <b>funciones científicas avanzadas</b> y operadores unarios.</td>
  </tr>
  <tr>
    <td><b>🏗️ Patrón</b></td>
    <td><b>Modelo-Vista-Controlador (MVC) — Extendido</b></td>
  </tr>
</table>

| Archivo | Rol | Novedades respecto a la versión antigua |
|---------|-----|----------------------------------------|
| `CalculadoraMotor.java` | 📦 **Modelo** | Nuevo método `calcularUnario()` para 11 operaciones científicas + factorial recursivo |
| `CalculadoraVista.java` | 🖥️ **Vista** | Grid expandido a **8×4** (32 botones), botones científicos con color cian, diseño más alto y elegante |
| `CalculadoraControlador.java` | 🎮 **Controlador** | Nuevo manejo de operadores unarios, constante π, y expresiones regex mejoradas |
| `MiPrimeraAppSwing.java` | 📝 Ejemplo expandido | 5 botones con `ActionListener` en las 5 posiciones de `BorderLayout` |

<details>
<summary>🔬 <b>Funciones científicas añadidas</b></summary>
<br>

| Categoría | Funciones | Descripción |
|-----------|-----------|-------------|
| **Trigonometría** | `sin`, `cos`, `tan` | Trabajan en grados (conversión interna con `Math.toRadians()`) |
| **Logaritmos** | `log`, `ln` | Logaritmo base 10 y logaritmo natural |
| **Exponenciales** | `e^x`, `10^x`, `x^y` | Funciones exponenciales y potencia libre |
| **Otras** | `√`, `x²`, `1/x`, `n!`, `π`, `%` | Raíz cuadrada, cuadrado, inverso, factorial, pi y porcentaje |

</details>

<br>

---

### 🔵 `Actividad Swing/` — Ejercicios de Componentes Swing

<table>
  <tr>
    <td width="120"><b>🎯 Objetivo</b></td>
    <td>Practicar componentes individuales de Swing con ejemplos aislados y bien comentados.</td>
  </tr>
  <tr>
    <td><b>🏗️ Enfoque</b></td>
    <td><b>Aprendizaje progresivo</b> — de lo simple a lo complejo</td>
  </tr>
</table>

| # | Archivo | Componentes | Qué aprenderás |
|---|---------|-------------|-----------------|
| 1 | `ventana.java` | `JFrame` | Crear una ventana básica heredando de `JFrame` |
| 2 | `Inicio.java` | `JFrame`, `JButton`, `JTextArea`, `JLabel`, `JOptionPane` | Componentes esenciales con `FlowLayout` |
| 3 | `jbutton.java` | `JButton`, `ActionListener` | Manejo de eventos al hacer clic en un botón |
| 4 | `jmenu.java` | `JMenuBar`, `JMenu`, `JMenuItem`, `JFileChooser` | Crear menús desplegables y abrir un selector de archivos |
| 5 | `layouts.java` | `BorderLayout`, `BoxLayout`, `GroupLayout` | Comparar 3 tipos de layout managers |
| 6 | `tabs.java` | `JTabbedPane`, `JPanel` | Interfaz con pestañas y contenido dinámico |
| 7 | `Jtable.java` | `JTable`, `DefaultTableModel`, `JPopupMenu` | Tabla con datos, popup contextual y eliminación de filas |
| 8 | `resultadofinal.java` | **Todos los anteriores** | 🏆 Integración final: menú + pestañas + tabla + botones + eventos |

<br>

---

## 🚀 Cómo Ejecutar

### Requisitos Previos

| Requisito | Versión mínima |
|-----------|---------------|
| ☕ **JDK** | Java 8+ |
| 💻 **IDE** (Opcional) | IntelliJ IDEA, Eclipse, VS Code |

### Desde la Terminal

```bash
# 1️⃣ Clonar el repositorio
git clone https://github.com/chaustrexp/Java-Swing-MVC.git
cd Java-Swing-MVC

# 2️⃣ Compilar y ejecutar la Versión Antigua
cd "Swing - (Version Antigua)"
javac *.java
java Main

# 3️⃣ Compilar y ejecutar la Versión Nueva
cd "../MVC Swing - (Version Nueva)"
javac *.java
java Main

# 4️⃣ Ejecutar cualquier ejercicio de la Actividad Swing
cd "../../Actividad Swing"
javac resultadofinal.java
java resultadofinal
```

<br>

---

## 🧠 Arquitectura MVC

```
┌──────────────────────────────────────────────────────────────┐
│                                                              │
│   👤 Usuario                                                 │
│     │  clic en botón                                         │
│     ▼                                                        │
│   ┌──────────────────┐    evento    ┌──────────────────────┐ │
│   │  🖥️ VISTA         │ ──────────► │  🎮 CONTROLADOR       │ │
│   │  (JFrame + GUI)  │             │  (ActionListener)    │ │
│   │                  │  ◄───────── │                      │ │
│   │  • Pantalla      │  actualiza  │  • manejarNumero()   │ │
│   │  • Botones       │   texto     │  • manejarOperador() │ │
│   │  • Colores/Hover │             │  • manejarIgual()    │ │
│   └──────────────────┘             └──────────┬───────────┘ │
│                                               │              │
│                                    delega     │              │
│                                    cálculo    ▼              │
│                                    ┌──────────────────────┐  │
│                                    │  📦 MODELO            │  │
│                                    │  (CalculadoraMotor)  │  │
│                                    │                      │  │
│                                    │  • calcular()        │  │
│                                    │  • calcularUnario()  │  │
│                                    └──────────────────────┘  │
│                                                              │
└──────────────────────────────────────────────────────────────┘
```

<br>

---

## 🎨 Características del Diseño UI

<table>
  <tr>
    <td align="center">🌑<br><b>Dark Mode</b><br><sub>Fondo oscuro elegante<br><code>rgb(23, 23, 28)</code></sub></td>
    <td align="center">🟠<br><b>Operadores</b><br><sub>Naranja vibrante<br><code>rgb(255, 159, 10)</code></sub></td>
    <td align="center">🔴<br><b>Clear (C)</b><br><sub>Rojo moderno<br><code>rgb(255, 69, 58)</code></sub></td>
    <td align="center">🔵<br><b>Científicos</b><br><sub>Cian brillante<br><code>rgb(0, 229, 255)</code></sub></td>
  </tr>
  <tr>
    <td align="center">✨<br><b>Hover Effect</b><br><sub>Brillo dinámico<br>al pasar el mouse</sub></td>
    <td align="center">🔘<br><b>Botones</b><br><sub>Bordes redondeados<br>personalizados</sub></td>
    <td align="center">👆<br><b>Click Effect</b><br><sub>Oscurecimiento<br>al presionar</sub></td>
    <td align="center">🖋️<br><b>Tipografía</b><br><sub>Segoe UI Bold<br>42px pantalla</sub></td>
  </tr>
</table>

<br>

---

<div align="center">

### 🔗 Tecnologías Utilizadas

![Java](https://img.shields.io/badge/Java-ED8B00?style=flat-square&logo=openjdk&logoColor=white)
![Swing](https://img.shields.io/badge/Swing-007396?style=flat-square&logo=java&logoColor=white)
![AWT](https://img.shields.io/badge/AWT-5382A1?style=flat-square&logo=java&logoColor=white)
![MVC](https://img.shields.io/badge/MVC_Pattern-6DB33F?style=flat-square)
![Git](https://img.shields.io/badge/Git-F05032?style=flat-square&logo=git&logoColor=white)

---

<sub>Hecho con ☕ y mucho Swing — 2026</sub>

</div>
