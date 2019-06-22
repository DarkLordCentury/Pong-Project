package ui;

import java.awt.Dimension;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class GameWindow {
	
	private static JFrame GAME_WINDOW;
	
	public void CreateWindow()
	{
		//Closes game window if it already exists
		if(GAME_WINDOW != null)
			GAME_WINDOW.dispatchEvent(new WindowEvent(GAME_WINDOW, WindowEvent.WINDOW_CLOSING));
		
		//Create and set up the window
		GAME_WINDOW = new JFrame("Pong");
		
		GAME_WINDOW.setSize(new Dimension(1000, 600));
		
		GAME_WINDOW.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		GAME_WINDOW.setVisible(true);
	}
	
	public JFrame GetGameWindow() { return GAME_WINDOW; }
	
}
