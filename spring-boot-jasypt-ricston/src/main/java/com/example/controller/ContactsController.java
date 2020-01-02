package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Contact;
import com.example.repository.ContactRepository;

@RestController
public class ContactsController {

	@Autowired
	private ContactRepository customerRepo;

	@GetMapping("/contacts")
	public List<Contact> contacts(
			@RequestParam(value = "offset", required = false) Integer offset,
			@RequestParam(value = "rowCount", required = false) Integer rowCount) {
		
		return customerRepo.find(offset, rowCount);
	}
}
