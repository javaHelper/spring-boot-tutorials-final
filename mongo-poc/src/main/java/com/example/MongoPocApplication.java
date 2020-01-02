package com.example;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.mongodb.BasicDBObject;
import com.mongodb.CommandResult;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.MongoException;

@SpringBootApplication
public class MongoPocApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(MongoPocApplication.class, args);
	}

	@Autowired
	private PersonRepository repository;
	@Autowired
	private MongoTemplate mongoTemplate;

	@Override
	public void run(String... args) throws Exception {
		savePersons();

		List<Object> object = mongoTemplate.query(Person.class).distinct("hobbies").all();
		for (Object object2 : object) {
			Hobbies hobbies = (Hobbies) object2;
			System.out.println(hobbies);
		}

		/*Mongo mongo = new Mongo("localhost",1234);
		DBObject ping = new BasicDBObject("ping", "1");
		try {
			CommandResult command = mongo.getDB("POC").command(ping);	       
			System.out.println(command.ok());
			
		} catch (MongoException e) {

		}*/

	}

	private void savePersons() {
		Hobbies hobbies1 = Hobbies.builder().interest("Indoor").status("Active").sports("Chess").build();
		Hobbies hobbies2 = Hobbies.builder().interest("Loveoor").sports("Table Tennis").build();
		Hobbies hobbies3 = Hobbies.builder().interest("Indoor").sports("Chess").build();

		Person john = Person.builder().firstName("John").lastName(null)
				.emailId("john.kerr@gmail.com").hobbies(Arrays.asList(hobbies1, hobbies2)).build();
		
		Person ravi = new Person();
		ravi.setFirstName("Ravi");
		ravi.setLastName(null);
		ravi.setEmailId("ravi@gmail.com");
		ravi.setHobbies(Arrays.asList(hobbies1, hobbies2, hobbies3));
		
		repository.saveAll(Arrays.asList(ravi, john));
		
	
		List<Person> persons = (List<Person>) repository.findAll();
		for (Person person : persons) {
			System.out.println(person);
		}
		
		
		/*Document hobbies1 = new Document();
		hobbies1.put("interest", "Indoor");
		hobbies1.put("sports", "Chess");
		
		Document hobbies2 = new Document();
		hobbies2.put("Loveoor", "Table Tennis");
		hobbies2.put("Gamedoor", "Cricket");

		BSONObject personBsonObj = BasicDBObjectBuilder.start()
				.add("firstName","John")
				.add("lastName", null)
				.add("email","john.kerr@gmail.com")
				.add("hobbies",Arrays.asList(hobbies1, hobbies2)).get();
		
		BSONObject insert = mongoTemplate.insert(personBsonObj,"person");
		System.out.println(insert);*/
	}

}
