package graphics;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

import field.FieldHolder;
import field.GameField;
import gameObjects.MovingObject;
import ui.GameWindow;

public class GameGraphic implements ScreenGraphic{

	static final int UNIVERSAL_Y_OFFSET = 10;
	
	//Height of top and bottom border
	static final int BORDER_HEIGHT = 4;
	
	//Values for white line separating the two sides
	static final int MIDDLE_BOX_WIDTH = 4;
	static final int MIDDLE_BOX_HEIGHT = 8;
	static final int MIDDLE_BOX_SPACING = 4;
	
	//Values for score
	static final int FONT_TOP_OFFSET = 120;
	static final int FONT_MIDDLE_OFFSET = 10;
	static final int FONT_SIZE = 80;
	static final Font FONT = new Font(Font.MONOSPACED, Font.BOLD, FONT_SIZE);
	
	@Override
	public void draw(GameWindow _gameWindow, Graphics2D _g, FieldHolder _field)
	{
		GameField gameField = _field.getGameField();
		
		drawBackground(_gameWindow, _g, gameField);
		
		drawScore(_gameWindow, _g, gameField);
		
		for(MovingObject moving : gameField.getAllObjects())
			drawMovingObject(_gameWindow, _g, gameField, moving);
	}
	
	
	private void drawBackground(GameWindow _gameWindow, Graphics2D _g, GameField _field)
	{
		//Colors Background
		_g.setColor(Color.BLACK);
		_g.fillRect(0, 0, _gameWindow.getWidth(), _gameWindow.getHeight());
		
		int topBorderY = resizeY(_gameWindow, _field, -BORDER_HEIGHT);
		int bottomBorderY = resizeY(_gameWindow, _field, _field.getHeight());
		_g.setColor(Color.WHITE);
		//Top Border
		_g.fillRect(0, topBorderY, _gameWindow.getWidth(), BORDER_HEIGHT);
		//Bottom Border
		_g.fillRect(0, bottomBorderY, _gameWindow.getWidth(), BORDER_HEIGHT);
		
		_g.setColor(Color.WHITE);
		for(int y = topBorderY; y < bottomBorderY; y += MIDDLE_BOX_HEIGHT + MIDDLE_BOX_SPACING)
			_g.fillRect(_gameWindow.getMiddleX() - (MIDDLE_BOX_WIDTH / 2), y, MIDDLE_BOX_WIDTH, MIDDLE_BOX_HEIGHT);
	}
	
	private void drawScore(GameWindow _gameWindow, Graphics2D _g, GameField _field)
	{
		_g.setColor(Color.DARK_GRAY);
		_g.setFont(FONT);
		
		String s1Score = "" + _field.getFirstPlayer().getScore();
		_g.drawString(s1Score, _gameWindow.getMiddleX() - FONT_MIDDLE_OFFSET - _g.getFontMetrics().stringWidth(s1Score), resizeY(_gameWindow, _field, FONT_TOP_OFFSET));

		String s2Score = "" + _field.getSecondPlayer().getScore();
		_g.drawString(s2Score, _gameWindow.getMiddleX() + FONT_MIDDLE_OFFSET, resizeY(_gameWindow, _field, FONT_TOP_OFFSET));
	}
	
	private void drawMovingObject(GameWindow _gameWindow, Graphics2D _g, GameField _field, MovingObject _object)
	{
		double widthPercent = _gameWindow.getResizedWidthPercent();
		double heightPercent = _gameWindow.getResizedHeightPercent();
		
		int x = resizeX(_gameWindow, _field,(int) _object.getRectX());
		int y = resizeY(_gameWindow, _field,(int) _object.getRectY());
		
		if(_object.isVisible())
		{
			_g.setColor(Color.WHITE);
			_g.fillRect(x, y, (int) (_object.getWidth() * widthPercent), (int) (_object.getHeight() * heightPercent));
		}
	}
	
	private int resizeX(GameWindow _gameWindow, GameField _field, int _x)
	{
		return (int) (_gameWindow.getMiddleX() - (((_field.getWidth() / 2) - _x) * _gameWindow.getResizedWidthPercent()));
	}
	
	private int resizeY(GameWindow _gameWindow, GameField _field, int _y)
	{
		return UNIVERSAL_Y_OFFSET + (int) (_gameWindow.getMiddleY() - (((_field.getHeight() / 2) - _y) * _gameWindow.getResizedHeightPercent()));
	}
	
	
	
}
