package ui;

import java.awt.Dimension;

import javax.swing.JFrame;

public class GameWindow extends JFrame{
	
	private static final long serialVersionUID = 1407062426725680791L;
	
	public GameWindow()
	{
		super();
		
		//Create and set up the window
		this.setTitle("Pong");
		
		this.setSize(new Dimension(1000, 650));
		this.setExtendedState(this.getExtendedState() | JFrame.MAXIMIZED_BOTH);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	//Getters
	public int getMiddleX() { return getWidth() / 2; }
	public int getMiddleY() { return getHeight() / 2; }
	
}
