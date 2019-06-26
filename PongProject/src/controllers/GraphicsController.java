package controllers;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;

import controllers.GameController.GAME_SCREEN;
import field.FieldHolder;
import graphics.GameGraphic;
import graphics.MenuGraphic;
import graphics.ScreenGraphic;
import graphics.WinningGraphic;
import ui.GameWindow;

public class GraphicsController {
	
	//Holds all the screen graphics and what screen it will be displayed on
	private Map<GAME_SCREEN, ScreenGraphic> graphics;
	
	public GraphicsController()
	{
		//Instantiates the graphics and populates the hashmap
		graphics = new HashMap<GAME_SCREEN, ScreenGraphic>();
		graphics.put(GAME_SCREEN.GAME, new GameGraphic());
		graphics.put(GAME_SCREEN.MENU, new MenuGraphic());
		graphics.put(GAME_SCREEN.WINNING_SCREEN, new WinningGraphic());
	}
	
	/**
	 * Renders the desired graphics on to the screen
	 * @param _currGameScreen The current screen
	 * @param _gameWindow The game window
	 * @param _field The current field
	 */
	public void render(GAME_SCREEN _currGameScreen, GameWindow _gameWindow, FieldHolder _field)
	{
		//Graphics object use to draw
		Graphics2D g = null;
		//Holds the image of the entire screen
		BufferedImage bi = new BufferedImage(_gameWindow.getWidth(), _gameWindow.getHeight(), BufferedImage.TYPE_INT_RGB);
		try
		{
			g = (Graphics2D) bi.getGraphics();
			if(graphics.containsKey(_currGameScreen))
				graphics.get(_currGameScreen).draw(_gameWindow, g, _field);
		} 
		finally { _gameWindow.getGraphics().drawImage(bi, 0, 0, null); g.dispose(); }
	}
	
	
	
}
