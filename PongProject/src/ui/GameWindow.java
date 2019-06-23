package ui;

import java.awt.Dimension;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GameWindow {
	
	private static JFrame GAME_WINDOW;
	private static JPanel CURR_CANVAS;
	
	public void CreateWindow()
	{
		//Closes game window if it already exists
		if(GAME_WINDOW != null)
			GAME_WINDOW.dispatchEvent(new WindowEvent(GAME_WINDOW, WindowEvent.WINDOW_CLOSING));
		
		//Create and set up the window
		GAME_WINDOW = new JFrame("Pong");
		
		GAME_WINDOW.setSize(new Dimension(800, 650));
		
		GAME_WINDOW.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		GAME_WINDOW.setVisible(true);
	}
	
	public void startPongGame()
	{
		//Ensure there is only one game window and one canvas
		if(GAME_WINDOW == null)
			CreateWindow();
		if(CURR_CANVAS != null)
			GAME_WINDOW.remove(CURR_CANVAS);
		
		CURR_CANVAS = new GamePanel();
		GAME_WINDOW.add(CURR_CANVAS);
	}
	
	//Getters
	public JFrame getGameWindow() { return GAME_WINDOW; }
	public JPanel getCurrPanel() { return CURR_CANVAS; }
	
}
