package com.basic.basiccoupling.game;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("ContraQualifier")
public class Contra implements GamingConsole{
	public void up() {
		System.out.println("Up");
	}
	
	public void down() {
		System.out.println("Sit Down");
	}
	
	public void left() {
		System.out.println("Go Back");
		
	}
	
	public void right() {
		System.out.println("Shoot a Bullet");
	}
}
