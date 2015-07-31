package com.mongotest2.person.repositories;

import java.util.List;

import com.mongotest2.person.model.Person;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

//@Repository is the DAO
@Repository
public interface PersonRepository extends MongoRepository<Person, String> {
	List<Person> findByNameIgnoreCase(String Name);
}
