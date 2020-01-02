package com.example;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String>{

	User findByUsernameIgnoreCase(String username);
}
