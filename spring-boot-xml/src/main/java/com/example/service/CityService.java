package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Cities;
import com.example.model.City;
import com.example.repository.CityRepository;

@Service
public class CityService implements ICityService {

    @Autowired
    private CityRepository repository;

    @Override
    public Cities findAll() {
    	List<City> cities = (List<City>) repository.findAll();
        Cities mycities = new Cities();
        mycities.setCities(cities);
        return mycities;
    }

    @Override
    public City findById(Long id) {
        Optional<City> optionalCity = repository.findById(id);
        if(optionalCity.isPresent()) {
        	return optionalCity.get();
        }
        return null;
    }
}