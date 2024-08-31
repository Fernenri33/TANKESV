![alt text](</Docs/Sprints/IMG/Portada.png>)

# TANKESV *0.1.1*

- [TANKESV *0.1.1*](#tankesv-011)
  - [Control de versiones](#control-de-versiones)
  - [Generalidades del proyecto](#generalidades-del-proyecto)
    - [Equipo SCRUM](#equipo-scrum)
    - [Sobre el proyecto](#sobre-el-proyecto)
      - [Tecnologías a usar](#tecnologías-a-usar)
      - [Objetivos y Limitantes](#objetivos-y-limitantes)
  - [Sprint 1](#sprint-1)
    - [Creación de workspace en JIRA](#creación-de-workspace-en-jira)
    - [Product Backlog](#product-backlog)
    - [Diagrama de Entidad Relación](#diagrama-de-entidad-relación)
    - [Diseño de diagramas de caso de uso](#diseño-de-diagramas-de-caso-de-uso)
    - [Diseño de wireframes](#diseño-de-wireframes)
    - [Investigar Springboot y thymeleaf](#investigar-springboot-y-thymeleaf)
      - [Spring Boot](#spring-boot)
      - [Thymeleaf](#thymeleaf)
      - [Código de práctica](#código-de-práctica)
    - [Creación de repositorio en GitHub](#creación-de-repositorio-en-github)

## Control de versiones

Versión **0.1.1 Sprint 1**

Fecha de inicio: 26 de agosto de 2024.
Fecha de Entrega: 31 de agosto de 2024.
Última revisión: 26 de agosto de 2024.
Estado: *pendiente de revisión*

## Generalidades del proyecto

- **Nomnbre de proyecto:** TANKESV
- **Tipo de proyecto:** catálogo online y crowfunding.
- **Organización para la cual se presenta:** Tanque de Emprendedores El Salvador SA de CV.

### Equipo SCRUM

| **Rol**          | **Nombre**                              | **carnet** |
|------------------|-----------------------------------------|------------|
| Scrum Master     | Edwin Samuel Rivera Bercián             | RB100222  |
| Developer        | Irvin Geovanni Ramirez Leiva            |RL101022    |
| Developer        | Walter Gabriel Hernández Hernández      | HH100122   |
| Developer        | Harold Alexander Orellana Gonzáles      |OG100122    |
| Product Owner    | Fernando Enrique Portillo Palacios      | PP100322   |

### Sobre el proyecto

Esta propuesta presenta el desarrollo de una plataforma de marketplace orientada a facilitar la venta y promoción de productos para emprendedores universitarios, emprendimientos externos y grandes empresas. Además de ofrecer un espacio centralizado para comercializar productos como comida, ropa, productos variados y manualidades, la plataforma incluye un módulo de crowdfunding, que permitirá a los emprendedores obtener financiamiento para sus proyectos. La plataforma proporcionará herramientas integradas para gestionar inventarios, procesar pedidos y analizar el rendimiento de las ventas, todo a través de una interfaz intuitiva y fácil de usar. Organizada en módulos clave como seguridad, catálogos y crowdfunding, la plataforma garantizará una gestión eficiente y segura de cada aspecto del negocio, mientras que las tecnologías empleadas asegurarán un rendimiento óptimo y una capacidad de expansión futura.

#### Tecnologías a usar

**Java y Spring Boot** serán la base de la plataforma, proporcionando un entorno robusto y seguro para la lógica del servidor. Java, conocido por su confiabilidad en aplicaciones empresariales, se encargará de la gestión de datos y procesos de negocio. Spring Boot, un marco de trabajo de Java, permitirá acelerar el desarrollo mediante su configuración simplificada y capacidades modulares, asegurando que la plataforma sea escalable y fácil de mantener.

**HTML** se utilizará para definir la estructura y el contenido de las páginas web del marketplace. Este lenguaje estándar de marcado permitirá que los productos, categorías y otros elementos del sitio sean presentados de manera clara y accesible para los usuarios, estableciendo la base visual del sitio.

**CSS y Bootstrap** serán las herramientas principales para diseñar la apariencia de la plataforma. CSS se encargará de la presentación visual, garantizando un diseño atractivo y coherente en todas las páginas. Bootstrap, un marco de trabajo basado en CSS, facilitará la creación de una interfaz de usuario responsiva, asegurando que la experiencia sea fluida tanto en dispositivos móviles como en escritorio.

**JavaScript** se empleará para añadir interactividad y dinamismo a la plataforma. Este lenguaje permitirá la implementación de funciones como la validación de formularios, actualizaciones en tiempo real y la manipulación del Document Object Model (DOM), mejorando significativamente la experiencia del usuario al interactuar con la plataforma.

**MySQL** gestionará las bases de datos del marketplace, asegurando un almacenamiento y recuperación eficientes de la información clave, como los datos de usuarios y productos. Este sistema de gestión de bases de datos relacional es conocido por su confiabilidad y capacidad para manejar grandes volúmenes de datos de manera eficiente.

**phpMyAdmin y Dbeaver** se empleará como la herramienta principal para la gestión de bases de datos MySQL. A través de su interfaz web intuitiva, phpMyAdmin facilitará la administración de bases de datos, permitiendo a los desarrolladores realizar tareas como la creación y modificación de tablas, consultas SQL y la gestión de usuarios de manera eficiente.

<!-- Añadir 5. Investigar Springboot y thymeleaf. -->

#### Objetivos y Limitantes

<!-- Extiende esto un poco más -->

- **Frontera**: El proyecto estará limitado a la creación de una plataforma de marketplace que integre catálogos de productos variados y un apartado de crowdfunding. La plataforma será accesible a emprendedores universitarios, emprendimientos externos y grandes empresas.
  
- **Límites**: Se enfoca en ofrecer soluciones a los emprendedores que buscan mejorar la visibilidad de sus productos y obtener financiamiento. **No incluye tienda en línea**. Las limitaciones técnicas incluyen el uso de tecnologías específicas como Java, Spring Boot, HTML, CSS con Bootstrap, JavaScript, MySQL, phpMyAdmin y Apache.

## Sprint 1

1. Creación de workspace en JIRA.
2. Diseño de diagrama ER.
3. Diseño de diagramas de caso de uso.
4. Diseño de wireframes.
5. Investigar Springboot y thymeleaf.
6. Creación de repositorio en GitHub.

### Creación de workspace en JIRA

![alt text](</Docs/Sprints/IMG/uworkspace.atlassian.net_jira_software_projects_SCRUM_boards_1.png>)

### Product Backlog

![alt text](</Docs/Sprints/IMG/uworkspace.atlassian.net_jira_software_projects_SCRUM_boards_1_backlog.png>)

### Diagrama de Entidad Relación

![alt text](</Docs/Databse/TANKESV_ER.png>)

### Diseño de diagramas de caso de uso

![alt text](</Docs/Casos de uso/uso01.jpg>)
![alt text](</Docs/Casos de uso/uso02.jpg>)
![alt text](</Docs/Casos de uso/uso03.jpg>)
![alt text](</Docs/Casos de uso/uso04.jpg>)
![alt text](</Docs/Casos de uso/uso05.jpg>)
![alt text](</Docs/Casos de uso/uso06.jpg>)

### Diseño de wireframes

![alt text](</Docs/Wireframes/w01.jpg>)
![alt text](</Docs/Wireframes/w02.jpg>)

### Investigar Springboot y thymeleaf

#### Spring Boot

Spring Boot es un marco de trabajo basado en Spring que facilita la creación de aplicaciones Java con mínima configuración. Algunas de sus características clave incluyen:

- **Configuración automática**: Spring Boot reduce la necesidad de configuración manual gracias a su capacidad de detectar automáticamente las dependencias y configurarlas.
- **Servidor embebido**: Puedes ejecutar aplicaciones como archivos jar que contienen un servidor embebido, como Tomcat o Jetty, lo que simplifica el despliegue.
- **Maven y Gradle**: Integración con herramientas de construcción como Maven y Gradle para la gestión de dependencias.
- **Facilidad de desarrollo**: Permite la creación rápida de aplicaciones mediante convenciones predefinidas y plantillas que siguen las mejores prácticas.
- **Monitorización y métricas**: Incluye herramientas para monitorizar el rendimiento de la aplicación.

#### Thymeleaf

Thymeleaf es un motor de plantillas de Java que se utiliza para generar vistas HTML en aplicaciones web. Algunas de sus características principales son:

- **Syntax sencilla**: Usa una sintaxis XML/HTML limpia que puede ser interpretada por navegadores y editores sin procesamiento previo.
- **Soporte para internacionalización**: Facilita la internacionalización de aplicaciones mediante la externalización de cadenas de texto en archivos de propiedades.
- **Expresiones y fragmentos**: Permite utilizar expresiones simples y reutilizar partes de las plantillas (fragments) para modularizar el código HTML.
- **Integración con Spring**: Se integra de manera nativa con Spring y Spring Boot, permitiendo el uso de modelos y controladores en la generación de vistas dinámicas.

#### Código de práctica

![alt text](/Docs/Sprints/IMG/code01.png)

### Creación de repositorio en GitHub

[Link al repositorio]((https://github.com/Fernenri33/TANKESV-PROYECT))

![alt text](/Docs/Sprints/IMG/github.png)
