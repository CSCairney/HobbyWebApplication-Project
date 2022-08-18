package com.qa.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;

//@EnableWebMvc - remove this after screenshotting swagger information. also add swagger dependency
@SpringBootApplication
public class JuneEnableSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(JuneEnableSpringApplication.class, args);
	}

}
