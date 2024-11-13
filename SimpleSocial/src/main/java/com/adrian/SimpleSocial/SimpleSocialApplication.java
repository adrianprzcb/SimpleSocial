package com.adrian.SimpleSocial;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.adrian.SimpleSocial")
public class SimpleSocialApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimpleSocialApplication.class, args);
	}

}
