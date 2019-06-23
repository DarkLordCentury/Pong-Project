package controllers;

import java.awt.Color;
import java.awt.Graphics2D;

import javax.swing.JFrame;

import field.GameField;
import gameObjects.MovingObject;

public class GraphicsController {
	
	static final int TOPOFFSET = 30;
	static final int MIDDLE_BOX_WIDTH = 4;
	static final int MIDDLE_BOX_HEIGHT = 8;
	static final int MIDDLE_BOX_SPACING = 4;
	
	public void render(JFrame _gameWindow, GameField _field)
	{
		Graphics2D g = null;
		try
		{
			g = (Graphics2D) _gameWindow.getGraphics();
			draw(_gameWindow, g, _field);
		} 
		catch(Exception e) { e.printStackTrace(); } 
		finally { g.dispose(); }
	}
	
	private void draw(JFrame _gameWindow, Graphics2D _g, GameField _field)
	{
		drawBackground(_gameWindow, _g);
		
		drawMovingObject(_gameWindow, _g, _field.getFirstPlayer());
		drawMovingObject(_gameWindow, _g, _field.getSecondPlayer());
		drawMovingObject(_gameWindow, _g, _field.getBall());
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
	
	private void drawMovingObject(JFrame _gameWindow, Graphics2D _g, MovingObject _object)
	{
		_g.setColor(Color.WHITE);
		_g.fillRect(_object.getX(), _object.getY() + TOPOFFSET, _object.getWidth(), _object.getHeight());
	}
	
}
