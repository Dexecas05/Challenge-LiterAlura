# Book Catalog

## Descripción del Proyecto

El Book Catalog es una aplicación de consola basada en Java y Spring Framework que permite a los usuarios buscar, almacenar y gestionar información sobre libros y autores. Utiliza la API de Gutendex para recuperar información sobre libros y autores, y almacena los datos en una base de datos PostgreSQL.

## Funcionalidades

### Búsqueda en la API

  - **Búsqueda por Nombre de Libro o Autor:** Permite al usuario buscar libros por su título o el nombre del autor (o un fragmento del título o del nombre) y devuelve la primera opción encontrada, que por defecto es la que mayor cantidad de descargas registradas posee.

  - **Búsqueda por Fecha:** Permite al usuario buscar libros publicados en un rango de años especificado. Esta función devuelve todos los libros encontrados entre los años especificados.

### Listado

  - **Listar Todos los Libros:** Muestra todos los libros almacenados en la base de datos.

  - **Listar Libros por Idioma:** Permite al usuario listar libros según el idioma en que están escritos (Ej.: "es" para español, "en" para inglés, etc.).

  - **Listar Todos los Autores:** Muestra todos los autores almacenados en la base de datos (estos se registran al ejecutar las consultas en la API).

  - **Listar Autores Vivos en un Determinado Año:** Permite al usuario listar autores que estaban vivos en un año específico.

### Estadísticas

  - **Estadísticas por Idioma:** Muestra la cantidad de libros registrados en la base de datos en un idioma especificado.

  - **Estadísticas de Descargas:** Muestra estadísticas sobre las descargas de libros, incluyendo el total, el promedio, el máximo y el mínimo de descargas.

  - **Top 10 Libros Más Descargados:** Muestra los diez (10) libros más descargados almacenados en la base de datos.

## API Utilizada

La aplicación utiliza la API de [Gutendex](https://gutendex.com/) para recuperar información sobre los libros y autores. Esta API proporciona acceso a la información sobre los libros disponibles en el [Proyecto Gutenberg](https://www.gutenberg.org/).

## Estructura del Proyecto

La estructura principal del proyecto es la siguiente:

<pre>
bookcatalog
├── src
│   ├── main
│   │   ├── java
│   │   │   ├── com.daletguimel.bookcatalog
│   │   │   │   ├── main
│   │   │   │   │   └── Main.java
│   │   │   │   ├── model
│   │   │   │   │   ├── Author.java
│   │   │   │   │   ├── AuthorEntity.java
│   │   │   │   │   ├── AuthorRecord.java
│   │   │   │   │   ├── Book.java
│   │   │   │   │   ├── BookEntity.java
│   │   │   │   │   ├── BookRecord.java
│   │   │   │   │   ├── BookResponse.java
│   │   │   │   ├── repository
│   │   │   │   │   ├── AuthorRepository.java
│   │   │   │   │   ├── BookRepository.java
│   │   │   │   ├── service
│   │   │   │   │   ├── BookService.java
│   │   │   │   │   ├── ClientApi.java
│   │   │   │   │   ├── DataConverter.java
│   │   │   │   │   ├── IDataConverter.java
│   │   │   ├── resources
│   │   │   │   ├── application.properties
│   ├── test
│   │   ├── java
│   │   │   ├── com.daletguimel.bookcatalog
│   │   │   │   ├── BookCatalogApplicationTests.java
├── README.md
</pre>

## Requisitos
  - Java 17

  - Spring Boot (con las dependencias añadidas de PostgreSQL Driver y Spring JPA)

  - PostgreSQL

## Configuración

  1. Clona el repositorio:

<pre>sh
git clone https://github.com/tu-usuario/book-catalog.git
</pre>

  2. Configura la base de datos en el archivo application.properties:

<pre>properties
spring.jpa.hibernate.ddl-auto=update
spring.datasource.url=jdbc:postgresql://localhost/nombre_de_tu_database
spring.datasource.username=tu_nombre_de_usuario
spring.datasource.password=tu_contraseña
spring.datasource.driver-class-name=org.postgresql.Driver
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
</pre>

  3. Ejecuta la aplicación:

<pre>sh
./mvnw spring-boot:run
</pre>

## Uso

Es muy sencillo de usar: solo sigue las opciones del menú para interactuar con la aplicación y explorar las diversas funcionalidades.

## Contribución

¡Las contribuciones son bienvenidas! Siéntete libre de abrir un issue o un pull request.

## Licencia

Este proyecto está licenciado bajo la Licencia MIT - consulta el archivo LICENSE para más detalles.

## Autor

  - Darío Exequiel Castillo
  - LinkedIn: <www.linkedin.com/in/darío-castillo-b1463998>

_ _ _

**Este proyecto fue desarrollado en el marco de participación del Programa ONE (Oracle Next Education), ofrecido por Alura Latam y Oracle. Puedes leer más en el siguiente enlace <https://www.oracle.com/ar/education/oracle-next-education/>*
