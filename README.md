<h1>Book Catalog</h1>

<h2>Descripción del Proyecto</h2>
El Book Catalog es una aplicación basada en Java y Spring Framework que permite a los usuarios buscar, almacenar y gestionar información sobre libros y autores. Utiliza la API de Gutendex para recuperar información sobre libros y autores, y almacena los datos en una base de datos PostgreSQL.

<h2>Funcionalidades</h2>

Búsqueda
Búsqueda por Nombre de Libro o Autor: Permite al usuario buscar libros por su título o el nombre del autor.

Búsqueda por Fecha: Permite al usuario buscar libros publicados en un rango de años especificado.

Listado
Listar Todos los Libros: Muestra todos los libros almacenados en la base de datos.

Listar Libros por Idioma: Permite al usuario listar libros según el idioma en que están escritos.

Listar Todos los Autores: Muestra todos los autores almacenados en la base de datos.

Listar Autores Vivos en un Determinado Año: Permite al usuario listar autores que estaban vivos en un año específico.

Estadísticas
Estadísticas por Idioma: Muestra la cantidad de libros en un determinado idioma.

Estadísticas de Descargas: Muestra estadísticas sobre las descargas de libros, incluyendo el total, el promedio, el máximo y el mínimo de descargas.

Top 10 Libros Más Descargados: Muestra los 10 libros más descargados almacenados en la base de datos.

API Utilizada
La aplicación utiliza la API de Gutendex para recuperar información sobre los libros y autores. Esta API proporciona acceso a los libros disponibles en el Proyecto Gutenberg.

Estructura del Proyecto
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

Requisitos
Java 17

Spring Boot

PostgreSQL

<pre></pre>

Configuración
1. Clona el repositorio:

<pre>sh
git clone https://github.com/tu-usuario/book-catalog.git</pre>

2. Configura la base de datos en el archivo application.properties:

<pre>properties
spring.jpa.hibernate.ddl-auto=update
spring.datasource.url=jdbc:postgresql://localhost/book_catalog
spring.datasource.username=postgres
spring.datasource.password=tu_contraseña
spring.datasource.driver-class-name=org.postgresql.Driver
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
</pre>

3. Ejecuta la aplicación:

<pre>sh
./mvnw spring-boot:run</pre>

Uso
Sigue las opciones del menú para interactuar con la aplicación y explorar las diversas funcionalidades.

Contribución
¡Contribuciones son bienvenidas! Siéntete libre de abrir un issue o un pull request.

Licencia
Este proyecto está licenciado bajo la Licencia MIT - consulta el archivo LICENSE para más detalles.
