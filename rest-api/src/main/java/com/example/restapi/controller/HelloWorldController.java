package com.example.restapi.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.restapi.dto.HelloWorld;

@RestController
@RequestMapping("/api/hello")
public class HelloWorldController {
	

	@GetMapping("/hello")
	public String hello() {
		return "Hello World";
	}
	
	@GetMapping("/hello-world")
	public HelloWorld helloWorld() {
		HelloWorld hw = new HelloWorld(2,"Hello World");
		return hw;
	}
	
	@GetMapping("/hellow/{name}")
	public HelloWorld helloPath(@PathVariable("name") String name) {
		HelloWorld hw = new HelloWorld(2,"Hello " + name);
		return hw;
	}
	
}
