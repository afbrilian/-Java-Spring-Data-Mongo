package com.mongotest2.person.dao;

import java.util.List;

import com.mongotest2.person.model.Person;

public interface PersonDao {
	void save(String name, String homeTown, int age);
	public List<Person> findAll();
	public List<Person> findByNameIgnoreCase(String name);
	public void cleanCollections();
}
