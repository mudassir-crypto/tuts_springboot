package com.basic.basiccoupling.examples.a1;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
class BusinessClass {
//	@Autowired
	Dependency1 d1;
//	@Autowired
	Dependency2 d2;
	
//	@Autowired
//	public void setD1(Dependency1 d1) {
//		System.out.println("Setter injection - d1");
//		this.d1 = d1;
//	}
//	
//	@Autowired
//	public void setD2(Dependency2 d2) {
//		System.out.println("Setter injection - d2");
//		this.d2 = d2;
//	}
	
	// on constructor injection autowired is not necessary
	public BusinessClass(Dependency1 d1, Dependency2 d2) {
		super();
		System.out.println("Constructor injection - BusinessCall");
		this.d1 = d1;
		this.d2 = d2;
	}
	
	public String toString() {
		return "Using " + d1 + " and " + d2;
	}
	
}

//without autowired, it is returning null

@Component
class Dependency1 {
	
}

@Component
class Dependency2 {
	
}

@Configuration
@ComponentScan
public class DepInjectionAppLauncher {
	
//	The @Component annotation in pacman does it automatically
//	@Bean
//	public GamingConsole game() {
//		var game = new Pacman();
//		return game;
//	}

//	@Bean
//	public GameRunner gameRunner(GamingConsole game) {
//		var gameRunner = new GameRunner(game);
//		return gameRunner;
//	}
	
	public static void main(String[] args) {
		try(var context = new AnnotationConfigApplicationContext(DepInjectionAppLauncher.class)){
			Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
			
			System.out.println(context.getBean(BusinessClass.class));
		}
	}
}
