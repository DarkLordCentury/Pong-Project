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
		
		this.setSize(new Dimension(1000, 700));
		this.setPreferredSize(new Dimension(1000, 700));
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setVisible(true);
		//this.setResizable(false);
	}
	
	public int resizeX(int _x)
	{
		return (int) (this.getMiddleX() - (((this.getPreferredSize().getWidth() / 2) - _x) * this.getResizedWidthPercent()));
	}
	
	public int resizeY(int _y)
	{
		return (int) (this.getMiddleY() - (((this.getPreferredSize().getHeight() / 2) - _y) * this.getResizedHeightPercent()));
	}
	
	//Getters
	public int getMiddleX() { return getWidth() / 2; }
	public int getMiddleY() { return getHeight() / 2; }
	
	public int getResizedXOffset() { return (int) (this.getWidth() - this.getPreferredSize().getWidth()) / 2; }
	public int getResizedYOffset() { return (int) (this.getHeight() - this.getPreferredSize().getHeight()) / 2; }
	
	public double getResizedWidthPercent() { return this.getWidth() / this.getPreferredSize().getWidth(); }
	public double getResizedHeightPercent() { return this.getHeight() / this.getPreferredSize().getHeight(); }
}
