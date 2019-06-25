package controllers;

import java.awt.event.WindowEvent;

import gameObjects.GameField;
import ui.GameWindow;

public class GameController{
	
	public enum GAME_SCREEN
	{
		MENU, GAME, WINNING_SCREEN
	}
	
	//GameController singleton
	private static GameController INSTANCE;
	
	//Game objects and window
	private GameWindow gameWindow;
	private GAME_SCREEN currentGameScreen;
	private GameField field;
	
	//Controllers
	GraphicsController graphics;
	InputController input;
	LogicController logic;
	
	//Thread and loop used for logic
	private Thread gameThread;
	
	public GameController()
	{
		if(INSTANCE != null)
			INSTANCE.gameWindow.dispatchEvent(new WindowEvent(INSTANCE.gameWindow, WindowEvent.WINDOW_CLOSING));
		
		INSTANCE = this;
		currentGameScreen = GAME_SCREEN.GAME;
		
		graphics = new GraphicsController();
		input = new InputController();
		logic = new LogicController();
	}
	
	public void playPong()
	{
		field = new GameField();
		
		gameWindow = new GameWindow();
		gameWindow.addKeyListener(input);
		gameWindow.setVisible(true);
		
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
			//Display Graphics
			graphics.render(gameWindow, field);
			logic.doLogic(currentGameScreen, field, input.getPressedKeys());
			
			//Delays the game by the desired time to ensure the desired FPS
			long waitTime = desiredDelay - (System.currentTimeMillis() - lastTime);
			try { if(waitTime > 0) Thread.sleep(waitTime); } catch(Exception e) { e.printStackTrace(); }
			lastTime = System.currentTimeMillis();
			//System.out.println(waitTime);
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
	
	public GameField getField() { return field; }
}
