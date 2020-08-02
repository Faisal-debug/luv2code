package com.luv2code;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
//@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
public class Luv2CodeApplication {

	public static void main(String[] args) {
		SpringApplication.run(Luv2CodeApplication.class, args);
	}

}
