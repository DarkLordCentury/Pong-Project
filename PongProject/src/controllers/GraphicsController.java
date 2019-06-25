package controllers;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import gameObjects.GameField;
import gameObjects.MovingObject;
import ui.GameWindow;

public class GraphicsController {
	
	//Height of top and bottom border
	static final int BORDER_HEIGHT = 4;
	
	//Values for white line separating the two sides
	static final int MIDDLE_BOX_WIDTH = 4;
	static final int MIDDLE_BOX_HEIGHT = 8;
	static final int MIDDLE_BOX_SPACING = 4;
	
	//Values for score
	static final int FONT_TOP_OFFSET = 80;
	static final int FONT_MIDDLE_OFFSET = 10;
	static final int FONT_SIZE = 80;
	static final Font FONT = new Font(Font.MONOSPACED, Font.BOLD, FONT_SIZE);
	
	public void render(GameWindow _gameWindow, GameField _field)
	{
		Graphics2D g = null;
		BufferedImage bi = new BufferedImage(_gameWindow.getWidth(), _gameWindow.getHeight(), BufferedImage.TYPE_INT_RGB);
		try
		{
			g = (Graphics2D) bi.getGraphics();
			draw(_gameWindow, g, _field);
		} 
		catch(Exception e) { e.printStackTrace(); } 
		finally { _gameWindow.getGraphics().drawImage(bi, 0, 0, null); g.dispose(); }
	}
	
	private void draw(GameWindow _gameWindow, Graphics2D _g, GameField _field)
	{
		drawBackground(_gameWindow, _g, _field);
		
		drawScore(_gameWindow, _g, _field);
		
		for(MovingObject moving : _field.getAllObjects())
			drawMovingObject(_gameWindow, _g, _field, moving);
	}
	
	private void drawBackground(GameWindow _gameWindow, Graphics2D _g, GameField _field)
	{
		//Colors Background
		_g.setColor(Color.BLACK);
		_g.fillRect(0, 0, _gameWindow.getWidth(), _gameWindow.getHeight());
		
		int topBorderY = ((_gameWindow.getHeight() - _field.getHeight()) / 2) - BORDER_HEIGHT;
		int bottomBorderY = _gameWindow.getHeight() - ((_gameWindow.getHeight() - _field.getHeight()) / 2) + BORDER_HEIGHT;
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
		_g.drawString(s1Score, _gameWindow.getMiddleX() - FONT_MIDDLE_OFFSET - _g.getFontMetrics().stringWidth(s1Score),FONT_TOP_OFFSET + ((_gameWindow.getHeight() - _field.getHeight()) / 2));

		String s2Score = "" + _field.getSecondPlayer().getScore();
		_g.drawString(s2Score, _gameWindow.getMiddleX() + FONT_MIDDLE_OFFSET, FONT_TOP_OFFSET + ((_gameWindow.getHeight() - _field.getHeight()) / 2));
	}
	
	private void drawMovingObject(GameWindow _gameWindow, Graphics2D _g, GameField _field, MovingObject _object)
	{
		if(_object.isVisible())
		{
			_g.setColor(Color.WHITE);
			_g.fillRect(_object.getX() + ((_gameWindow.getWidth() - _field.getWidth()) / 2), _object.getY() + ((_gameWindow.getHeight() - _field.getHeight()) / 2), _object.getWidth(), _object.getHeight());
		}
	}
	
}
