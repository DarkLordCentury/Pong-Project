package logic;

import controllers.GameController;
import controllers.GameController.GAME_SCREEN;
import field.FieldHolder;
import ui.GameWindow;
import util.InputHolder;

public class WinningLogic implements Logic{

	//The delay in ms before registering a key press when the screen first displays
	private static final long PRESS_DELAY = 1000;
	//The time in ms the screen first displayed
	private long startTime = -1;
	
	@Override
	public void doLogic(GameWindow _gameWindow, FieldHolder _field, InputHolder _inputs, double _timeDelta) {
		
		if(startTime == -1)
			startTime = System.currentTimeMillis();
		
		if(!_inputs.getReleasedKeys().isEmpty() && System.currentTimeMillis() - startTime > PRESS_DELAY)
		{
			startTime = -1;
			GameController.getInstance().setGameScreen(GAME_SCREEN.MENU);
		}
		
	}

}
