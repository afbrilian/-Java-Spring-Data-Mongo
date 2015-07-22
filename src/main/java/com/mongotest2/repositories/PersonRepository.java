package com.mongotest2.repositories;

import com.mongotest2.model.Person;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

//@Repository is the DAO
@Repository
public interface PersonRepository extends MongoRepository<Person, String> {
	
}
