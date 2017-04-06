package com.naveen;

import java.util.HashMap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

import com.google.common.base.Predicates;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableAutoConfiguration
@EnableEurekaClient
@SpringBootApplication
@EnableDiscoveryClient

public class StdBootApplication {
	public static HashMap<Long, Student> hmStudent;
	public static void main(String[] args) {
		hmStudent = new HashMap<Long, Student>();

		Student one = new Student("John", "math");
		hmStudent.put(new Long(one.getId()), one);

		SpringApplication.run(StdBootApplication.class, args);

		Student two = new Student("Jane", "history");
		hmStudent.put(new Long(two.getId()), two);

	}
	
//	@Bean
//    public Docket swaggerSpringMvcPlugin() {
//        return new Docket(DocumentationType.SWAGGER_2)
//            .useDefaultResponseMessages(false)
//            .apiInfo(apiInfo())
//            .select()
//            .paths(Predicates.not(PathSelectors.regex("/error.*")))
//            .build();
//    }
//
//	private ApiInfo apiInfo() {
//		
//		return new ApiInfoBuilder()
//		        .title("My awesome API")
//		        .description("Some description")
//		        .version("1.0")
//		        .build();
//	}

	
}
