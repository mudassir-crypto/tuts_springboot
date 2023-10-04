package com.example.springboot_basic1.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CourseDto {
	
	private Long id;
	private String name;
	private String author;
	
	@Override
	public String toString() {
		return "CourseDto [id=" + id + ", name=" + name + ", author=" + author + "]";
	}
}
