package logic;

import field.FieldHolder;
import ui.GameWindow;
import util.InputHolder;

public interface Logic {
	
	/**
	 * The logic that will run every frame
	 * @param _gameWindow The window of the game
	 * @param _field The game field
	 * @param _inputs The user inputs
	 * @param _timeDelta The time that has passed since the last frame in seconds
	 */
	public abstract void doLogic(GameWindow _gameWindow, FieldHolder _field, InputHolder _inputs, double _timeDelta);
	
	
	
}
