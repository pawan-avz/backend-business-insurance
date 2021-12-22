package com.backend.BIPC;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class BipcApplication {

	public static void main(String[] args) {
		SpringApplication.run(BipcApplication.class, args);
		System.out.println("server is running");
	}

}
