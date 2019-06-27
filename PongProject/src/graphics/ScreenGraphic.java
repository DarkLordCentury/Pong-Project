package graphics;

import java.awt.Graphics2D;

import field.FieldHolder;
import ui.GameWindow;

public interface ScreenGraphic {
	
	/**
	 * Draws the desired graphics onto the screen
	 * @param _gameWindow The game window
	 * @param _g The graphics object that will be used to draw on the window
	 * @param _field The game window
	 */
	public abstract void draw(GameWindow _gameWindow, Graphics2D _g, FieldHolder _field);
	
}
