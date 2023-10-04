package com.learnspring.excercise;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.learnspring.excercise.ds.BusinessCalculation;






@Configuration
@ComponentScan
public class SpringContextLauncher {

	public static void main(String[] args) {
		try(var context = new AnnotationConfigApplicationContext(SpringContextLauncher.class)){
			//Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
			System.out.println(context.getBean(BusinessCalculation.class).findMax());
		}
	}
}
