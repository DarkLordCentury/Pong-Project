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
	
	//Font information for title
	static final String INSTRUCTION_TEXT = "[PRESS ANY KEY TO CONTINUE]";
	static final int INSTRUCTION_FONT_SIZE = 40;
	
	@Override
	public void draw(GameWindow _gameWindow, Graphics2D _g, FieldHolder _field) {
		
		GameField gameField = _field.getGameField();
		double resizePercent = Math.min(_gameWindow.getResizedHeightPercent(), _gameWindow.getResizedWidthPercent());

		//Colors Background
		_g.setColor(Color.BLACK);
		_g.fillRect(0, 0, _gameWindow.getWidth(), _gameWindow.getHeight());
		
		//Draws the player winner text
		_g.setColor(Color.WHITE);
		Font titleFont = new Font(Font.MONOSPACED, Font.BOLD, (int) (TITLE_FONT_SIZE * resizePercent));
		_g.setFont(titleFont);
		String winText = "PLAYER " + (gameField.getFirstPlayer().getScore() > gameField.getSecondPlayer().getScore() ? "1 " : "2 ") + "WINS!";
		_g.drawString(winText, _gameWindow.getMiddleX() - (_g.getFontMetrics(titleFont).stringWidth(winText) / 2), _gameWindow.resizeY(400));
		
		//Draws the instructions text
		_g.setColor(Color.WHITE);
		Font instructionFont = new Font(Font.MONOSPACED, Font.BOLD, (int) (INSTRUCTION_FONT_SIZE * resizePercent));
		_g.setFont(instructionFont);
		_g.drawString(INSTRUCTION_TEXT, _gameWindow.getMiddleX() - (_g.getFontMetrics(instructionFont).stringWidth(INSTRUCTION_TEXT) / 2), _gameWindow.resizeY(450));

	}
}
