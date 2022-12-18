## Ejercicio 3

### Open Bootcamp Spring

#### Ejercicio 3
- Crear un proyecto Spring Boot con las dependencias:

    - Spring Data JPA

    - H2

- En caso de querer que la base de datos se guarde en disco habrá que añadir las siguientes propiedades en el 
  archivo application.properties:

    - spring.jpa.show-sql=true

    - spring.datasource.url=jdbc:h2:file:C:/data/sample

    - spring.datasource.username=sa

    - spring.datasource.password=

    - spring.datasource.driverClassName=org.h2.Driver

    - #spring.jpa.hibernate.ddl-auto=creat

    - spring.jpa.hibernate.ddl-auto=update

    - spring.sql.init.mode=always

    - spring.jpa.defer-datasource-initialization=true

#### Ejercicio 4, 5, 6
Se creo un Api Rest con Spring Boot con los siguientes endpoint
- **GET /v1/book**  devuelve la lista de todos los libros
- **GET /vi/book/{id}** devuelve un libro por ID. si no existe devuelve un 404
- **POST /v1/book** guarda un nuevo libro
- **PUT /v1/book/{id}**  actualiza un nuevo libro. si el id es distinto al id del cuerpo o el id no está registrado en db devuelve un error 404
- **Delete /v1/book/{id}** borra un libro de la bd. si el id no existe no hace nada y devuelve un 200. 