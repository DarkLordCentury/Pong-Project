package logic;

import field.FieldHolder;
import ui.GameButton;
import ui.GameWindow;
import util.InputHolder;

public class MenuLogic implements Logic{

	@Override
	public void doLogic(GameWindow _gameWindow, FieldHolder _field, InputHolder _inputs, double _timeDelta) {
		
		for(GameButton button : _field.getMenuField().getButtons())
		{
			if(button.isColliding(_inputs.getMouseX() - _gameWindow.getResizedXOffset(), _inputs.getMouseY()))
				button.setBorderVisible(true);
			else
				button.setBorderVisible(false);
			
			if(button.isColliding(_inputs.getMouseClickedX() - _gameWindow.getResizedXOffset(), _inputs.getMouseClickedY()))
				button.onClick();
		}
		
	}
	
	

}
