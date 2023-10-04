package com.basic.basiccoupling1;

import com.basic.basiccoupling.game.Contra;
import com.basic.basiccoupling.game.GameRunner;
import com.basic.basiccoupling.game.MarioGame;
import com.basic.basiccoupling.game.Pacman;


public class App01Gaming {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//var game = new MarioGame();
		//var game = new Contra();
		var game = new Pacman();
		var gameRunner = new GameRunner(game);
		gameRunner.run();
	}

}
