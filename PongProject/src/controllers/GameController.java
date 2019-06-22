package controllers;

import field.Field;
import ui.GameWindow;

public class GameController{
	
	//GameController singleton
	private static GameController INSTANCE;
	
	//Game objects and window
	GameWindow gameWindow;
	Field field;
	
	//Thread and loop used for logic
	Thread gameThread;
	
	public GameController()
	{
		INSTANCE = this;
	}
	
	public void playPong()
	{
		field = new Field();
		
		gameWindow = new GameWindow();
		gameWindow.startPongGame();
		
		startThread();
	}
	
	//Runs the game loop of the game
	private void doGameLoop()
	{
		//Variables used for running the game
		boolean isRunning = true;
		long lastTime = System.currentTimeMillis();
		int targetFPS = 30;
		int desiredDelay = 1000 / targetFPS;
		
		while(isRunning)
		{	
			
			
			//Delays the game by the desired time to ensure the desired FPS
			long waitTime = desiredDelay - (System.currentTimeMillis() - lastTime);
			try { Thread.sleep(waitTime); } catch(Exception e) { e.printStackTrace(); }
			lastTime = System.currentTimeMillis();
		}
	}
	
	//Instantiates the thread and runs the game loop within the thread
	private void startThread()
	{
		gameThread = new Thread()
		{
			@Override
			public void run()
			{
				doGameLoop();
			}
		};
		
		gameThread.start();
	}
	
	public static GameController getInstance() { return INSTANCE; }
	
	public Field getField() { return field; }
}
