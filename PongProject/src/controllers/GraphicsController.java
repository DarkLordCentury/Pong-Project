package controllers;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

import field.GameField;
import gameObjects.MovingObject;
import gameObjects.PlayerObject;

public class GraphicsController {
	
	//Universal offset form the top
	static final int UNIVERSAL_TOP_OFFSET = 30;
	
	//Values for white line separating the two sides
	static final int MIDDLE_BOX_WIDTH = 4;
	static final int MIDDLE_BOX_HEIGHT = 8;
	static final int MIDDLE_BOX_SPACING = 4;
	
	//Values for score
	static final int FONT_TOP_OFFSET = 80;
	static final int FONT_MIDDLE_OFFSET = 10;
	static final int FONT_SIZE = 80;
	static final Font FONT = new Font(Font.MONOSPACED, Font.BOLD, FONT_SIZE);
	
	//Window Resizing Values
	
	
	public void render(JFrame _gameWindow, GameField _field)
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
	
	private void draw(JFrame _gameWindow, Graphics2D _g, GameField _field)
	{
		drawBackground(_gameWindow, _g);
		
		drawScore(_gameWindow, _g, _field.getFirstPlayer(), _field.getSecondPlayer());
		
		for(MovingObject moving : _field.getAllObjects())
			drawMovingObject(_gameWindow, _g, _field, moving);
	}
	
	private void drawBackground(JFrame _gameWindow, Graphics2D _g)
	{
		//Colors Background
		_g.setColor(Color.BLACK);
		_g.fillRect(0, 0, _gameWindow.getWidth(), _gameWindow.getHeight());
		
		_g.setColor(Color.WHITE);
		for(int y = 0; y < _gameWindow.getHeight(); y += MIDDLE_BOX_HEIGHT + MIDDLE_BOX_SPACING)
			_g.fillRect((_gameWindow.getWidth() / 2) - (MIDDLE_BOX_WIDTH / 2), y, MIDDLE_BOX_WIDTH, MIDDLE_BOX_HEIGHT);
	}
	
	private void drawScore(JFrame _gameWindow, Graphics2D _g, PlayerObject _player1, PlayerObject _player2)
	{
		_g.setColor(Color.DARK_GRAY);
		_g.setFont(FONT);
		
		String s1Score = "" + _player1.getScore();
		_g.drawString(s1Score, (_gameWindow.getWidth() / 2) - FONT_MIDDLE_OFFSET - _g.getFontMetrics().stringWidth(s1Score), UNIVERSAL_TOP_OFFSET + FONT_TOP_OFFSET);

		String s2Score = "" + _player2.getScore();
		_g.drawString(s2Score, (_gameWindow.getWidth() / 2) + FONT_MIDDLE_OFFSET, UNIVERSAL_TOP_OFFSET + FONT_TOP_OFFSET);
	}
	
	private void drawMovingObject(JFrame _gameWindow, Graphics2D _g, GameField _field, MovingObject _object)
	{
		if(_object.isVisible())
		{
			_g.setColor(Color.WHITE);
			_g.fillRect(_object.getX() + ((_gameWindow.getWidth() - _field.getWidth()) / 2), _object.getY() + UNIVERSAL_TOP_OFFSET + ((_gameWindow.getHeight() - _field.getHeight()) / 2), _object.getWidth(), _object.getHeight());
		}
	}
	
}
