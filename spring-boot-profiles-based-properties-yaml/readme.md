# Spring Boot – Profile based properties and yaml example

In Spring Boot, it picks .properties or .yaml files in the following sequences :

1. application-{profile}.{properties|yml}
2. application.{properties|yml}

Tested :

- Spring Boot 2.1.3.RELEASE
- Maven

P.S The application.yml is renamed to application-bk.yml to avoid conflicts. If you want to test the YAML file, please rename it back to application.yml and delete all the .properties files.

#4. Profile based YAML

Multi profiles .yml example. In YAML, we can create multiple profiles by using a “—” separator.

```
$ java -jar target/spring-boot-profile-1.0.jar
Environment Details @@@@@@@

ServerProperties{email='dev@mkyong.com', cluster=[Cluster{ip='127.0.0.1', path='/dev1'}, Cluster{ip='127.0.0.2', path='/dev2'}, Cluster{ip='127.0.0.3', path='/dev3'}]}
```

```
$ java -jar -Dspring.profiles.active=prod target/spring-boot-profile-1.0.jar
Environment Details @@@@@@@

ServerProperties{email='prod@mkyong.com', cluster=[Cluster{ip='192.168.0.1', path='/app1'}, Cluster{ip='192.168.0.2', path='/app2'}, Cluster{ip='192.168.0.3', path='/app3'}]}
```

```
$ java -jar -Dspring.profiles.active=abc target/spring-boot-profile-1.0.jar
Environment Details @@@@@@@

ServerProperties{email='null', cluster=[]}
```

