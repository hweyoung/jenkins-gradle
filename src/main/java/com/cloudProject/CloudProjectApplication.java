package com.cloudProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class CloudProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudProjectApplication.class, args);
	}

}
