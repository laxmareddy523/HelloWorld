package com.javacodegeeks.examples;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/")
public class HelloController {
	
	@Value("${person.name}")
	private String name;
	
	@Autowired
	private Person person;
	
	@GetMapping("/hello")
	public String hello() {
		return "Hello " + name;
	}

	@PostConstruct
	private void printPerson() {
		System.out.println("name: " + person.name);
		System.out.println("age: " + person.age);
		System.out.println("title: " + person.title);
	}
}
