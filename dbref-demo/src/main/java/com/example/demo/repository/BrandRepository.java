package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.model.Brand;

public interface BrandRepository extends MongoRepository<Brand, Integer>{

}
