package com.example.restapi.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.restapi.dto.SomeBean;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;


@RestController
public class FilteringController {
	

	@GetMapping("/filtering")
	public MappingJacksonValue getBean() {
		SomeBean someBean = new SomeBean("crypto", "password123", "hello", "world");
		
		MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(someBean);
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("username","field3", "field4"); //these field will be displayed
		FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
		
		mappingJacksonValue.setFilters(filters);
		return mappingJacksonValue;
	}
	
	@GetMapping("/filtering-all")
	public MappingJacksonValue getAllBean() {
		List<SomeBean> list = Arrays.asList(
				new SomeBean("crypto", "password123", "hello", "world"),
				new SomeBean("cmantic", "passwosdggrd123", "hello", "world")
				);
		
		MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(list);
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("username","field3", "password");
		FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
		
		mappingJacksonValue.setFilters(filters);
		return mappingJacksonValue;
//		return Arrays.asList(
//				new SomeBean("crypto", "password123", "hello", "world"),
//				new SomeBean("cmantic", "passwosdggrd123", "hello", "world")
//				);
	}
}
