# 🎬 VideoClub

Proyecto desarrollado en Java que permite gestionar un videoclub.

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

## 💀 Errores a Solucionar
- cuando se ejecuta el codigo al usar la accion de abrir ventana esta se abre en segundo plano dato a tener en consideración.
- cuando se se quiere generar un cliente si en la ventana se apreta cancelar hasta su ultima variable este se va a generar con sus atributos NULL.
- al no querer arruinar el codigo tenemos un main vacio llamado videoClubProyecto.java arreglar a futuro.
- clase Pelicula tenemos clases internas en el PeliculaEstreno y clasica a futuro arreglaremos esto.
- dato a considerar limitacion en peliculas.
- agregar UML al Informe.
- agregar a los demas contribuidores en el github (Isaias Rojas) (Ariel Ponce)
- Ordenar las clases a carpeta para que quede mas estructurado y legible

## 👤 Autor
- Eros Verdejo
- Ariel Ponce
- Isaias Rojas
