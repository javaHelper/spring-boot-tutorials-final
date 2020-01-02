package com.example.demo.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Person;
import com.example.demo.model.PersonAddress;
import com.example.demo.repository.PersonAddressRepository;
import com.example.demo.repository.PersonRepository;



@RestController
@RequestMapping("/test")
public class PersonAndPersonAddressResource {

	@Autowired
	PersonRepository personRepo;
	
	@Autowired
	PersonAddressRepository addRepo;
	
	@PostMapping(path="/person")
	public void createPerson(@RequestBody Person person) {
		personRepo.save(person);
	}
	
	@PostMapping(path="/person/addr")
	public void createPersonAddress(@RequestBody PersonAddress personAddress) {
		addRepo.save(personAddress);
	}
	
	@GetMapping(path="/person")
	public List<Person> getPersons(){
		List<Person> list =  (List<Person>) personRepo.findAll();
		for(Person p : list) {
			System.out.println(p.getAddress());
		}
		return list;
	}
	
	@GetMapping(path="/person/addr")
	public List<PersonAddress> getAddress(){
		return  (List<PersonAddress>) addRepo.findAll();
	}
	
	@GetMapping(path="/person/address/{addrId}")
	public Person getPersonByAddressId(@PathVariable String addrId){
		return (Person) personRepo.findByAddress_AddressId(addrId);
	}
	
	@GetMapping(path="/person/{city}")
	public Person getPersonByCity(@PathVariable String city){
		String addrId = addRepo.findByCity(city).getAddressId();
		return  (Person) personRepo.findByAddress_AddressId(addrId);
	}
}
