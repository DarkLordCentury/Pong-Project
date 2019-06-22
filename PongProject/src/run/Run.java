package run;

import controllers.GameController;

public class Run {

	public static void main(String[] args) {
		
		GameController test = new GameController();
		test.playPong();
		
		System.out.println("Test");
	}

}
