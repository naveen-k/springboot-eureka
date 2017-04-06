package com.naveen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Configuration;


@Configuration
@EnableAutoConfiguration
@EnableEurekaClient
@SpringBootApplication
@EnableDiscoveryClient
public class SchoolBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(SchoolBootApplication.class, args);
	}
}
