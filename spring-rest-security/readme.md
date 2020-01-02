# Spring REST + Spring Security Example

In this article, we will enhance the previous Spring REST Validation Example, by adding Spring Security to perform authentication and authorization for the requested URLs (REST API endpoints)

Technologies used :

- Spring Boot 2.1.2.RELEASE
- Spring 5.1.4.RELEASE
- Spring Security 5.1.3.RELEASE
- Spring Data JPA 2.1.4.RELEASE
- H2 In-memory Database 1.4.197
- Tomcat Embed 9.0.14
- JUnit 4.12
- Maven 3
- Java 8

# 6.1 Start the Spring Boot application.
```
mvn spring-boot:run
```

# 6.2 A normal GET and POST will return a 401, all endpoints are protected, need authentication.

```
curl -s localhost:8080/books
{"timestamp":"2019-02-27T16:38:08.931+0000","status":401,"error":"Unauthorized","message":"Unauthorized","path":"/books"}
```

```
 curl -s -X POST localhost:8080/books -H "Content-type:application/json" -d {\"name\":\"ABC\",\"author\":\"mkyong\",\"price\":\"8.88\"}
{"timestamp":"2019-02-27T16:56:44.242+0000","status":401,"error":"Unauthorized","message":"Unauthorized","path":"/books"}
```

# 6.3 Send a GET request along with user login.

```
curl -s localhost:8080/books -u user:password

[{"id":1,"name":"A Guide to the Bodhisattva Way of Life","author":"Santideva","price":15.41},{"id":2,"name":"The Life-Changing Magic of Tidying Up","author":"Marie Kondo","price":9.69},{"id":3,"name":"Refactoring: Improving the Design of Existing Code","author":"Martin Fowler","price":47.99}]
```

```
curl -s localhost:8080/books/1 -u admin:password
{"id":1,"name":"A Guide to the Bodhisattva Way of Life","author":"Santideva","price":15.41}
```

# 6.4 Try to send a POST request with user login, it will return 403, Forbidden error. This is because the user has no right to send a POST request.

```
curl -s -X POST localhost:8080/books -H "Content-type:application/json" -d {\"name\":\"ABC\",\"author\":\"mkyong\",\"price\":\"8.88\"} -u user:password
{"timestamp":"2019-02-27T17:01:59.898+0000","status":403,"error":"Forbidden","message":"Forbidden","path":"/books"}
```

# 6.5 Try to send a POST request with admin login
try from windows CMD

```
curl -s -X POST localhost:8080/books -H "Content-type:application/json" -d {\"name\":\"ABC\",\"author\":\"mkyong\",\"price\":\"8.88\"} -u admin:password
{"id":4,"name":"ABC","author":"mkyong","price":8.88}
```

```
curl -s localhost:8080/books -u user:password
[{"id":1,"name":"A Guide to the Bodhisattva Way of Life","author":"Santideva","price":15.41},{"id":2,"name":"The Life-Changing Magic of Tidying Up","author":"Marie Kondo","price":9.69},{"id":3,"name":"Refactoring: Improving the Design of Existing Code","author":"Martin Fowler","price":47.99},{"id":4,"name":"ABC","author":"mkyong","price":8.88}]
```
