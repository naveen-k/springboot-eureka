package com.naveen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class EurekaBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaBootApplication.class, args);
	}
}
