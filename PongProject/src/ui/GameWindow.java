package ui;

import java.awt.*;
import javax.swing.*;

public class GameWindow {
	
	private static JFrame GAME_WINDOW;
	
	public static void CreateWindow()
	{
		//Create and set up the window
		GAME_WINDOW = new JFrame("PONG");
	}
	
	public static JFrame GetGameWindow() { return GAME_WINDOW; }
	
}
