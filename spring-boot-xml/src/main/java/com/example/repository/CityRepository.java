package com.example.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.model.City;

@Repository
public interface CityRepository extends CrudRepository<City, Long> {

}