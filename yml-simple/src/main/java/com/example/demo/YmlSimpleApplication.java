package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.config.GlobalProperties;
import com.example.demo.config.WordPressProperties;

@SpringBootApplication
public class YmlSimpleApplication implements CommandLineRunner{
	
	@Autowired
    private WordPressProperties wpProperties;

    @Autowired
    private GlobalProperties globalProperties;

	public static void main(String[] args) {
		SpringApplication.run(YmlSimpleApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println(globalProperties);
        System.out.println(wpProperties);
	}

}
