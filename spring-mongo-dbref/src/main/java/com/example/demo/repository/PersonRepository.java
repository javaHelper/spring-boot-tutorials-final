package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Person;


@Repository
public interface PersonRepository extends CrudRepository<Person, String>{

	public Person findByAddress_AddressId(String addressId);
	
}
