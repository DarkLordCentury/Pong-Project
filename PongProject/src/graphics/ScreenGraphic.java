package graphics;

import java.awt.Graphics2D;

import field.FieldHolder;
import ui.GameWindow;

public interface ScreenGraphic {
	
	public abstract void draw(GameWindow _gameWindow, Graphics2D _g, FieldHolder _field);
	
}
