package com.example.restapi.dto;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
//@JsonIgnoreProperties({"field3", "username"}) //static
@JsonFilter("SomeBeanFilter") //dynamic
public class SomeBean {

	private String username;
	
	//@JsonIgnore
	private String password;
	private String field3;
	private String field4;
}
