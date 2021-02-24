package com.join.getaccount;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class GetaccountApplication {

	public static void main(String[] args) {
		SpringApplication.run(GetaccountApplication.class, args);
	}
}
