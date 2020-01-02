package com.example.repository;

import org.javers.spring.annotation.JaversSpringDataAuditable;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.model.Person;

@JaversSpringDataAuditable
public interface PersonRepository extends MongoRepository<Person, String>{

}
