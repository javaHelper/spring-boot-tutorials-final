package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.PersonAddress;


@Repository
public interface PersonAddressRepository extends CrudRepository<PersonAddress, String>{

	PersonAddress findByCity(String city);

}
