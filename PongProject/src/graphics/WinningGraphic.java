package graphics;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

import field.FieldHolder;
import field.GameField;
import ui.GameWindow;

public class WinningGraphic implements ScreenGraphic{
	
	//Font information for title
	static final int TITLE_FONT_SIZE = 100;
	static final Font TITLE_FONT = new Font(Font.MONOSPACED, Font.BOLD, TITLE_FONT_SIZE);
	
	//Font information for title
	static final String INSTRUCTION_TEXT = "[PRESS ANY KEY TO CONTINUE]";
	static final int INSTRUCTION_FONT_SIZE = 40;
	static final Font INSTRUCTION_FONT = new Font(Font.MONOSPACED, Font.BOLD, INSTRUCTION_FONT_SIZE);
	
	@Override
	public void draw(GameWindow _gameWindow, Graphics2D _g, FieldHolder _field) {
		
		GameField gameField = _field.getGameField();
		
		//Colors Background
		_g.setColor(Color.BLACK);
		_g.fillRect(0, 0, _gameWindow.getWidth(), _gameWindow.getHeight());
		
		_g.setColor(Color.WHITE);
		_g.setFont(TITLE_FONT);
		String winText = "PLAYER " + (gameField.getFirstPlayer().getScore() > gameField.getSecondPlayer().getScore() ? "1 " : "2 ") + "WINS!";
		_g.drawString(winText, _gameWindow.getMiddleX() - (_g.getFontMetrics(TITLE_FONT).stringWidth(winText) / 2), 400);
		
		_g.setColor(Color.WHITE);
		_g.setFont(INSTRUCTION_FONT);
		_g.drawString(INSTRUCTION_TEXT, _gameWindow.getMiddleX() - (_g.getFontMetrics(INSTRUCTION_FONT).stringWidth(INSTRUCTION_TEXT) / 2), 450);

	}
}
