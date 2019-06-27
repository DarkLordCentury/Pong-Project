package graphics;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

import field.FieldHolder;
import field.GameField;
import gameObjects.MovingObject;
import ui.GameWindow;

public class GameGraphic implements ScreenGraphic{

	//Y offset applied to almost every object
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
	
	//Values for instructions
	static final int INSTRUCTIONS_MINIMUM_WIDTH = 650; //Instructions will disappear if window is this thin
	static final int INSTRUCTIONS_FIRST_TOP_OFFSET = 285;
	static final int INSTRUCTIONS_SECOND_TOP_OFFSET = 325;
	static final int INSTRUCTIONS_MIDDLE_OFFSET = 30;
	static final int INSTRUCTIONS_FONT_SIZE = 20;
	static final Font INSTRUCTIONS_FONT = new Font(Font.MONOSPACED, Font.BOLD, INSTRUCTIONS_FONT_SIZE);
	
	@Override
	public void draw(GameWindow _gameWindow, Graphics2D _g, FieldHolder _field)
	{
		GameField gameField = _field.getGameField();
		
		drawBackground(_gameWindow, _g, gameField);
		
		drawScore(_gameWindow, _g, gameField);
		drawInstructions(_gameWindow, _g, gameField);
		
		for(MovingObject moving : gameField.getAllObjects())
			drawMovingObject(_gameWindow, _g, gameField, moving);
	}
	
	
	private void drawBackground(GameWindow _gameWindow, Graphics2D _g, GameField _field)
	{
		//Colors Background
		_g.setColor(Color.BLACK);
		_g.fillRect(0, 0, _gameWindow.getWidth(), _gameWindow.getHeight());
		
		int topBorderY = resizeGameY(_gameWindow, _field, -BORDER_HEIGHT);
		int bottomBorderY = resizeGameY(_gameWindow, _field, _field.getHeight());
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
		//Formats graphics
		_g.setColor(Color.GRAY);
		_g.setFont(FONT);
		
		//Draws first player score
		String s1Score = "" + _field.getFirstPlayer().getScore();
		_g.drawString(s1Score, _gameWindow.getMiddleX() - FONT_MIDDLE_OFFSET - _g.getFontMetrics().stringWidth(s1Score), resizeGameY(_gameWindow, _field, FONT_TOP_OFFSET));
	
		//Draws second player score
		String s2Score = "" + _field.getSecondPlayer().getScore();
		_g.drawString(s2Score, _gameWindow.getMiddleX() + FONT_MIDDLE_OFFSET, resizeGameY(_gameWindow, _field, FONT_TOP_OFFSET));
	}
	
	private void drawInstructions(GameWindow _gameWindow, Graphics2D _g, GameField _field)
	{
		if(_gameWindow.getWidth() > INSTRUCTIONS_MINIMUM_WIDTH)
		{
			//Formats graphics
			_g.setColor(Color.DARK_GRAY);
			_g.setFont(INSTRUCTIONS_FONT);
			
			//Draws first player instructions
			String firstPlayerUp = "Move Up: W";
			String firstPlayerDown = "Move Down: S";
			_g.drawString(firstPlayerUp, _gameWindow.getMiddleX() - INSTRUCTIONS_MIDDLE_OFFSET - _g.getFontMetrics().stringWidth(firstPlayerUp), resizeGameY(_gameWindow, _field, INSTRUCTIONS_FIRST_TOP_OFFSET));
			_g.drawString(firstPlayerDown, _gameWindow.getMiddleX() - INSTRUCTIONS_MIDDLE_OFFSET - _g.getFontMetrics().stringWidth(firstPlayerDown), resizeGameY(_gameWindow, _field, INSTRUCTIONS_SECOND_TOP_OFFSET));
			
			//Draws second player instructions
			String secondPlayerUp = "Move Up: Arrow Up";
			String secondPlayerDown = "Move Down: Arrow Down";
			_g.drawString(secondPlayerUp, _gameWindow.getMiddleX() + INSTRUCTIONS_MIDDLE_OFFSET, resizeGameY(_gameWindow, _field, INSTRUCTIONS_FIRST_TOP_OFFSET));
			_g.drawString(secondPlayerDown, _gameWindow.getMiddleX() + INSTRUCTIONS_MIDDLE_OFFSET, resizeGameY(_gameWindow, _field, INSTRUCTIONS_SECOND_TOP_OFFSET));
		}
	}
	
	private void drawMovingObject(GameWindow _gameWindow, Graphics2D _g, GameField _field, MovingObject _object)
	{	
		//Draws the object if it is visible
		if(_object.isVisible())
		{
			//Used for resizing
			double widthPercent = _gameWindow.getResizedWidthPercent();
			double heightPercent = _gameWindow.getResizedHeightPercent();
			
			//Resizes x and y positions
			int x = resizeGameX(_gameWindow, _field,(int) _object.getRectX());
			int y = resizeGameY(_gameWindow, _field,(int) _object.getRectY());
			
			_g.setColor(Color.WHITE);
			_g.fillRect(x, y, (int) (_object.getWidth() * widthPercent), (int) (_object.getHeight() * heightPercent));
		}
	}
	
	/**
	 * Resizes the x position of an object to fit different screens
	 * @param _gameWindow The game window
	 * @param _field The game field
	 * @param _x The x position that will be altered
	 * @return The desired x position relative to the new window size
	 */
	private int resizeGameX(GameWindow _gameWindow, GameField _field, int _x)
	{
		return (int) (_gameWindow.getMiddleX() - (((_field.getWidth() / 2) - _x) * _gameWindow.getResizedWidthPercent()));
	}
	/**
	 * Resizes the y position of an object to fit different screens
	 * @param _gameWindow The game window
	 * @param _field The game field
	 * @param _y The y position that will be altered
	 * @return The desired y position relative to the new window size
	 */
	private int resizeGameY(GameWindow _gameWindow, GameField _field, int _y)
	{
		return UNIVERSAL_Y_OFFSET + (int) (_gameWindow.getMiddleY() - (((_field.getHeight() / 2) - _y) * _gameWindow.getResizedHeightPercent()));
	}
	
	
	
}
