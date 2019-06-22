package controllers;

import java.awt.Color;
import java.awt.Graphics2D;

import javax.swing.JFrame;

import field.Field;
import gameObjects.MovingObject;

public class GraphicsController {
	
	public void render(JFrame _gameWindow, Field _field)
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
	
	private void draw(JFrame _gameWindow, Graphics2D _g, Field _field)
	{
		//Colors Background
		_g.setColor(Color.BLACK);
		_g.fillRect(0, 0, _gameWindow.getWidth(), _gameWindow.getHeight());
		
		drawMovingObject(_gameWindow, _g, _field.getFirstPlayer());
		drawMovingObject(_gameWindow, _g, _field.getSecondPlayer());
		drawMovingObject(_gameWindow, _g, _field.getBall());
	}
	
	private void drawMovingObject(JFrame _gameWindow, Graphics2D _g, MovingObject _object)
	{
		_g.setColor(Color.WHITE);
		_g.fillRect(_object.getX(), _object.getY(), _object.getWidth(), _object.getHeight());
	}
	
}
