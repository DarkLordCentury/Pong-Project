package controllers;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class InputController implements KeyListener{
	
	//Contains all the keys pressed within this frame
	private Set<Integer> pressed;
	
	public InputController()
	{
		pressed = new HashSet<Integer>();
	}

	@Override
	public void keyPressed(KeyEvent _k) {
		if(!pressed.contains(_k.getKeyCode()))
			pressed.add(_k.getKeyCode());
		
		//System.out.println(_k.getKeyCode());
	}

	@Override
	public void keyReleased(KeyEvent _k) {
		if(pressed.contains(_k.getKeyCode()))
			pressed.remove(_k.getKeyCode());
	}

	@Override
	public void keyTyped(KeyEvent _k) {
		
	}
	
	public Set<Integer> getPressedKeys() { return Collections.unmodifiableSet(pressed); }
	
}
