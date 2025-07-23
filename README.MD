<h1>PROYECTO API FORUM-HUB</h1>

![Badge](http://img.shields.io/static/v1?label=STATUS&message=CONCLUIDO&color=GREEN&style=for-the-badge)
 

[Índice](#índice)

- [Descripción del proyecto](#descripción-del-proyecto)
- [Funcionalidad y Demostración de la aplicación](#funcionalidad-y-demostración-de-la-aplicación)
- [Tecnologias utilizadas](#tecnologias-utilizadas)
- [Seguridad](#seguridad)
- [Developer del Proyecto](#developer-del-proyecto)
- [Estructura del proyecto](#estructura-del-proyecto)

  

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

`Funcionalidad 6 `: Validación y manejo de errores.




## Tecnologias utilizadas


Spring Boot – Framework principal para desarrollo de la API.

Java 24 – Versión LTS del lenguaje de programación.

Lombok – Para generación automática de código repetitivo mediante anotaciones.

MySQL – Base de datos relacional utilizada para persistencia de datos.

Flyway – Herramienta para control de versiones y migraciones de la base de datos.

JPA (Java Persistence API) – Especificación para mapeo objeto-relacional.

Hibernate – Implementación de JPA utilizada en el proyecto.

Maven – Gestor de dependencias y herramienta de construcción del proyecto.

Insomnia – Herramienta para realizar pruebas y simular solicitudes HTTP a la API.

## Seguridad


La autenticación se realiza mediante JWT (JSON Web Tokens). El token es generado al iniciar sesión y debe ser enviado en el header Authorization de cada petición protegida, en el formato:

Authorization: Bearer {token}


## Estructura del proyecto

com.forumhub.ForumHub
│
├── controller        # Endpoints de la API
├── domain            # Entidades y clases de modelo (DTOs)
  ├── repository      # Interfaces de acceso a datos
└── infrastructure    # Validaciones, interceptores, etc.
  ├── security        # Lógica de negocio
  ├── exception       # Configuraciones de seguridad y sistema





<img src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/java/java-original.svg" width="40" height="40"/> <img src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/vscode/vscode-original-wordmark.svg" width="40" height="40"/> <img src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/json/json-original.svg" width="40" height="40" /> <img src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/mysql/mysql-original-wordmark.svg" width="40" height="40" /> <img src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/insomnia/insomnia-original-wordmark.svg" width="40" height="40"/>
          
          



## Developer del Proyecto


| [<img src="https://avatars.githubusercontent.com/u/169064334?s=400&u=e750ebc6759c09750f78a6f491ac78069a292719&v=4" width=115><br><sub>Ana Fernandez</sub>](https://github.com/AnaFzCz) |    |
| :---: | :---: 
