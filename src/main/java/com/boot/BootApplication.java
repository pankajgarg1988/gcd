package com.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@ComponentScan({"com.boot"})
@SpringBootApplication
@EnableScheduling
//@EnableSpringDataWebSupport
public class BootApplication {
	

	public static void main(String[] args) {
		SpringApplication.run(BootApplication.class, args);
	}
}
