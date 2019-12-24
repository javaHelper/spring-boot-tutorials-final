package com.example.service;

import com.example.model.Cities;
import com.example.model.City;

public interface ICityService {
	Cities findAll();
	City findById(Long id);
}