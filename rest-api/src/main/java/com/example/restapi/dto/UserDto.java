package com.example.restapi.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserDto {
	
	private Long id;
	
	@Size(min = 2, message = "Name should atleast have 2 characters")
	@JsonProperty("user_name")
	private String name;
	
	@Past(message = "Birth Date should be in the past")
	@JsonProperty("birth_date")
	private LocalDate birthDate;
	
	
}
