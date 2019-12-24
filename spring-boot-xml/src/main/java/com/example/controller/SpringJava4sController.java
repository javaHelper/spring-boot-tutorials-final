package com.example.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Customer;

@RestController
public class SpringJava4sController {

	@PostMapping(path = "/save-cust-info")
	public String saveCustomerInformation(@RequestBody Customer cust) {

		/*
		 * You can call your DAO logic here. For time being I am printing the customer
		 * data just to show the POST call is working.
		 */

		return "Customer information saved successfully ::." + cust.getCustNo() + " " + cust.getName() + " "
				+ cust.getCountry();
	}
	
	
	@GetMapping(value = "/customers/{customer-id}", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},   
			produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE} )
	public Customer customerInformation(@PathVariable("customer-id") Integer customerId) {
		return new Customer(111, "Prateek", "India");
				
	}
}