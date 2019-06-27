package ui;

import java.awt.Font;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.font.FontRenderContext;
import java.awt.geom.AffineTransform;

public abstract class GameButton {
	
	//Button variables
	private String buttonText;
	private int originalFontSize;
	private Font font;
	private int x, y;
	//Used for collision detection
	private int rectX, rectY;
	//Holds whether or not the border is visible
	private boolean isBorderVisible;
	
	/**
	 * The constructor for a game button
	 * @param _buttonText The text being displayed
	 * @param _x The x position of the middle of the button
	 * @param _y The y position of the middle of the button
	 * @param _font The desired font being used
	 */
	public GameButton(String _buttonText, int _x, int _y, int _fontSize)
	{
		buttonText = _buttonText;
		originalFontSize = _fontSize;
		font = new Font(Font.MONOSPACED, Font.BOLD, _fontSize);
		
		x = _x;
		y = _y;
		
		rectX = x - (getTextWidth() / 2);
		rectY = y;
		
		isBorderVisible = false;
	}
	
	public abstract void onClick();
	
	/**
	 * Checks if rectangle is colliding with point
	 * @param _x The x position of the point
	 * @param _y The y position of the point
	 * @return Returns true if the point is within the bounds of the rectangle
	 */
	public boolean isColliding(int _x, int _y)
	{
		return this.getRectangle().contains(new Point(_x, _y));
	}
	
	//Getters
	public String getButtonText() { return buttonText; }
	public int getX() { return x; }
	public int getY() { return y; }
	public int getRectX() { return rectX; }
	public int getRectY() { return rectY; }
	public int getRectWidth() { return getTextWidth(); }
	public int getRectHeight() { return (int) (getTextHeight() / 1.9); }
	public int getTextX() { return x - getTextWidth() / 2; }
	public int getTextY() { return y + getTextHeight() / 2; }
	/**Calculates the width of the text using the font*/
	public int getTextWidth() 
	{ 
		AffineTransform affinetransform = new AffineTransform();     
		FontRenderContext frc = new FontRenderContext(affinetransform,true,true); 
		return (int)(font.getStringBounds(buttonText, frc).getWidth());
	}
	/**Calculates the height of the text using the font*/
	public int getTextHeight() 
	{ 
		AffineTransform affinetransform = new AffineTransform();     
		FontRenderContext frc = new FontRenderContext(affinetransform,true,true); 
		return (int)(font.getStringBounds(buttonText, frc).getHeight());
	}
	
	public int getOriginalFontSize() { return originalFontSize; }
	public Font getFont() { return font; }
	//Used for collision detection
	public Rectangle getRectangle() { return new Rectangle(getRectX(), getRectY(), getRectWidth(), getRectHeight()); }
	
	public boolean isBorderVisible() { return isBorderVisible; }
	
	//Setters
	public void setFontSize(int _fontSize) { font = new Font(Font.MONOSPACED, Font.BOLD, _fontSize); }
	public void setRectPosition(int _x, int _y) { rectX = _x; rectY = _y; }
	public void setBorderVisible(boolean _isBorderVisible) { isBorderVisible = _isBorderVisible; }
}
