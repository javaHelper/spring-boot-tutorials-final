package com.example.jasypt;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MyConfig {
	@Value("${variable.secret-var}")
	private String mySecretVar;
	
	public void printVariable(){
		System.out.println("============================================");
		System.out.format("My secret variable is: %s\n", mySecretVar);
		System.out.println("============================================");
	}
}
