package com.softlaboratory.springloggingproject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringloggingProjectApplication {

	private static Logger logger = LoggerFactory.getLogger(SpringloggingProjectApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringloggingProjectApplication.class, args);

		logger.info("Info Log");
		logger.debug("Debug Log");
		logger.trace("Trace Log");
		logger.error("Error Log");
		logger.warn("Warning Log");

	}

}
