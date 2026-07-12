package com.navira.contactus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.jdbc.autoconfigure.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class ContactusApplication {

	public static void main(String[] args) {
		SpringApplication.run(ContactusApplication.class, args);
	}

}
