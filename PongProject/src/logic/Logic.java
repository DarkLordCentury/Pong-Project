package logic;

import java.util.Set;

import controllers.GameController.GAME_SCREEN;
import field.GameField;

public abstract class Logic {
	
	//Logic will only run if the current screen is the desired screen
	private GAME_SCREEN targetScreen;
	
	/**
	 * Constructor for Logic
	 * @param _targetScreen The screen this logic will run on
	 */
	public Logic(GAME_SCREEN _targetScreen)
	{
		targetScreen = _targetScreen;
	}
	
	/**
	 * The logic that will run every frame
	 * @param _field The game field
	 * @param _inputs The user inputs
	 */
	protected abstract void logic(GameField _field, Set<Integer> _inputs);
	
	/**
	 * Runs the logic found within the logic object
	 * @param _currScreen The current screen
	 * @param _field The game field
	 * @param _inputs The user inputs
	 */
	public void doLogic(GAME_SCREEN _currScreen, GameField _field, Set<Integer> _inputs)
	{
		if(_currScreen == targetScreen)
			logic(_field, _inputs);
	}
	
	
	
}
