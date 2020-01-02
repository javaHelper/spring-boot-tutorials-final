package com.example.repository;

import java.util.List;

import org.javers.spring.annotation.JaversSpringDataAuditable;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.model.Car;

@JaversSpringDataAuditable
public interface CarRepository extends MongoRepository<Car, String>{
	Car findByModel(String string);
	List<Car> findByHorsePowerLessThan(int i);
}
