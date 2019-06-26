package logic;

import controllers.GameController;
import controllers.GameController.GAME_SCREEN;
import field.FieldHolder;
import util.InputHolder;

public class WinningLogic implements Logic{

	@Override
	public void doLogic(FieldHolder _field, InputHolder _inputs) {
		
		if(!_inputs.getReleasedKeys().isEmpty())
			GameController.getInstance().setGameScreen(GAME_SCREEN.MENU);
		
	}

}
