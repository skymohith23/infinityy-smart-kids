package com.infinityy.infinityy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.infinityy.infinityy")
public class InfinityyApplication {

	public static void main(String[] args) {
		SpringApplication.run(InfinityyApplication.class, args);
	}

}
