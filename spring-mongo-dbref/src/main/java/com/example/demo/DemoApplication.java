package com.example.demo;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.model.Person;
import com.example.demo.model.PersonAddress;
import com.example.demo.repository.PersonAddressRepository;
import com.example.demo.repository.PersonRepository;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Autowired
	private PersonRepository personRepository;
	@Autowired
	private PersonAddressRepository personAddressRepository;



	@Override
	public void run(String... args) throws Exception {
		//save();
		List<Person> persons = (List<Person>) personRepository.findAll();
		for (Person person : persons) {
			System.out.println(person.toString());
		}
	}



	private void save() {
		PersonAddress pa1 = PersonAddress.builder().addressId("1").street("Street-1").city("Pune").state("MH").country("India").build();
		personAddressRepository.save(pa1);

		Person person = Person.builder().firstName("").lastName("").address(Arrays.asList(pa1)).build();
		personRepository.save(person);
	}

}
