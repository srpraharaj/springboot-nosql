package com.ranjan.nosql.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ranjan.nosql.models.Person;

@Repository
public interface PersonRepo extends MongoRepository<Person, String>{
	
	public Person findByFirstName(String firstName);
	
	public List<Person> findByAge(int age);


}
