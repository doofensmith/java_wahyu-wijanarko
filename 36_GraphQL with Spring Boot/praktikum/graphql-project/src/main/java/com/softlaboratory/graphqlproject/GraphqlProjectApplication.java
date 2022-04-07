package com.softlaboratory.graphqlproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Import;

@SpringBootApplication
public class GraphqlProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(GraphqlProjectApplication.class, args);
	}

}
