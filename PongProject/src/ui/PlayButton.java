package ui;

import controllers.GameController;
import controllers.GameController.GAME_SCREEN;

public class PlayButton extends GameButton{

	public PlayButton(String _buttonText, int _x, int _y, int _fontSize) {
		super(_buttonText, _x, _y, _fontSize);
	}

	@Override
	public void onClick() {
		GameController.getInstance().setGameScreen(GAME_SCREEN.GAME);
	}

}
