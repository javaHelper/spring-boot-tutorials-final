# Encrypting properties with jasypt-spring-boot

Intro
In this post we take a look at how to quickly and easily encrypt properties in Spring Boot applications. To do that, we use the nifty jasypt-spring-boot project up on Github and on Maven Central.

Also, the “app” we build is up on Github (master branch) if you want to simply clone and run.

Something to work with
Technically, we could do with a lot less than what I decided to go with in order to see this thing work, but in an effort to make it more real we actually encrypt something sensitive; a database user’s password.

So to get started we need to bring in some dependencies:

- jasypt-spring-boot-starter
- spring-boot-starter-web
- spring-jdbc
- mysql-connector-java

# Running
When running the app, make sure you don’t forget to pass in a value of supersecretz for the argument (command line or JVM) jasypt.encryptor.password e.g:

```
mvn -Djasypt.encryptor.password=root spring-boot:run
```

You can then verify the connection to the database by hitting the REST endpoint:

```
http://localhost:8080/contacts?offset=2&rowCount=6
```

```
[
    {
        "id": 3,
        "name": "Bob",
        "email": "bob@somewhere.com",
        "company": "def"
    },
    {
        "id": 4,
        "name": "Bill",
        "email": "bill@somewhere.com",
        "company": "abc"
    },
    {
        "id": 5,
        "name": "Jack",
        "email": "jack@abc.com",
        "company": "abc"
    },
    {
        "id": 6,
        "name": "Tim",
        "email": "tim@def.com",
        "company": "def"
    },
    {
        "id": 7,
        "name": "Jasmine",
        "email": "jasmine@wat.com",
        "company": "wat"
    },
    {
        "id": 8,
        "name": "Sally",
        "email": "sally@mally.com",
        "company": "mally"
    }
]
```


I hope this post has been of some use in showing how easily you can encrypt properties with jasypt-spring-boot. The details regarding different configuration options, as well as other information in general, can be found in the project’s README.md file up on Github.


```
C:\Users\user\.m2\repository\org\jasypt\jasypt\1.9.2>java -cp jasypt-1.9.2.jar org.jasypt.intf.cli.JasyptPBEStringEncryptionCLI input="contactspassword" password=supersecretz algorithm=PBEWithMD5AndDES

----ENVIRONMENT-----------------

Runtime: Oracle Corporation Java HotSpot(TM) 64-Bit Server VM 25.171-b11

----ARGUMENTS-------------------

algorithm: PBEWithMD5AndDES
input: contactspassword
password: supersecretz

----OUTPUT----------------------

H6m8dHdKbbC0b9w0u5CroQEWb/OQNKOBonmHLTc/efc=
```
