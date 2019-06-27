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
	static Font TITLE_FONT = new Font(Font.MONOSPACED, Font.BOLD, TITLE_FONT_SIZE);
	
	@Override
	public void draw(GameWindow _gameWindow, Graphics2D _g, FieldHolder _field) {
		
		//Colors Background
		_g.setColor(Color.BLACK);
		_g.fillRect(0, 0, _gameWindow.getWidth(), _gameWindow.getHeight());
		
		double resizePercent = Math.min(_gameWindow.getResizedHeightPercent(), _gameWindow.getResizedWidthPercent());
		
		_g.setColor(Color.WHITE);
		TITLE_FONT = new Font(Font.MONOSPACED, Font.BOLD, (int) (TITLE_FONT_SIZE * resizePercent));
		_g.setFont(TITLE_FONT);
		_g.drawString("PONG", _gameWindow.getMiddleX() - (_g.getFontMetrics(TITLE_FONT).stringWidth("PONG") / 2), _gameWindow.resizeY(200));
		
		MenuField menu = _field.getMenuField();
		for(GameButton button : menu.getButtons())
			drawButton(_gameWindow, _g, button);
	}

	public void drawButton(GameWindow _gameWindow, Graphics2D _g, GameButton _button)
	{
		double resizePercent = Math.min(_gameWindow.getResizedHeightPercent(), _gameWindow.getResizedWidthPercent());
		_button.setFontSize((int) (_button.getOriginalFontSize() * resizePercent));
		
		_g.setColor(Color.WHITE);
		_g.setFont(_button.getFont());
		int x = _button.getTextX() + _gameWindow.getResizedXOffset();
		int y = 10 + _gameWindow.resizeY(_button.getTextY());
		_g.drawString(_button.getButtonText(), x, y);
		
		_button.setRectPosition(x, (int) (y - _button.getTextHeight() / 2.1));
		
		if(_button.isBorderVisible())
			_g.drawRect(_button.getRectX(), _button.getRectY(), _button.getRectWidth(), _button.getRectHeight());
	}
}
