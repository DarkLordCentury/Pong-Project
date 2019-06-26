package logic;

import field.FieldHolder;
import util.InputHolder;

public interface Logic {
	
	/**
	 * The logic that will run every frame
	 * @param _field The game field
	 * @param _inputs The user inputs
	 */
	public abstract void doLogic(FieldHolder _field, InputHolder _inputs);
	
	
	
}
