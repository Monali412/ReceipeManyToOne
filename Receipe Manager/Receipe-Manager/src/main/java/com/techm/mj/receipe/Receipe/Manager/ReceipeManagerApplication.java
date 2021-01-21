package com.techm.mj.receipe.Receipe.Manager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class ReceipeManagerApplication {
	public static void main(String[] args) {
		SpringApplication.run(ReceipeManagerApplication.class, args);
	}
}
