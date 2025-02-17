# Mock API

Este proyecto es una implementación de una API REST que devuelve datos de diferentes recursos (productos, recetas, carritos de compras, etc.) en formato JSON.

La API se encuentra dividida en diferentes secciones, cada una de las cuales se encarga de manejar un recurso determinado. Por ejemplo, la sección de productos devuelve una lista de productos, mientras que la sección de recetas devuelve una lista de recetas.

Además, cada sección cuenta con diferentes endpoints para realizar operaciones CRUD (crear, leer, actualizar y eliminar) sobre los recursos.

## Endpoints

A continuación se presentan los diferentes endpoints que se encuentran disponibles en la API:

http://localhost:8080/swagger-ui/index.html

## Ejemplos de uso

A continuación se presentan algunos ejemplos de uso de la API:

### Obtener una lista de productos

Para obtener una lista de productos, se debe realizar una petición GET a la siguiente URL:

### Ejecutar standalone

mvn package

spring_mock_api-0.0.1-SNAPSHOT.jar