![alt text](</Docs/Sprints/IMG/Portada.png>)
# TANKESV *0.1*

## Tabla de Contenidos

- [TANKESV *0.1*](#tankesv-01)
  - [Tabla de Contenidos](#tabla-de-contenidos)
  - [Control de versiones](#control-de-versiones)
    - [Generalidades del proyecto](#generalidades-del-proyecto)
    - [Generalidades del equipo de desarrollo](#generalidades-del-equipo-de-desarrollo)
  - [Introducción](#introducción)
  - [Propuesta de implementación](#propuesta-de-implementación)
  - [Módulos del proyecto](#módulos-del-proyecto)
  - [Tecnologías a utilizar](#tecnologías-a-utilizar)
  - [Objetivos y Limitantes](#objetivos-y-limitantes)
  - [Iniciativas (Requerimientos Funcionales)](#iniciativas-requerimientos-funcionales)
  - [Product Backlog](#product-backlog)
  - [Historias de Usuario](#historias-de-usuario)
    - [Epica: Catálogo de Productos](#epica-catálogo-de-productos)
    - [Epica: Módulo de Crowdfunding](#epica-módulo-de-crowdfunding)
  - [Responsabilidades del Equipo Scrum](#responsabilidades-del-equipo-scrum)

## Control de versiones

Versión 0.1 Propuesta de proyecto.
Última revisión 9 de agosto de 2024.
Estado: *APROBADO*

### Generalidades del proyecto

- **Nomnbre de proyecto:** TANKESV
- **Tipo de proyecto:** catálogo online y crowfunding.
- **Organización para la cual se presenta:** proyecto interno.

### Generalidades del equipo de desarrollo

| **Rol**          | **Nombre**                              | **carnet** |
|------------------|-----------------------------------------|------------|
| Scrum Master     | Edwin Samuel Rivera Bercián             | RB1002022  |
| Developer        | Irvin Geovanni Ramirez Leiva            |RL101022    |
| Developer        | Walter Gabriel Hernández Hernández      | HH100122   |
| Developer        | Harold Alexander Orellana Gonzáles      |OG100122 |
| Product Owner    | Fernando Enrique Portillo Palacios      | PP100322 |

<br><br><br><br>

## Introducción

La presente propuesta tiene como finalidad el desarrollo de una plataforma de marketplace que no solo facilita la venta y promoción de productos por parte de emprendedores universitarios, emprendimientos externos, y grandes empresas, sino que también se convierte en un motor de crecimiento y desarrollo para los pequeños emprendedores. Estos emprendedores, a menudo enfrentan desafíos significativos al intentar establecerse en un mercado competitivo, y esta plataforma está diseñada para mitigar esos desafíos al proporcionar un espacio accesible y centralizado para sus productos y servicios.

El marketplace incluirá una amplia gama de catálogos, como comida, ropa, productos variados y manualidades, lo que permitirá a los emprendedores diversificar su oferta y llegar a un público más amplio. Además, la plataforma contará con un apartado de crowdfunding, una herramienta esencial para los pequeños emprendedores que buscan financiamiento para iniciar o expandir sus proyectos. Este apartado les permitirá presentar sus ideas a una comunidad más amplia, obteniendo apoyo financiero de personas interesadas en verlos crecer y prosperar.

La plataforma no solo servirá como un escaparate para los productos de los emprendedores, sino que también ofrecerá recursos y herramientas para ayudarles a gestionar y optimizar sus operaciones. Esto incluye la capacidad de gestionar inventarios, procesar pedidos y analizar el rendimiento de sus ventas, todo desde una interfaz fácil de usar.

Además, al estar organizada en módulos clave como seguridad, catálogos y crowdfunding, la plataforma garantizará que cada aspecto del negocio del emprendedor esté bien gestionado y seguro. Estos módulos interactuarán con las capas fundamentales del sistema, asegurando que la plataforma sea robusta, escalable y fácil de mantener. Las tecnologías empleadas, como Java, Spring Boot, HTML, CSS con Bootstrap, PHP, JavaScript, MySQL, phpMyAdmin y Apache, no solo garantizarán un rendimiento óptimo, sino que también permitirán futuras actualizaciones y expansiones, asegurando que la plataforma pueda crecer junto con los emprendedores que la utilizan.

En resumen, esta propuesta no es solo una plataforma de ventas; es un ecosistema diseñado para empoderar a los pequeños emprendedores, ofreciéndoles las herramientas y el apoyo necesarios para alcanzar el éxito en un mercado cada vez más digitalizado. Al centralizar la promoción y venta de productos, y al ofrecer oportunidades de financiamiento a través de crowdfunding, esta plataforma tiene el potencial de transformar la forma en que los emprendedores llevan sus productos al mercado, ayudándoles a superar las barreras tradicionales y a alcanzar su máximo potencial.

## Propuesta de implementación

La presente propuesta tiene como objetivo la creación de una plataforma de marketplace a contra entrega, destinada a impulsar el crecimiento y la visibilidad de los emprendedores de una universidad, emprendimientos externos y grandes empresas. Este marketplace estará dividido en diferentes catálogos como comida, productos variados, ropa, manualidades, y otros tipos de emprendimientos. Además, incluirá un apartado de crowdfunding donde los emprendedores podrán solicitar financiamiento para impulsar sus proyectos.

El manejo y organización de los productos ofrecidos por los diferentes emprendedores y empresas es crucial para asegurar una experiencia de usuario fluida y eficiente. Por ello, se propone la creación de la siguiente estructura de módulos dentro de la plataforma:

- **Seguridad**: Módulo encargado de la gestión de los usuarios que acceden a la plataforma, así como de los diferentes perfiles de usuario, garantizando la seguridad de la información y el acceso controlado a los datos.
- **Catálogos**: Manejo y control de los diferentes artículos, categorizados en catálogos como comida, productos variados, ropa, manualidades, entre otros. Este módulo permitirá a los emprendedores y empresas registrar sus productos y gestionar la disponibilidad y características de los mismos.
- **Crowdfunding**: Espacio donde los emprendedores podrán crear campañas para solicitar financiamiento, exponiendo sus proyectos y ofreciendo recompensas a los financiadores. Este módulo permitirá el registro de aportaciones y el seguimiento del progreso de cada campaña.

## Módulos del proyecto

La propuesta anterior se estructura en módulos específicos que abarcan las principales funcionalidades de la aplicación. Cada uno de estos módulos ha sido diseñado para interactuar de manera integral y coordinada con las capas fundamentales del sistema: **Modelo**, **Vista**, **Controlador** y **Base de Datos**.

- **Modelo**: Esta capa se encarga de definir y gestionar las estructuras de datos esenciales para la aplicación. Incluye la representación de usuarios, productos, proyectos de crowdfunding, y otras entidades clave. El modelo se conecta con la base de datos para almacenar y recuperar la información de manera eficiente, garantizando la coherencia y la integridad de los datos.
- **Vista**: La capa de Vista maneja la presentación de la información al usuario final. Aquí se definen las interfaces de usuario y la interacción con los elementos visuales. Cada módulo del sistema tiene su propia representación en la vista, permitiendo a los usuarios interactuar con los datos de manera intuitiva y accesible. Las vistas están diseñadas para ser responsivas y accesibles desde diferentes dispositivos.
- **Controlador**: Los controladores actúan como intermediarios entre el modelo y la vista. Gestionan la lógica de negocio y las reglas que definen el comportamiento de la aplicación. Cada acción del usuario en la vista es gestionada por un controlador que decide qué datos recuperar, cómo procesarlos, y qué vista devolver. Los controladores también son responsables de validar las entradas del usuario y manejar errores o excepciones.
- **Base de Datos**: La base de datos es la capa que almacena toda la información necesaria para el funcionamiento del sistema. Se diseñará una base de datos relacional que soportará las entidades del modelo, con tablas bien estructuradas y relaciones claras entre ellas. La base de datos se optimizará para garantizar un acceso rápido y seguro a los datos, soportando las operaciones de consulta, inserción, actualización y eliminación que los controladores requieran.

## Tecnologías a utilizar

- **Java /Spring Boot:**
Java es un lenguaje de programación robusto, seguro y multiplataforma, ampliamente utilizado en el desarrollo de aplicaciones empresariales. En este proyecto, Java será el lenguaje principal para la lógica del servidor, proporcionando la base para la gestión de datos, procesos de negocio y reglas de negocio del marketplace.
Spring Boot es un marco de trabajo de Java que simplifica la creación de aplicaciones web y servicios. Al usar Spring Boot, se acelerará el desarrollo de la plataforma, gracias a sus capacidades para configurar proyectos rápidamente y su integración con diversas tecnologías. Su enfoque modular permite construir aplicaciones escalables y fáciles de mantener.

- **HTML**
HTML (Hypertext Markup Language) es el lenguaje estándar utilizado para crear y estructurar el contenido en la web. En este proyecto, HTML será fundamental para definir la estructura y el contenido de las páginas del marketplace, permitiendo que los productos, categorías y demás elementos del sitio web sean visualizados correctamente por los usuarios.

- **CSS / Bootstrap:**
CSS (Cascading Style Sheets) es el lenguaje utilizado para describir la presentación visual de las páginas web. CSS será crucial para diseñar y mejorar la apariencia de la plataforma, asegurando que sea atractiva y fácil de usar.
Bootstrap es un marco de trabajo de CSS que facilita la creación de interfaces web responsivas y modernas. Al emplear Bootstrap, el desarrollo de la interfaz de usuario se vuelve más eficiente, ofreciendo componentes y estilos predefinidos que aseguran una experiencia de usuario coherente y atractiva en dispositivos móviles y de escritorio.

- **PHP:**
PHP (Hypertext Preprocessor) es un lenguaje de programación del lado del servidor que se utiliza para desarrollar aplicaciones web dinámicas. PHP se integrará en la plataforma para manejar funcionalidades como la interacción con la base de datos, gestión de usuarios y procesamiento de formularios, entre otros.

- **JavaScript:**
JavaScript es un lenguaje de programación que permite añadir interactividad y dinamismo a las páginas web. En este proyecto, JavaScript se utilizará para mejorar la experiencia del usuario a través de funciones como validación de formularios, actualizaciones en tiempo real, efectos visuales, y la manipulación del DOM.

- **MySQL:**
MySQL es un sistema de gestión de bases de datos relacional ampliamente utilizado. En la plataforma de marketplace, MySQL se encargará de almacenar y gestionar los datos esenciales como la información de los usuarios, productos, etc., asegurando que la información esté organizada y sea fácilmente accesible.

- **phpMyAdmin:**
phpMyAdmin es una herramienta de administración de bases de datos que facilita la gestión de MySQL a través de una interfaz web. Será utilizada para administrar las bases de datos del proyecto de manera eficiente, permitiendo realizar operaciones como la creación y modificación de tablas, consultas SQL y la gestión de usuarios.

- **Apache**
Apache es un servidor web que desempeña un papel clave en la entrega de contenido web a los usuarios. En este proyecto, Apache se utilizará para servir las páginas y aplicaciones web del marketplace, manejando las solicitudes HTTP de los usuarios y enviando las respuestas correspondientes.

## Objetivos y Limitantes

- **Frontera**: El proyecto estará limitado a la creación de una plataforma de marketplace que integre catálogos de productos variados y un apartado de crowdfunding. La plataforma será accesible a emprendedores universitarios, emprendimientos externos y grandes empresas.
  
- **Límites**: Se enfoca en ofrecer soluciones a los emprendedores que buscan mejorar la visibilidad de sus productos y obtener financiamiento. **No incluye tienda en línea**. Las limitaciones técnicas incluyen el uso de tecnologías específicas como Java, Spring Boot, HTML, CSS con Bootstrap, PHP, JavaScript, MySQL, phpMyAdmin y Apache.

<br><br>

## Iniciativas (Requerimientos Funcionales)

- Creación de un marketplace accesible y organizado.
- Integración de catálogos de productos como comida, ropa, manualidades, etc.
- Desarrollo de un módulo de crowdfunding para financiamiento de proyectos.
- Implementación de seguridad para la gestión de usuarios y perfiles.

## Product Backlog

- **Catálogo de Productos**:
  - Crear categorías de productos (comida, ropa, manualidades).
  - Permitir a los emprendedores registrar y gestionar sus productos.
  - Implementar un sistema de búsqueda y filtrado de productos.
  
- **Módulo de Crowdfunding**:
  - Desarrollar un espacio donde los emprendedores puedan crear campañas.
  - Implementar un sistema para el registro de aportaciones.
  - Permitir el seguimiento del progreso de cada campaña.

## Historias de Usuario

### Epica: Catálogo de Productos

- **HU001**: Como usuario, quiero poder filtrar los productos por categoría para encontrar rápidamente lo que necesito.
- **HU002**: Como emprendedor, quiero poder registrar mis productos en la plataforma para ofrecerlos a un público más amplio.

### Epica: Módulo de Crowdfunding

- **HU003**: Como emprendedor, quiero crear una campaña de financiamiento para obtener recursos para mi proyecto.
- **HU004**: Como usuario, quiero ver las recompensas ofrecidas por las campañas para decidir si apoyar un proyecto.

## Responsabilidades del Equipo Scrum

- **Scrum Master (SM)**:
  - **Responsable**: Edwin Samuel Rivera Bercián
  - **Herramienta de Gestión del Proyecto**: Jira y WhatsApp
  - Facilitar las reuniones y asegurar la correcta aplicación de Scrum.
  - Organizar los sprints y gestionar el backlog en Jira.
  - Registrar todas las reuniones y gestiones como evidencia del progreso.

- **Product Owner (PO)**:
  - **Responsable**: Fernando Enrique Portillo Palacios
  - Definir la visión del producto y priorizar el backlog.
  - Asegurar que el equipo entiende los requerimientos y objetivos del proyecto.

- **Equipo de Desarrollo**:
  - **Responsables**: Irvin Geovanni Ramirez Leiva, Walter Gabriel Hernandez Hernandez, Harold Orellana
  - Escribir Historias de Usuario (HU) basadas en las épicas definidas.
  - Seleccionar cada HU en la cual van a trabajar en cada sprint.
  - Agregar tareas a cada HU, abrirlas, cerrarlas y actualizar su progreso en Jira.
