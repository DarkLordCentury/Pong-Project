package ui;

import controllers.GameController;
import controllers.GameController.GAME_SCREEN;

public class PlayButton extends GameButton{

	public PlayButton(String _buttonText, int _x, int _y) {
		super(_buttonText, _x, _y);
	}

	@Override
	public void onClick() {
		GameController.getInstance().setGameScreen(GAME_SCREEN.GAME);
	}

}
