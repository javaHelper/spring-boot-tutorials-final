package com.example.demo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.example.demo.model.Model;

public interface ModelRepository extends MongoRepository<Model, Integer>{
	@Query(value="{ 'brand.$id' : ?0 }")
    public List<Model> findByBrandId(String id);
	
	Model findByBrand_Id(String id);
}
