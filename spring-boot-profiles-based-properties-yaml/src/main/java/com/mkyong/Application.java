package com.mkyong;

import com.mkyong.config.ServerProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//https://www.mkyong.com/spring-boot/spring-boot-configurationproperties-example/
//https://docs.spring.io/spring-boot/docs/current/reference/html/boot-features-external-config.html#boot-features-external-config-profile-specific-properties
@SpringBootApplication
public class Application implements CommandLineRunner {

	// Note: If you want to use the prod property, then change the spring.profiles.active value
	
    @Autowired
    private ServerProperties serverProperties;

    @Override
    public void run(String... args) throws Exception {
    	System.out.println("Environment Details @@@@@@@\n");
        System.out.println(serverProperties);
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }

}
