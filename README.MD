<h1 align= "center">PROYECTO API FORUM-HUB</h1>

![Badge](http://img.shields.io/static/v1?label=STATUS&message=CONCLUIDO&color=GREEN&style=for-the-badge)
 

[Índice](#índice)

- [Descripción del proyecto](#descripción-del-proyecto)
- [Funcionalidad y Demostración de la aplicación](#funcionalidad-y-demostración-de-la-aplicación)
- [Tecnologias utilizadas](#tecnologias-utilizadas)
- [Seguridad](#seguridad)
- [Estructura del proyecto](#estructura-del-proyecto)
- [Estructura de Base de Datos](#Estructura-de-Base-de-datos)
- [Documentación de la API - Swagger](#Documentación-de-la-API---Swagger)
- [Resultados en Insomnia](#resultados-en-insomnia)
- [Developer del Proyecto](#developer-del-proyecto)


  

## Descripción del proyecto

<p>Un foro es un espacio donde los participantes de una plataforma pueden realizar preguntas relacionadas con temas específicos. En la plataforma de Alura, por ejemplo, los estudiantes utilizan el foro para consultar dudas sobre los cursos y proyectos en los que están involucrados.</p>

<p>Este proyecto, llamado FórumHub, propone replicar la lógica del foro desde el lado del backend. El objetivo es comprender cómo funciona esta funcionalidad "entre bastidores": desde el almacenamiento de la información, hasta el procesamiento de datos que permite conectar preguntas, respuestas y usuarios según los temas tratados.</p>

<p>Para lograrlo, desarrollaremos una API REST utilizando Spring Boot, que representará toda la estructura y dinámica de un foro real.</p>




## Funcionalidad y Demostración de la aplicación



`Funcionalidad 1 `: Registro y autenticación de usuarios.

`Funcionalidad 2 `: Publicación de temas.

`Funcionalidad 3 `: Respuestas a temas.

`Funcionalidad 4 `: Asociación de temas a cursos.

`Funcionalidad 5 `: Control de acceso vía token JWT.



## Tecnologias utilizadas


:heavy_check_mark: Spring Boot – Framework principal para desarrollo de la API.

:heavy_check_mark: Java 24 – Versión LTS del lenguaje de programación.

:heavy_check_mark: Lombok – Para generación automática de código repetitivo mediante anotaciones.

:heavy_check_mark: MySQL – Base de datos relacional utilizada para persistencia de datos.

:heavy_check_mark: Flyway – Herramienta para control de versiones y migraciones de la base de datos.

:heavy_check_mark: JPA (Java Persistence API) – Especificación para mapeo objeto-relacional.

:heavy_check_mark: Hibernate – Implementación de JPA utilizada en el proyecto.

:heavy_check_mark: Maven – Gestor de dependencias y herramienta de construcción del proyecto.

:heavy_check_mark: Insomnia – Herramienta para realizar pruebas y simular solicitudes HTTP a la API.

<img src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/java/java-original.svg" width="40" height="40"/> <img src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/vscode/vscode-original-wordmark.svg" width="40" height="40"/> <img src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/json/json-original.svg" width="40" height="40" /> <img src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/mysql/mysql-original-wordmark.svg" width="40" height="40" /> <img src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/insomnia/insomnia-original-wordmark.svg" width="40" height="40"/>
          
          


## Seguridad


<p>La autenticación se realiza mediante JWT (JSON Web Tokens). El token es generado al iniciar sesión y debe ser enviado en el header Authorization de cada petición protegida, en el formato:</p>

:closed_lock_with_key:

```
  Authorization: Bearer {token}
```




## Estructura del proyecto

Este proyecto está organizado siguiendo principios de separación de responsabilidades, lo que facilita el mantenimiento y la escalabilidad. A continuación, se describe la estructura de carpetas:


<p align="center">
  <img src=https://github.com/AnaFzCz/Proyecto_Forum_Hub_SpringBoot_Java/blob/main/src/assets/estructura_forum%20-hub.png" alt="12"/>
</p>


## Estructura de Base de datos

Este proyecto se encuentra conectado a la Base de Datos en MySQL.


<p align="center">
  <img src="https://github.com/AnaFzCz/Proyecto_Forum_Hub_SpringBoot_Java/blob/main/src/assets/Base%20de%20datos%20Forum-Hub.png" alt="14"/>
</p>


## Documentación de la API - Swagger

Esta API está documentada  :books: utilizando Swagger, una herramienta que permite visualizar y probar los endpoints de forma interactiva a través de una interfaz web.

Acceso a Swagger UI: Una vez que la aplicación está en ejecución, puedes acceder a la documentación en el siguiente enlace:

:link: http://localhost:8080/swagger-ui/index.html

<p align="center">
  <img src="https://github.com/AnaFzCz/Proyecto_Forum_Hub_SpringBoot_Java/blob/main/src/assets/Swagger-ui.jpg" alt="13" width="500"/>
</p>


## Resultados en Insomnia

:bookmark_tabs: LISTADO DE SOLICITUDES

<p align="center">
  <img src="https://github.com/AnaFzCz/Proyecto_Forum_Hub_SpringBoot_Java/blob/main/src/assets/Estructura%20de%20request.JPG?raw=true" alt="1" width="500"/>
</p>


:door: LOGIN EXITOSO - RETORNA TOKEN

<p align="center">
  <img src="https://github.com/AnaFzCz/Proyecto_Forum_Hub_SpringBoot_Java/blob/main/src/assets/Login%20-%20Ingreso%20exitoso.jpg" alt="2" width="500"/>
</p>


:woman: REGISTRO DE USUARIO
<p align="center">
  <img src="https://github.com/AnaFzCz/Proyecto_Forum_Hub_SpringBoot_Java/blob/main/src/assets/Registro%20de%20usuario.jpg" alt="3" width="500"/>
</p>


:woman: :man: LISTADO DE USUARIOS
<p align="center">
  <img src="https://github.com/AnaFzCz/Proyecto_Forum_Hub_SpringBoot_Java/blob/main/src/assets/Listado%20de%20usuarios.jpg" alt="4" width="500"/>
</p>


:page_facing_up: REGISTRO DE CURSO
<p align="center">
  <img src="https://github.com/AnaFzCz/Proyecto_Forum_Hub_SpringBoot_Java/blob/main/src/assets/Curso%20Registro%20exitoso.JPG" alt="5" width="500"/>
</p>


:page_facing_up: LISTADO DE CURSOS
<p align="center">
  <img src="https://github.com/AnaFzCz/Proyecto_Forum_Hub_SpringBoot_Java/blob/main/src/assets/Curso%20Listado.jpg" alt="6" width="500"/>
</p>

:page_facing_up: REGISTRO TOPICO
<p align="center">
  <img src="https://github.com/AnaFzCz/Proyecto_Forum_Hub_SpringBoot_Java/blob/main/src/assets/Registro%20Topico.jpg" alt="7" width="500"/>
</p>


:page_facing_up: LISTADO DE TODOS LOS TÓPICOS
<p align="center">
  <img src="https://github.com/AnaFzCz/Proyecto_Forum_Hub_SpringBoot_Java/blob/main/src/assets/Listado%20de%20todos%20los%20topicos.jpg" alt=8" width="500"/>
</p>


:page_facing_up: DETALLE DE TÓPICO
<p align="center">
  <img src="https://github.com/AnaFzCz/Proyecto_Forum_Hub_SpringBoot_Java/blob/main/src/assets/Detalle%20de%20topico.jpg" alt="9" width="500"/>
</p>


:page_facing_up: ELIMINACIÓN DE TÓPICO
<p align="center">
  <img src="https://github.com/AnaFzCz/Proyecto_Forum_Hub_SpringBoot_Java/blob/main/src/assets/Eliminaci%C3%B3n%20de%20t%C3%B3pico.jpg" alt="10" width="500"/>
</p>



## Developer del Proyecto


| [<img src="https://avatars.githubusercontent.com/u/169064334?s=400&u=e750ebc6759c09750f78a6f491ac78069a292719&v=4" width=115><br><sub>Ana Fernandez</sub>](https://github.com/AnaFzCz) |    |
| :---: | :---: 
