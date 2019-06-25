package logic;

import java.util.Set;

import gameObjects.GameField;

public interface Logic {
	
	/**
	 * The logic that will run every frame
	 * @param _field The game field
	 * @param _inputs The user inputs
	 */
	public abstract void logic(GameField _field, Set<Integer> _inputs);
	
	
	
}
