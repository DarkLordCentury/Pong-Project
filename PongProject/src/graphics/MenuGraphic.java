package graphics;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

import field.FieldHolder;
import field.MenuField;
import ui.GameButton;
import ui.GameWindow;

public class MenuGraphic implements ScreenGraphic{
	
	static final int BORDER_THICKNESS = 4;
	static final int BORDER_SPACING = 8;
	
	//Font information for title
	static final int TITLE_FONT_SIZE = 170;
	static final Font TITLE_FONT = new Font(Font.MONOSPACED, Font.BOLD, TITLE_FONT_SIZE);
	
	@Override
	public void draw(GameWindow _gameWindow, Graphics2D _g, FieldHolder _field) {
		
		//Colors Background
		_g.setColor(Color.BLACK);
		_g.fillRect(0, 0, _gameWindow.getWidth(), _gameWindow.getHeight());
		
		_g.setColor(Color.WHITE);
		_g.setFont(TITLE_FONT);
		_g.drawString("PONG", _gameWindow.getMiddleX() - (_g.getFontMetrics(TITLE_FONT).stringWidth("PONG") / 2), 200);
		
		MenuField menu = _field.getMenuField();
		for(GameButton button : menu.getButtons())
			drawButton(_gameWindow, _g, button);
	}
	
	public void drawButton(GameWindow _gameWindow, Graphics2D _g, GameButton _button)
	{
		_g.setColor(Color.WHITE);
		_g.setFont(GameButton.getFont());
		_g.drawString(_button.getButtonText(), _button.getTextX(), _button.getTextY());
		
		if(_button.isBorderVisible())
			_g.drawRect(_button.getRectX(), _button.getRectY(), _button.getRectWidth(), _button.getRectHeight());
	}

}
