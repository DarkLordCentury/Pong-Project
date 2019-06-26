package field;

import ui.GameWindow;

public class FieldHolder {
	
	private MenuField menuField;
	private GameField gameField;
	
	/**
	 * Constructor for the field holder. Holds the desired fields for the game
	 * @param _gameWindow
	 */
	public FieldHolder(GameWindow _gameWindow)
	{
		menuField = new MenuField(_gameWindow);
		gameField = new GameField();
	}
	
	//Getters
	public MenuField getMenuField() { return menuField; }
	public GameField getGameField() { return gameField; }
	
	//Setters
	public void resetMenuField(GameWindow _gameWindow) { menuField = new MenuField(_gameWindow); }
	public void resetGameField() { gameField = new GameField(); }
	
}
