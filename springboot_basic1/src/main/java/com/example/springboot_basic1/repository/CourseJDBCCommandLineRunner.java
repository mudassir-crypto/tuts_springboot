package com.example.springboot_basic1.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.springboot_basic1.dto.CourseDto;
import com.example.springboot_basic1.entity.Course;

@Component
public class CourseJDBCCommandLineRunner implements CommandLineRunner{
		
//	@Autowired
//	private CourseJDBCRepository courseRepository;
	
	@Autowired
	private CourseRepository courseRepository;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		//courseRepository.insert(new Course((long) 3, "Learn Devops3", "Tj"));
		//courseRepository.insert(new Course((long) 4, "Learn Devops4", "Tj"));
		//courseRepository.deleteById((long) 5);
		System.out.println(courseRepository.findById(2l));
		System.out.println(courseRepository.findById(1l));
		System.out.println(courseRepository.findAll());
		System.out.println(courseRepository.count());
		System.out.println(courseRepository.findByAuthor("Tj"));
		System.out.println(courseRepository.findByName("Learn AWS"));
	}

}
