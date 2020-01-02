package com.example;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.mongodb.client.result.UpdateResult;

@SpringBootApplication
public class MongoTxApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(MongoTxApplication.class, args);
	}
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private MongoOperations mongoOperations;

	@Override
	public void run(String... args) throws Exception {
		User john = User.builder().username("John").createdDate(LocalDateTime.now()).password("John").build();
		User mike = User.builder().username("Mike").createdDate(LocalDateTime.now()).password("Mike").build();
		
		userRepository.saveAll(Arrays.asList(john, mike));
		
		
		User u = userRepository.findByUsernameIgnoreCase("John");
		System.out.println(u);
		
		/*
		Query query = new Query(Criteria.where("username").is("John"));
		System.out.println("QUERY = "+query);
		
		User u = mongoOperations.findOne(query, User.class);
		System.out.println(u);
		
		// Update 
		UpdateResult updateFirst = mongoOperations.updateFirst(query, Update.update("password", "New_John"), User.class);
		System.out.println("UPDATE = "+updateFirst);
		
		List<User> users = mongoOperations.findAll(User.class);
		System.out.println(users);
		*/

	}
}
