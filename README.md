# 🧮 Calculadora Científica en Java Swing (Patrón MVC)

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![Swing](https://img.shields.io/badge/GUI-Swing-blue?style=for-the-badge)
![Arquitectura MVC](https://img.shields.io/badge/Arquitectura-MVC-brightgreen?style=for-the-badge)

Una calculadora de escritorio moderna y avanzada construida en **Java**, utilizando la biblioteca **Swing** para la interfaz gráfica y aplicando estrictamente el patrón de diseño arquitectónico **Modelo-Vista-Controlador (MVC)**.

---

## ✨ Características Principales

* **🎨 Diseño "Dark Mode" Premium:** Interfaz de usuario elegante con colores oscuros, botones planos sin bordes (flat design) y un layout altamente optimizado.
* **📐 Arquitectura Limpia (MVC):** Separación total entre la lógica matemática, la interfaz gráfica y el control de eventos.
* **➕ Operaciones Básicas:** Suma, Resta, Multiplicación, División y Porcentaje.
* **🔬 Operaciones Científicas:** 
  * Trigonometría (Seno, Coseno, Tangente).
  * Potencias y Raíces cuadradas (`x²`, `x^y`, `10^x`, `e^x`).
  * Logaritmos (Base 10 y Natural).
  * Factoriales (`n!`) e Inverso multiplicativo (`1/x`).
  * Constantes matemáticas (`π`).
* **🛡️ Control de Errores:** Manejo seguro de excepciones (como la división por cero).

---

## 📂 Estructura del Proyecto

El código está estructurado siguiendo los principios del patrón MVC:

| Archivo | Rol en MVC | Descripción |
| :--- | :--- | :--- |
| `CalculadoraMotor.java` | **Modelo (Model)** | El cerebro. Contiene todos los métodos, cálculos matemáticos unarios y binarios, y la lógica pura. |
| `CalculadoraVista.java` | **Vista (View)** | La cara visible. Construye la ventana `JFrame`, los paneles, colores y configura la cuadrícula de los 32 botones. |
| `CalculadoraControlador.java` | **Controlador (Controller)** | El director. Escucha los "clics" de la Vista, decide qué hacer, le envía la orden matemática al Motor, y luego le dice a la Vista qué resultado mostrar. |
| `Main.java` | **Punto de Entrada** | Instancia el Modelo, la Vista y el Controlador y arranca la aplicación de manera segura. |

---

## 🚀 Cómo ejecutarlo

1. Asegúrate de tener instalado el **JDK (Java Development Kit)** en tu computadora.
2. Clona este repositorio en tu máquina local:
   ```bash
   git clone https://github.com/chaustrexp/Java-Swing-MVC.git
   ```
3. Abre el proyecto en tu IDE favorito (Eclipse, IntelliJ IDEA, VS Code, NetBeans).
4. Localiza el archivo `Main.java`.
5. Dale a **Ejecutar (Run)**. ¡Y disfruta de tu calculadora!

---
*Desarrollado con pasión para aprender interfaces gráficas y buenas prácticas de arquitectura en Java.* ☕
