package util;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class InputHolder {
	
	private int mouseX, mouseY;
	private int mouseClickedX, mouseClickedY;
	private Set<Integer> pressedInputs;
	private Set<Integer> releasedInputs;
	
	public InputHolder()
	{
		mouseX = 0;
		mouseY = 0;
		mouseClickedX = -1;
		mouseClickedY = -1;
		
		pressedInputs = new HashSet<Integer>();
		releasedInputs = new HashSet<Integer>();
	}
	
	//Getters
	public int getMouseX() { return mouseX; }
	public int getMouseY() { return mouseY; }
	/**
	 * The x position of the last click position
	 * @return The x of the last click position. Returns -1 if mouse wasn't clicked this frame.
	 */
	public int getMouseClickedX() { return mouseClickedX; }
	/**
	 * The y position of the last click position
	 * @return The y of the last click position. Returns -1 if mouse wasn't clicked this frame.
	 */
	public int getMouseClickedY() { return mouseClickedY; }
	public Set<Integer> getPressedKeys() { return Collections.unmodifiableSet(pressedInputs); }
	public Set<Integer> getReleasedKeys() { return Collections.unmodifiableSet(releasedInputs); }
	
	//Setters
	public void setMouseX(int _x) { mouseX = _x; }
	public void setMouseY(int _y) { mouseY = _y; }
	public void setMouseClickedX(int _x) { mouseClickedX = _x; }
	public void setMouseClickedY(int _y) { mouseClickedY = _y; }
	public void resetMouseClicked() { mouseClickedX = mouseClickedY = -1; }
	public void addPressedKey(int _pressed) { pressedInputs.add(_pressed); }
	public void removePressedKey(int _released) { pressedInputs.remove(_released); }
	public void addReleasedKey(int _released) { releasedInputs.add(_released); }
	public void resetReleasedKeys() { releasedInputs.clear(); }
	
}
