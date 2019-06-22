package controllers;

import ui.GameWindow;

public class GameController{
	
	//GameController singleton
	private static GameController INSTANCE;
	
	GameWindow gameWindow;
	
	public GameController()
	{
		INSTANCE = this;
	}
	
	public void PlayPong()
	{
		gameWindow = new GameWindow();
		gameWindow.CreateWindow();
	}
	
	
	
	public static GameController getInstance() { return INSTANCE; }
	
	public class GameLoop implements Runnable
	{

		@Override
		public void run() {
			// TODO Auto-generated method stub
			
		}
		
	}
}
