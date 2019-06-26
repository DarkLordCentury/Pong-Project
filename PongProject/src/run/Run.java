package run;

import controllers.GameController;

public class Run {

	public static void main(String[] args) {
		
		//Runs and plays pong
		GameController game = new GameController();
		game.playPong();
		
	}

}
