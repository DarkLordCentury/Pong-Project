package controllers;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import ui.GameWindow;
import util.InputHolder;

public class InputController{
	
	//Holds the input
	private InputHolder inputs;
	
	/**
	 * Constructor of InputController. Reads from user input and stores it into inputs object
	 * @param _gameWindow The current game window
	 */
	public InputController(GameWindow _gameWindow)
	{
		inputs = new InputHolder();
		
		AddKeyListener(_gameWindow);
		AddMouseListener(_gameWindow);
		AddMouseMotionListener(_gameWindow);
	}
	
	private void AddKeyListener(GameWindow _gameWindow)
	{
		_gameWindow.addKeyListener(new KeyListener()
		{
			@Override
			public void keyPressed(KeyEvent _k) {
				//Adds to the input holder
				if(!inputs.getPressedKeys().contains(_k.getKeyCode()))
					inputs.addPressedKey(_k.getKeyCode());
			}

			@Override
			public void keyReleased(KeyEvent _k) {
				//Removes from input holder
				if(inputs.getPressedKeys().contains(_k.getKeyCode()))
					inputs.removePressedKey(_k.getKeyCode());
				
				//Adds to input holder
				if(!inputs.getReleasedKeys().contains(_k.getKeyCode()))
					inputs.addReleasedKey(_k.getKeyCode());
			}

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
	
		});
	}
	
	private void AddMouseListener(GameWindow _gameWindow)
	{
		_gameWindow.addMouseListener(new MouseListener()
		{
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				inputs.setMouseClickedX(e.getX());
				inputs.setMouseClickedY(e.getY());
			}
	
		});
	}
	
	private void AddMouseMotionListener(GameWindow _gameWindow)
	{
		_gameWindow.addMouseMotionListener(new MouseMotionListener()
		{
			@Override
			public void mouseDragged(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseMoved(MouseEvent e) {
				inputs.setMouseX(e.getX());
				inputs.setMouseY(e.getY());
			}
	
		});
	}
	
	/**Resets the desired user inputs*/
	public void resetInputs()
	{
		inputs.resetMouseClicked();
		inputs.resetReleasedKeys();
	}
	
	public InputHolder getInputs() { return inputs; }
	
}
