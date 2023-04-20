
# Spring Boot WebApp Project with H2 in-memory database
This is a basic Spring Boot webapp project that implements the main HTTP methods: GET, POST, PUT and DELETE. It uses an H2 in-memory database to store data.

## Requirements
To build and run this project, you will need:

Java 17
Maven
## Getting Started
The application will start running at http://localhost:8080

## Usage
The application exposes the following endpoints:

## GET /api/items
Retrieves a list of all items in the database.

## GET /api/items/{id}
Retrieves a single item with the given ID.

## POST /api/items
Creates a new item. The request body should be a JSON object with the following properties:

```
{  
    "nombre": "New Item Name",  
    "precio": 12.99,
    "descripcion": "New item description"
}
```  
## PUT /api/items/{id}
Updates an existing item with the given ID. The request body should be a JSON object with the following properties:
```
{  
    "nombre": "New Item Name",  
    "precio": 12.99,
    "descripcion": "Item description"
}
```
## DELETE /api/items/{id}
Deletes an existing item with the given ID.

## H2 Database
This application uses an H2 in-memory database to store data. The database is automatically created when the application starts up .

You can access the H2 console by visiting http://localhost:8080/h2-console in your web browser. The JDBC URL is jdbc:h2:mem:testdb and the username is sa. There is no password required.

## Contributing
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

Please make sure to update tests as appropriate.

## License
This is an open source project, which means it is free to use, modify and distribute. 
