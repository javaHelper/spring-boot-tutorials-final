# Authenticating a User with LDAP
This guide walks you through the process creating an application and securing it with the Spring Security LDAP module.

# What you’ll build
You’ll build a simple web application that is secured by Spring Security’s embedded Java-based LDAP server. You’ll load the LDAP server with a data file containing a set of users.

#The Spring Boot Maven plugin provides many convenient features:

- It collects all the jars on the classpath and builds a single, runnable "über-jar", which makes it more convenient to execute and transport your service.
- It searches for the public static void main() method to flag as a runnable class.
- It provides a built-in dependency resolver that sets the version number to match Spring Boot dependencies. You can override any version you wish, but it will default to Boot’s chosen set of versions.


The entire class is marked up with ``@RestController`` so Spring MVC can autodetect the controller using it’s built-in scanning features and automatically configure web routes.

The method is tagged with ``@RequestMapping`` to flag the path and the REST action. In this case, GET is the default behavior; it returns a message indicating that you are on the home page.

``@RestController`` also tells Spring MVC to write the text directly into the HTTP response body, because there aren’t any views. Instead, when you visit the page, you’ll get a simple message in the browser as the focus of this guide is securing the page with LDAP.



@SpringBootApplication is a convenience annotation that adds all of the following:

- @Configuration tags the class as a source of bean definitions for the application context.
- @EnableAutoConfiguration tells Spring Boot to start adding beans based on classpath settings, other beans, and various property settings.
- Normally you would add @EnableWebMvc for a Spring MVC app, but Spring Boot adds it automatically when it sees spring-webmvc on the classpath. This flags the application as a web application and activates key behaviors such as setting up a DispatcherServlet.
- @ComponentScan tells Spring to look for other components, configurations, and services in the hello package, allowing it to find the controllers.

The main() method uses Spring Boot’s SpringApplication.run() method to launch an application. Did you notice that there wasn’t a single line of XML? No web.xml file either. This web application is 100% pure Java and you didn’t have to deal with configuring any plumbing or infrastructure.

# Build an executable JAR
You can run the application from the command line with Gradle or Maven. Or you can build a single executable JAR file that contains all the necessary dependencies, classes, and resources, and run that. This makes it easy to ship, version, and deploy the service as an application throughout the development lifecycle, across different environments, and so forth.

If you are using Gradle, you can run the application using ./gradlew bootRun. Or you can build the JAR file using ./gradlew build. Then you can run the JAR file:

```
java -jar build/libs/gs-authenticating-ldap-0.1.0.jar
```

If you are using Maven, you can run the application using ./mvnw spring-boot:run. Or you can build the JAR file with ``./mvnw clean package``. Then you can run the JAR file:

```
java -jar target/gs-authenticating-ldap-0.1.0.jar
```

The procedure above will create a runnable JAR. You can also opt to build a classic WAR file instead.

If you visit the site at http://localhost:8080, you should be redirected to a login page provided by Spring Security.

Enter username ben and password benspassword. You should see this message in your browser:

Welcome to the home page!