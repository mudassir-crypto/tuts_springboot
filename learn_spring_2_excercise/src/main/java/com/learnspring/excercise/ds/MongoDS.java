package com.learnspring.excercise.ds;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class MongoDS implements DataService{

	@Override
	public int[] retrieveData() {
		
		return new int[] {11,45,84,12,31};
	}

	
}
