# 🎬 VideoClub

Proyecto desarrollado en Java que permite gestionar un videoclub.

## Descripcion

VideoClub es un Sistema de Información desarrollado en Java que permite gestionar clientes, películas y arriendos de un videoclub. El sistema incluye persistencia de datos, manejo de excepciones y ejecución tanto en modo consola como en ventanas, aplicando principios de Programación Orientada a Objetos.

## 📌 Funcionalidades
- Gestión de clientes
- Gestión de películas
- Lectura y escritura en archivos .txt

## 🛠️ Tecnologías
- Java
- NetBeans

## ▶️ Cómo ejecutar
1. Abrir en NetBeans
2. Ejecutar el proyecto

## 🏗️ Estructura del Proyecto

```
VideoClub/
├── src/
│   ├── consola/         # Menús e interacción por consola
│   ├── gui/             # Interfaz gráfica (JOptionPane / ventanas)
│   ├── excepciones/     # Excepciones personalizadas
│   ├── modelo/          # Clases del dominio (Cliente, Pelicula, Arriendo, Persona)
│   ├── sistema/         # Lógica principal (VideoClub)
│   └── Main.java        # Punto de entrada del programa
│
├── datos/               # Archivos de persistencia (clientes.txt, peliculas.txt)
│
├── docs/                # Documentación del proyecto
│   ├── UML.png          # Diagrama de clases
│   ├── consola.png      # Captura modo consola
│   ├── ventanas.png     # Captura modo ventanas
│   └── reporte.pdf      # Informe final
│
│
└── README.md            # Documentación principal   
```

## 💀 Errores a Solucionar
- cuando se se quiere generar un cliente si en la ventana se apreta cancelar hasta su ultimo atributo este se va a generar con sus atributos NULL.

## 👤 Autores
- Eros Verdejo
- Ariel Ponce
- Isaias Rojas
