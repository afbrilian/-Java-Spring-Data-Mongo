# Java-Spring-Data-Mongo wiki!
This is the example of how java interact with mongoDB without using Spring boot!
## Dependency
* mongo java driver 2.11.4
* Spring data mongo 1.4.1.RELEASE
* Spring data commons 1.5.0.RELEASE

## How To Use
* Install maven, see: [https://maven.apache.org/users/index.html](https://maven.apache.org/users/index.html)
* Install mongoDB

## You Must Understand
* maven, used for Object Mapping (Dependency)
* mongoDB, Non-relational Database
* simple DAO (Data Access Object) Pattern
* Spring data mongo

## Description
This is just a simple application on how java interact with mongoDB. The basic concept of spring data (mongo) are: (we talk in this application context)
* the model itself (Person.java)
* the repository which is Spring DAO for accessing the mongoDB
* the Service (RegistrationBean.Java) in this case we use @component rather than @service
* XML as the "descriptor" on how java using spring data (SpringContext.xml)
