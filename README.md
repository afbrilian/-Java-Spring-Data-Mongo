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

This application could use mongoDB in 2 ways, using MongoTemplate or Repository concept. This application will work by reading the SpringContext as it will initialize the connection and database name for the mongoDB. 
The MongoTemplate will works automatically as it is the standart method to use the mongoDB using insert, update, delete, etc.
The Repository concept will work by using the MongoRepository interface (DAO) and a service to access the method. there is 2 ways to determine on how to use this concept, first using the manual method to determine where the repository located and referenced those repository to the bean and call it at runtime or (the nice way!) using @autowired and it will be handled automatically.

How it looks on the manual method:
```
  <mongo:repositories base-package="com.mongotest2.repositories" >
		<mongo:repository id="personRepository" mongo-template-ref="mongoTemplate"/>
	</mongo:repositories>
	
	<bean id="registrationBean" class="com.mongotest2.beans.RegistrationBean">
	  <property name="repository" ref="personRepository" />
	</bean>
```
* first you should define the bean
* define the repository and its id
* connect to the property name in service (registrationBean.java)

And for the automatic method:
```
  <context:component-scan base-package="com.mongotest2.beans">
	</context:component-scan>
```
* Only need to define the component-scan and the @autowired do the rest.

At runtime (TestUnit.java) this application will read the XML config (SpringContext.xml), getBean method will call the bean and its done.

Any question or improvement for this explanation is welcomed :)
