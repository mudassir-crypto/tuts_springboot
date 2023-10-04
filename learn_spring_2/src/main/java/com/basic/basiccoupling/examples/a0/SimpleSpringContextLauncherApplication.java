package com.basic.basiccoupling.examples.a0;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;



@Configuration
@ComponentScan("com.basic.basiccoupling.examples.a0")
public class SimpleSpringContextLauncherApplication {
	
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
		try(var context = new AnnotationConfigApplicationContext(SimpleSpringContextLauncherApplication.class)){
			Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
		}
	}
}
