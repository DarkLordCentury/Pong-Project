package controllers;

import field.GameField;
import ui.GameWindow;

public class GameController{
	
	//GameController singleton
	private static GameController INSTANCE;
	
	//Game objects and window
	private GameWindow gameWindow;
	private GameField field;
	
	//Controllers
	GraphicsController graphics;
	InputController input;
	LogicController logic;
	
	//Thread and loop used for logic
	private Thread gameThread;
	
	public GameController()
	{
		INSTANCE = this;
		
		graphics = new GraphicsController();
		input = new InputController();
		logic = new LogicController();
	}
	
	public void playPong()
	{
		field = new GameField();
		
		gameWindow = new GameWindow();
		gameWindow.startPongGame();
		gameWindow.getGameWindow().addKeyListener(input);
		
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
			graphics.render(gameWindow.getGameWindow(), field);
			logic.DoLogic(field, input.getPressedKeys());
			
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
	
	public GameField getField() { return field; }
}
