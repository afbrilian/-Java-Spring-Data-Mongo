package com.mongotest2.run;

import com.mongotest2.beans.RegistrationBean;
import com.mongotest2.model.Person;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestUnit {
	public static RegistrationBean registrationBean;
	public static ClassPathXmlApplicationContext context;
	
	static {
		context = new ClassPathXmlApplicationContext("SpringContext.xml");
	}
	
	public static void main(String [] args) throws Exception {
		Person a = new Person("Joni", "Jakarta", 22);
		
//		Use the mongoTemplate
//		MongoTemplate mongoOps = (MongoTemplate)context.getBean("mongoTemplate");
//		mongoOps.insert(a);
		
//		Use the Repository
		RegistrationBean registrationBean = (RegistrationBean)context.getBean("registrationBean");
		registrationBean.getRepository().save(a);
		for (Person p : registrationBean.getRepository().findAll()) {
			System.out.println(p.toString());
		}
	}
	
}
