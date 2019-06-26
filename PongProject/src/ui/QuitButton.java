package ui;

import controllers.GameController;

public class QuitButton extends GameButton {

	public QuitButton(String _buttonText, int _x, int _y) {
		super(_buttonText, _x, _y);
	}

	@Override
	public void onClick() {
		//Stops game loop
		GameController.getInstance().stopGame();
		//Closes window
		GameController.getInstance().getGameWindow().dispose();
	}

}
