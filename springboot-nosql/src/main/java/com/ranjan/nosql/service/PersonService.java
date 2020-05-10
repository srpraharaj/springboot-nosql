package com.ranjan.nosql.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ranjan.nosql.models.Person;
import com.ranjan.nosql.repository.PersonRepo;

@Service
public class PersonService {

	@Autowired
	private PersonRepo personRepo;
	
	public Person create(String firstName, String lastName, int age) {
		return personRepo.save(new Person(firstName, lastName, age));
	}
	
	public List<Person> getAll(){
		return personRepo.findAll();
	}
	
	public Person getByFirstName(String firstName) {
		return personRepo.findByFirstName(firstName);
	}
	
	public List<Person> getByAge(int age) {
		return personRepo.findByAge(age);
	}
	
	public Person update(String firstName, String lastName, int age) {
		Person p = personRepo.findByFirstName(firstName);
		p.setLastName(lastName);
		p.setAge(age);
		
		return personRepo.save(p);
	}
	
	public void deleteAll() {
		personRepo.deleteAll();
	}

	public void delete(String firstName) {
		Person p = personRepo.findByFirstName(firstName);
		personRepo.delete(p);
	}
}
