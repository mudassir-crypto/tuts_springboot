package com.learnspring.excercise.ds;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import com.learnspring.excercise.ds.DataService;

@Configuration
@Component
public class BusinessCalculation {
	
	private DataService dataService;
	
	

	public BusinessCalculation(DataService dataService) {
		super();
		this.dataService = dataService;
	}
	
	public int findMax() {
		return Arrays.stream(dataService.retrieveData()).max().orElse(0);
	}

}
