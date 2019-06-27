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
			//Checks if mouse is on top of a button. If it is then show border
			if(button.isColliding(_inputs.getMouseX(), _inputs.getMouseY()))
				button.setBorderVisible(true);
			else
				button.setBorderVisible(false);
			
			//Runs click function if button is clicked
			if(button.isColliding(_inputs.getMouseClickedX(), _inputs.getMouseClickedY()))
				button.onClick();
		}
		
	}

}
