package com.example.springboot_basic1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CourseController {

	@GetMapping("/all")
	public String retrieveAllCourses() {
		return "All courses";
	}
}
