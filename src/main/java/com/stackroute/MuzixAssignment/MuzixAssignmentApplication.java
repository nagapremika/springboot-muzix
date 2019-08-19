package com.stackroute.MuzixAssignment;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.bind.annotation.CrossOrigin;
@EnableCaching
@SpringBootApplication
@EnableJpaAuditing //to track and log every change
@Slf4j
public class MuzixAssignmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(MuzixAssignmentApplication.class, args);
	}

}
