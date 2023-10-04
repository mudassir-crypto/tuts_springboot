package com.basic.basiccoupling.game;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.basic.basiccoupling.game.GameRunner;
import com.basic.basiccoupling.game.GamingConsole;


@Configuration
@ComponentScan("com.basic.basiccoupling.game")
public class App02GamingSpringBeans {
	
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
		try(var context = new AnnotationConfigApplicationContext(App02GamingSpringBeans.class)){
			context.getBean(GamingConsole.class).up();
			context.getBean(GameRunner.class).run();
		}
	}
}
