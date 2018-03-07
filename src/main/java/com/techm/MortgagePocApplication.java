package com.techm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages ="com.techm.*")
@SpringBootApplication
public class MortgagePocApplication {

	public static void main(String[] args) {
		SpringApplication.run(MortgagePocApplication.class, args);
	}
}
