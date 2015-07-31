package com.mongotest2.run;

import java.util.ArrayList;
import java.util.List;

import com.mongotest2.beans.RegistrationBean;
import com.mongotest2.model.Person;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.mongodb.core.MongoTemplate;

public class TestUnit {
	public static RegistrationBean registrationBean;
	public static ClassPathXmlApplicationContext context;
	
	static {
		context = new ClassPathXmlApplicationContext("SpringContext.xml");
	}
	
	public static void main(String [] args) throws Exception {		
		//Use the mongoTemplate
		mongoTemplateMethod();
		//Use the Repository
		repositoryMethod();
	}
	
	public static void mongoTemplateMethod(){
		MongoTemplate mongoOps = (MongoTemplate)context.getBean("mongoTemplate");
		
		//clean the db first
		mongoOps.dropCollection(Person.class); //use reflect
		
		//insert new documents
		List<Person> persons = new ArrayList();
		persons.add(new Person("Joni", "Jakarta", 22));
		persons.add(new Person("Jona", "Depok", 23));
		mongoOps.insert(persons, Person.class);
	}
	
	public static void repositoryMethod(){
		RegistrationBean registrationBean = (RegistrationBean)context.getBean("registrationBean");
		
		//clean the db first
		registrationBean.getRepository().deleteAll();
		
		//insert new documents
		List<Person> persons = new ArrayList();
		persons.add(new Person("Joni", "Jakarta", 22));
		persons.add(new Person("Jona", "Depok", 23));
		registrationBean.getRepository().save(persons);
		
		//retrieve documents
		for (Person p : registrationBean.getRepository().findAll()) {
			System.out.println(p.toString());
		}
		
		for (Person p : registrationBean.getRepository().findByNameIgnoreCase("jona")) {
			System.out.println(p.toString());
		}
	}
	
}
