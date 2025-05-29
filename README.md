# 👥 GESTION DE USUARIOS DE LA OGGE-EUPG-UNFV
Backend para un sistema **(inicialmente)** de gestion de usuarios de la Oficina de Grados y Gestión del Egresado de la Escuela Universitaria de Posgrado de la Universidad Nacional Federico Villarreal.

## 🚀 Tecnologías utilizadas
- Java JDK 21
- Spring Boot + JPA
- MySQL

## ⚙️ Instalacion
1. **Clonar el repositorio**
  ```bash
  git clone https://github.com/BzetaB/ogge-system.git
 ```
2. **Crear la Base de Datos en MySQL**
  Puedes usar una herramienta como MySQL Workbench o línea de comandos:
 ```mysql
  CREATE DATABASE nombre_de_tu_bd;
  ```
3. **Crear un archivo .env en la raiz del proyecto con la siguiente estructura**
  ```.env
  DB_URL=jdbc:mysql://localhost:puerto/nombre_de_tu_bd
  DB_USERNAME=tu_usuario
  DB_PASSWORD=tu_contraseña
  ```
4. **Ejecutar el proyecto**
  > Al iniciar la aplicación, las tablas serán creadas automáticamente si la configuración es correcta.

## 📌 Notas
- Este proyecto está en fase inicial, centrado en la gestión de usuarios.
- Requiere Java 21 y acceso a un servidor MySQL local o remoto.
