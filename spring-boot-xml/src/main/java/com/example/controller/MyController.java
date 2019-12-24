package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Cities;
import com.example.model.City;
import com.example.service.ICityService;

@RestController
public class MyController {

	@Autowired
	private ICityService cityService;

	@GetMapping(value = "/cities", produces = MediaType.APPLICATION_XML_VALUE)
	public Cities findCities() {
		return cityService.findAll();
	}

	@RequestMapping(value = "/cities/{cityId}", produces = MediaType.APPLICATION_XML_VALUE)
	public City findCity(@PathVariable Long cityId) {
		City city = cityService.findById(cityId);
		return city;
	}
}