package graphics;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

import field.FieldHolder;
import ui.GameButton;
import ui.GameWindow;

public class MenuGraphic implements ScreenGraphic{
	
	//Font information for title
	static final int TITLE_FONT_SIZE = 170;
	Font titleFont = new Font(Font.MONOSPACED, Font.BOLD, TITLE_FONT_SIZE);
	
	@Override
	public void draw(GameWindow _gameWindow, Graphics2D _g, FieldHolder _field) {
		
		//Colors Background
		_g.setColor(Color.BLACK);
		_g.fillRect(0, 0, _gameWindow.getWidth(), _gameWindow.getHeight());
		
		drawTitle(_gameWindow, _g);
		
		//Draw buttons
		for(GameButton button : _field.getMenuField().getButtons())
			drawButton(_gameWindow, _g, button);
	}

	//Draws the PONG title
	private void drawTitle(GameWindow _gameWindow, Graphics2D _g)
	{
		double resizePercent = Math.min(_gameWindow.getResizedHeightPercent(), _gameWindow.getResizedWidthPercent());
		
		_g.setColor(Color.WHITE);
		titleFont = new Font(Font.MONOSPACED, Font.BOLD, (int) (TITLE_FONT_SIZE * resizePercent));
		_g.setFont(titleFont);
		_g.drawString("PONG", _gameWindow.getMiddleX() - (_g.getFontMetrics(titleFont).stringWidth("PONG") / 2), _gameWindow.resizeY(200));
	}
	
	private void drawButton(GameWindow _gameWindow, Graphics2D _g, GameButton _button)
	{
		//Finds the desired resize percent
		double resizePercent = Math.min(_gameWindow.getResizedHeightPercent(), _gameWindow.getResizedWidthPercent());
		//Resizes font
		_button.setFontSize((int) (_button.getOriginalFontSize() * resizePercent));
		
		//Draws the button
		_g.setColor(Color.WHITE);
		_g.setFont(_button.getFont());
		int x = _button.getTextX() + _gameWindow.getResizedXOffset();
		int y = 10 + _gameWindow.resizeY(_button.getTextY());
		_g.drawString(_button.getButtonText(), x, y);
		
		//Sets the rectangle position of the button to the new resized ones
		_button.setRectPosition(x, (int) (y - _button.getTextHeight() / 2.1));
		
		//Displays border if it is desired (Mouse is over the button)
		if(_button.isBorderVisible())
			_g.drawRect(_button.getRectX(), _button.getRectY(), _button.getRectWidth(), _button.getRectHeight());
	}
}
