package com.mostafa.hellohuman;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class HellohumanApplication {

	public static void main(String[] args) {
		SpringApplication.run(HellohumanApplication.class, args);
	}
	
	@RequestMapping("/")
	public String hello() {
		return "Hello Human";
	}
	
	@RequestMapping("/name")
	public String helloName(@RequestParam(value="name") String myName) {
		return "Hello " + myName;
	}

}
