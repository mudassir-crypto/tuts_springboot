package com.learnspring.excercise.ds;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class SqlDS implements DataService{
	
	@Override
	public int[] retrieveData() {
		
		return new int[] {84,12,31,52,45,98};
	}

}
