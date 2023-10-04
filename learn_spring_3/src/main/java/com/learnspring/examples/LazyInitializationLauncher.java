package com.learnspring.examples;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;



@Component
class ClassA {
	
}

// @Lazy loads the content when it is used
// Default initialization is Eager - recommended ( at start up of app)
@Component
@Lazy
class ClassB{
	private ClassA classA;
	
	public ClassB(ClassA classA) {
		System.out.println("Intitializer");
		this.classA = classA;
	}
}


@Configuration
@ComponentScan
public class LazyInitializationLauncher {

	public static void main(String[] args) {
		try(var context = new AnnotationConfigApplicationContext(LazyInitializationLauncher.class)){
			//Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
			System.out.println("Initializing context");
			System.out.println(context.getBean(ClassB.class));	
		}
	}
}
