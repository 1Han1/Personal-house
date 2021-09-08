package com.client1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import net.unicon.cas.client.configuration.EnableCasClient;

@SpringBootApplication
@EnableCasClient
public class Client11Application {

	public static void main(String[] args) {
		SpringApplication.run(Client11Application.class, args);
	}

}
