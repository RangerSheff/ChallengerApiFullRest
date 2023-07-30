# API REST FULL SPRING BOOT

Esta Api responde al desafio planteado por Banco BCI para el cargo de Java Señior en Integración

SWAGGER => http://localhost:8000/swagger-ui/index.html
Desafio => https://drive.google.com/file/d/180juNA9fd6NoASlqt1-WprvGgXHh85_A/view?usp=sharing

## CONFIGURACIÓN DE APLICATION.PROPERTIES
Para configurar el archivo aplication.properties solo he utilizado la configuración de la conexión a la base de datos.
```
#Spring Boot
server.port=8000 => Puerto a desplegar la aplicacion
spring.datasource.url=jdbc:mysql://localhost:3306/ChallengerApiRestFull => URL de BD con posicionamiento de la BD Target
spring.datasource.username=root => Usuario de MySQL
spring.datasource.password=Root1234 => Contraseña creada del MySQL
spring.jpa.hibernate.ddl-auto=update  => Solo Actualizara la BD creada en MySql
spring.mvc.pathmatch.matching-strategy=ant_path_matcher => Estrategia de match con la BD
springdoc.api-docs.path=/api-docs => URL que responde el Swagger

#JWT
token.secret=ChallengerApiRestFull => Secreto de la Aplicacion
token.time=600000 => 10 Minutos de duracion del Token
```

## Script de BD MySQL
⚠️ Se advierte que este desafio fue con esta BD por temas de rapides, por lo cual se puede utilizar cualquier BD con JDBC que sea relacional
```
CREATE DATABASE IF NOT EXISTS ChallengerApiRestFull;

USE ChallengerApiRestFull;

-- Tabla para la clase UsersModels
CREATE TABLE IF NOT EXISTS Users (
    id BINARY(16) PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    created DATETIME NOT NULL,
    modified DATETIME,
    lastLogin DATETIME,
    token VARCHAR(255),
    isActive TINYINT(1) DEFAULT 0
);

-- Tabla para la clase PhoneModels
CREATE TABLE IF NOT EXISTS Phones (
    id BINARY(16) PRIMARY KEY,
    number BIGINT NOT NULL,
    cityCode BIGINT NOT NULL,
    countryCode BIGINT NOT NULL
);

-- Relación entre Users y Phones (OneToMany)
ALTER TABLE Phones ADD COLUMN user_id BINARY(16);
ALTER TABLE Phones ADD CONSTRAINT fk_user_id FOREIGN KEY (user_id) REFERENCES Users (id) ON DELETE CASCADE;

```

## Basado en la vista Swagger se Pruede probar los siguientes Endpoint siguiendo la siguiente estructura

POST (Crear un usuario) => http://localhost:8000/users/save

Body
```
{
  "name": "Juan Rodrigo",
  "email": "rodrigo@bci.cl",
  "password": "Hunter2",
  "phones": [
    {
      "number": 99999999,
      "cityCode": 1,
      "countryCode": 56
    }
  ],
  "isActive": true
}
```

PUT (Actualizar un usuario) => http://localhost:8000/users/update/{id}

* Parametro **id** con formato **UUID** necesario - Ejemplo (381b2476-c693-4d0a-8a23-cf8daab0974b)

Body
```
{
  "name": "Juan Rodrigo",
  "email": "rodrigo@bci.cl",
  "password": "Hunter2",
  "phones": [
    {
      "number": 99999988,
      "cityCode": 1,
      "countryCode": 56
    }
  ],
  "isActive": true
}
```
GET (Buscar todos los usuarios) => http://localhost:8000/users/findAll

* No necesita body

GET (Buscar el usuario mediante la id) => http://localhost:8000/users/find/{id}

* Parametro **id** con formato **UUID** necesario - Ejemplo (381b2476-c693-4d0a-8a23-cf8daab0974b)

DELETE (Elimina el usuario mediante la id) => http://localhost:8000/users/delete/{id}

* Parametro **id** con formato **UUID** necesario - Ejemplo (381b2476-c693-4d0a-8a23-cf8daab0974b)

