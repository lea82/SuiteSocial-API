package com.advantal.suitesocial;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages="com")
@ComponentScan("com")
@EnableJpaRepositories("com")
public class SuiteSocialApplication {

	public static void main(String[] args) {
	 	SpringApplication.run(SuiteSocialApplication.class, args);
	 }

}  
