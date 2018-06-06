package com.hong.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.hong")
public class JpaIn10StepsApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaIn10StepsApplication.class, args);
	}
}